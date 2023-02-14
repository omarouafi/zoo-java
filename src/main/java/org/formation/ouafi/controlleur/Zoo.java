package org.formation.ouafi.controlleur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.formation.ouafi.model.Animal;
import org.formation.ouafi.model.Mangeable;
import org.formation.ouafi.model.technique.BeurkException;
import org.formation.ouafi.model.technique.CagePleineException;
import org.formation.ouafi.model.technique.PorteException;
import org.formation.ouafi.service.CagePersistante;
import org.formation.ouafi.service.CagePojo;
import org.formation.ouafi.stockage.Dao;
import org.formation.ouafi.stockage.DaoFactory;


/**
 *
 * @author jacques
 *
 */
public class Zoo {
	private static Zoo instance = new Zoo();
	private List<CagePersistante> lesCages;
	private Dao<CagePojo> dao;

	private Zoo() {
		lesCages = new Vector<>();
		dao = DaoFactory.getInstance().getDao();
		lesCages = dao.lireTous().stream().map(cp->new CagePersistante(cp.getIdAnimal(), dao)).collect(Collectors.toList());
	}

	/**
	 * Permet de nourrir tous les animaux du zoo
	 */
	public void nourrir() {
		for (int i = 0; i < lesCages.size(); i++) {
			if (lesCages.get(i).getOccupant() != null) {
				lesCages.get(i).nourrirOccupant();
			}
		}
	}

	/**
	 *
	 * @param mangeur indice de l'animal mangeur (sa cage)
	 * @param mange   indice de la cage de la proie
	 * @return le texte sur ce qu'il s'est passé
	 */
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
					System.out.println(e1);
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

	public static Zoo getInstance() {
		return instance;
	}

}
