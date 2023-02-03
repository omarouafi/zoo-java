package org.formation.ouafi.service;

import java.io.Serializable;

public class GazellePojo implements Serializable {
    private static final long serialVerionUID = 1L;

    private int id;
    private int idAnimal;
    private double lgCornes;

    private GazellePojo gazelle;

    @Override
    public String toString() {
        return "GazellePojo{" +
                "id=" + id +
                ", idAnimal=" + idAnimal +
                ", lgCornes=" + lgCornes +
                ", gazelle=" + gazelle +
                '}';
    }

    public GazellePojo() {

    }

    public GazellePojo getGazelle() {
        return gazelle;
    }

    public void setGazelle(GazellePojo gazelle) {
        this.gazelle = gazelle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public void setLgCornes(double lgCornes) {
        this.lgCornes = lgCornes;
    }

    public int getId() {
        return id;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public double getLgCornes() {
        return lgCornes;
    }

    public GazellePojo(int id, int idAnimal, double lgCornes) {
        this.id = id;
        this.idAnimal = idAnimal;
        this.lgCornes = lgCornes;
    }
}
