package org.formation.ouafi.view;

import org.formation.ouafi.controlleur.Zoo;

public class Lanceur {
	private Zoo z;
	public Lanceur() {
		z = Zoo.getInstance();
	}
	public void afficher() {
		for (String s : z.getInfos()) {
			System.out.println(s);
		}
		
	}
	public void nourrir() {
		z.nourrir();
	}
	public void go() {
		afficher();
		nourrir();
		System.out.println("A TABLE!!!");
		afficher();
		
	}
	public static void main(String[] args) {
		Lanceur lanceur = null;
		lanceur = new Lanceur();
		lanceur.go();
	}
}
