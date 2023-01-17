package org.formation.ouafi.model;

public class Girafe extends Animal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Girafe() {
		this("GGGGGGGG",1,55);
	}

	public Girafe( String nom, int age,double poids) {
		super(nom, age, poids,800);
	}

	@Override
	public void dormir() {
		// TODO a finir
		
	}

	@Override
	public void manger() {
		// TODO a finir
		
	}

}
