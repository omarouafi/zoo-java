package org.formation.ouafi.service;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Classe CagePOJO
 * @author hp
 *
 */
@Entity
@Table(name ="animal")
@NamedQuery(name="tous",query="SELECT cp FROM CagePojo cp")
@NamedQuery(name="un",query="SELECT cp FROM CagePojo AS cp WHERE cp.idAnimal=:bestiole")
@NamedQuery(name="derniere" , query="SELECT cp.idAnimal FROM CagePojo cp ORDER BY idAnimal DESC LIMIT 1")
public class CagePojo implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAnimal;
    /**
     * Lion, Singe, Gazelle ==>nom de la classe !!!sans package!!!
     */
    private String codeAnimal;
    private String nom;
    private int age;
    private double poids;
    private int x;
    private int y;
    //relation 0 à 1
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE} )
    @JoinColumn(name = "idAnimal",referencedColumnName = "idAnimal",updatable = false,insertable = false)
    private GazellePojo gazelle;
    public GazellePojo getGazelle() {
        return gazelle;
    }
    public void setGazelle(GazellePojo gazelle) {
        this.gazelle = gazelle;
    }

    public CagePojo() {
        setCodeAnimal(null);
        setAge(0);
        setGazelle(null);
        setIdAnimal(0);
        setNom(null);
        setPoids(0);
        setX(0);
        setY(0);
    }

    public CagePojo(int idAnimal,String codeAnimal,String nom, int age, double poids, int x, int y) {
      this.idAnimal = idAnimal;
      this.codeAnimal = codeAnimal;
      this.nom = nom;
      this.age = age;
      this.poids = poids;
      this.x = x;
      this.y = y;
    }
    public int getIdAnimal() {
        return idAnimal;
    }
    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }
    public String getCodeAnimal() {
        return codeAnimal;
    }
    public void setCodeAnimal(String codeAnimal) {
        this.codeAnimal = codeAnimal;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getPoids() {
        return poids;
    }
    public void setPoids(double poids) {
        this.poids = poids;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    @Override
    public String toString() {
        return "CagePOJO [idAnimal=" + idAnimal + ", codeAnimal=" + codeAnimal + ", nom=" + nom + ", age=" + age
                + ", poids=" + poids + ", x=" + x + ", y=" + y + ", gazelle=" + gazelle + "]";
    }

}