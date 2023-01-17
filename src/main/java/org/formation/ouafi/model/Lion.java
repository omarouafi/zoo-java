/**
 * 
 */
package org.formation.ouafi.model;

import org.formation.ouafi.model.technique.BeurkException;

/**
 * @author jacques
 * 
 *
 */
public  final class Lion extends Animal{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Lion() {
		this("Leo",34,156);
	}
	
	/**
	 * @param age
	 * @param nom
	 * @param poids
	 */
	public Lion(String nom, int age, double poids) {
		super(nom,age,poids,230.0);
	}
	/**
	 * 
	 */
	public void manger() {
		setPoids(getPoids() + 1.9);
	}
	/**
	 * m�canisme de la surcharge 
	 * @param aManger lza gazelle qui doit etre mangee et tu�e!!!!
	 * @Deprecated 
	 */
	@Override
	@Deprecated
	public String manger(Gazelle aManger) {
		setPoids(getPoids()+aManger.getPoids()/3);
		return "Miam miam";
	}
	
	@Override
	public String manger(Mangeable m) throws BeurkException {
		String ret = "Miam miam";
		if (m != null) {
			setPoids(getPoids()+m.prelever()/3);
		}
		return ret;
	}

	/**
	 * 
	 * @return le cri sous forme de string (xml,JSON,csv)
	 */
	@Override
	public String crier() {
		setPoids(getPoids()-0.003);
		return "je rugis!!!! woaw!!!!!";
	}

	@Override
	public void dormir() {
		setPoids(getPoids()-0.750);
		
	}


}
