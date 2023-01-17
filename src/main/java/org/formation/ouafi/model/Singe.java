/**
 * 
 */
package org.formation.ouafi.model;

/**
 * @author jacques
 *
 */
public class Singe extends Animal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Singe() {
		this("Cheeta",2,34);
	}

	/**
	 * @param age
	 * @param nom
	 * @param poids
	 */
	public Singe(String nom, int age, double poids) {
		super(nom, age, poids,45);
	}
	@Override
	public void manger() {
		setPoids(getPoids()+0.35);
	}

	@Override
	public void dormir() {
		setPoids(getPoids()-0.12);
	}

}
