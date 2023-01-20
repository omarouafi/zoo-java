package org.formation.ouafi.service;

import java.io.Serializable;

public class CagePojo implements Serializable {

    private static final long serialVerionUID = 1L;
    private int id;

    public GazellePojo getGazelle() {
        return gazelle;
    }

    public void setGazelle(GazellePojo gazelle) {
        this.gazelle = gazelle;
    }

    private GazellePojo gazelle;
    private String codeAnimal;
    private String nom;
    private int age;
    private double poids;
    private int x;
    private int y;

    public void setId(int id) {
        this.id = id;
    }

    public void setCodeAnimal(String codeAnimal) {
        this.codeAnimal = codeAnimal;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public String getCodeAnimal() {
        return codeAnimal;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public double getPoids() {
        return poids;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CagePojo(int id, String codeAnimal, String nom, int age, double poids, int x, int y) {
        this.id = id;
        this.codeAnimal = codeAnimal;
        this.nom = nom;
        this.age = age;
        this.poids = poids;
        this.x = x;
        this.y = y;
    }

    public CagePojo() {

    }
}
