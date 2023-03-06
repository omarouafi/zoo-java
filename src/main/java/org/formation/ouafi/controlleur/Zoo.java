package org.formation.ouafi.controlleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

import org.formation.ouafi.model.Animal;
import org.formation.ouafi.model.Mangeable;
import org.formation.ouafi.model.technique.BeurkException;
import org.formation.ouafi.model.technique.CagePleineException;
import org.formation.ouafi.model.technique.PorteException;
import org.formation.ouafi.service.CagePersistante;
import org.formation.ouafi.service.CagePojo;
import org.formation.ouafi.stockage.Dao;
import org.formation.ouafi.stockage.DaoMemoire;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Zoo {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("zooSpring.xml");
	private static Zoo instance = ctx.getBean("manager",Zoo.class);
	private List<CagePersistante> lesCages;
	private Dao<CagePojo> dao;
	public Dao<CagePojo> getDao() {
		return dao;
	}

	public void setDao(Dao<CagePojo> dao) {
		this.dao = dao;
	}

	private Zoo() {
		lesCages = new Vector<>();
		dao = new DaoMemoire();
		lesCages = dao.lireTous().stream().map(cp->new CagePersistante(cp.getIdAnimal(), dao)).toList();
	}


	public void nourrir() {
		for (int i = 0; i < lesCages.size(); i++) {
			if (lesCages.get(i).getOccupant() != null) {
				lesCages.get(i).nourrirOccupant();
			}
		}
	}


	public String devorer(int mangeur, int mange) {
		Mangeable laBeteConvoitee = null;
		String s = "INCOMPATIBLE";
		if (lesCages.get(mange).getOccupant() != null && lesCages.get(mangeur).getOccupant() != null
				&& lesCages.get(mange).getOccupant() instanceof Mangeable) {
			lesCages.get(mange).ouvrir();
			try {
				laBeteConvoitee = (Mangeable) lesCages.get(mange).sortir();
			} catch (PorteException e2) {
				e2.printStackTrace();
			}
			try {
				s = lesCages.get(mangeur).getOccupant().manger(laBeteConvoitee);
			} catch (BeurkException e) {
				s = e.getMessage();
				try {
					lesCages.get(mange).entrer((Animal) laBeteConvoitee);
				} catch (PorteException | CagePleineException e1) {
					System.err.println(e1);
				}
				lesCages.get(mange).fermer();
			}
		}
		return s;
	}

	public List<String> getInfos() {
		List<String> ret = new ArrayList<>();
		for (CagePersistante cage : lesCages) {
			ret.add(cage.toString());
		}
		return ret;

	}
	
	public List<CagePojo> getPojos(){
		return lesCages.stream().map(cp -> cp.getCagePojo()).toList();
	}

	public static Zoo getInstance() {
		return instance;
	}

}
