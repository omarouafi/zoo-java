package org.formation.ouafi.controlleur;

import java.util.List;
import java.util.Vector;

import org.formation.ouafi.model.Animal;
import org.formation.ouafi.model.Cage;
import org.formation.ouafi.model.Gazelle;
import org.formation.ouafi.model.Lion;
import org.formation.ouafi.model.Mangeable;
import org.formation.ouafi.model.Singe;
import org.formation.ouafi.model.technique.BeurkException;
import org.formation.ouafi.model.technique.CagePleineException;
import org.formation.ouafi.model.technique.PorteException;

/**
 * 
 * @author jacques
 *
 */
public class Zoo {
	private List<Cage> lesCages;
	public Zoo() {
		lesCages = null;
		init();
	}
	/**
	 * méthode privée qui rempli la liste si aucun fichier n'est trouvé
	 */
	private void init()
	{
		Cage tmp = null;
		lesCages = new Vector<Cage>();
		try {
			System.out.println("eed");
			tmp = new Cage(101,201);
			tmp.ouvrir();
				tmp.entrer(new Singe("Cheeta",2,25));
			tmp.fermer();
			lesCages.add(tmp);
			
			tmp = new Cage(100,50);
			tmp.ouvrir();
			tmp.entrer(new Lion("Simba",3,20));
			tmp.fermer();
			lesCages.add(tmp);
			
			tmp = new Cage(150,250); //CAGE VIDE
			tmp.fermer();
			lesCages.add(tmp);
			
			tmp = new Cage(90,230);
			tmp.ouvrir();
			tmp.entrer(new Gazelle("Lady Gaga",20,75,10));
			tmp.fermer();
			lesCages.add(tmp);
			
			tmp = new Cage(60,100);
			tmp.ouvrir();
			tmp.entrer(new Singe("Baloo",30,30));
			tmp.fermer();
			lesCages.add(tmp);
		} catch (PorteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CagePleineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	/**
	 * Permet de nourrir tous les animaux du zoo
	 */
	public void nourrir ()
	{
		for (int i = 0; i < lesCages.size(); i++) {
			if (lesCages.get(i).getOccupant() != null)
			{
				lesCages.get(i).getOccupant().manger();
			}
		}
	}
	/**
	 * 
	 * @param mangeur indice de l'animal mangeur (sa cage)
	 * @param mange indice de la cage de la proie
	 * @return le texte sur ce qu'il s'est passé
	 */
	public String devorer(int mangeur, int mange)
	{
		Mangeable laBeteConvoitee = null;
		String s = "INCOMPATIBLE";
		if (lesCages.get(mange).getOccupant() != null && lesCages.get(mangeur).getOccupant() != null && lesCages.get(mange).getOccupant() instanceof Mangeable)
			{
				lesCages.get(mange).ouvrir();
				try {
					laBeteConvoitee = (Mangeable)lesCages.get(mange).sortir();
				} catch (PorteException e2) {
					e2.printStackTrace();
				}
				try
				{
					s = lesCages.get(mangeur).getOccupant().manger(laBeteConvoitee);
				}
				catch (BeurkException e)
				{
					s = e.getMessage();
					try {
						lesCages.get(mange).entrer((Animal)laBeteConvoitee);
					} catch (PorteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (CagePleineException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					lesCages.get(mange).fermer();
				}
		}
		return s;
	}

	public List<String> getInfos() {
		List<String> ret = new Vector<String>();
		for (Cage cage:lesCages) {
			ret.add(cage.toString());
		}
		return ret;

	}

	

}
