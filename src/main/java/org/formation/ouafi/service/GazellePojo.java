package org.formation.ouafi.service;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="gazelle")
public class GazellePojo implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private int id;
    private int idAnimal;
    private int lgCornes;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdAnimal() {
        return idAnimal;
    }
    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }
    public int getLgCornes() {
        return lgCornes;
    }
    public void setLgCornes(int lgCornes) {
        this.lgCornes = lgCornes;
    }
    public GazellePojo() {
        setId(0);
        setIdAnimal(0);
        setLgCornes(0);
    }

    public GazellePojo(int id, int idAnimal, int lgCornes) {
       this.id = id;
       this.idAnimal = idAnimal;
       this.lgCornes = lgCornes;
    }
    @Override
    public String toString() {
        return "GazellePOJO [id=" + id + ", idAnimal=" + idAnimal + ", lgCornes=" + lgCornes + "]";
    }

}
