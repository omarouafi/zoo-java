package org.formation.ouafi.service;


import org.formation.ouafi.model.Cage;
import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;


public class CagePojoTests {

    @Test
    void testCagePojoConstructor(){
        int id = 1;
        String codeAnimal = "Lion";
        String nom = "Toto";
        int age = 4;
        double poids = 70;
        int x = 2;
        int y = 4;
        CagePojo cp = new CagePojo(id,codeAnimal,nom,age,poids,x,y);
        assertEquals(id,cp.getIdAnimal());
        assertEquals(codeAnimal,cp.getCodeAnimal());
        assertEquals(nom,cp.getNom());
        assertEquals(age,cp.getAge());
        assertEquals(poids,cp.getPoids());
        assertEquals(x,cp.getX());
        assertEquals(y,cp.getY());
    }

    @Test
    void getImage(){
        int id = 1;
        String codeAnimal = "Lion";
        String nom = "Toto";
        int age = 4;
        double poids = 70;
        int x = 2;
        int y = 4;
        CagePojo cp = new CagePojo(id,codeAnimal,nom,age,poids,x,y);
        assertEquals(cp.getImage(),"images/lion.gif");

        cp.setCodeAnimal(null);
        assertEquals(cp.getImage(),"images/cage.jpg");

    }

    @Test
    void setImage(){
        int id = 1;
        String codeAnimal = "Lion";
        String nom = "Toto";
        int age = 4;
        double poids = 70;
        int x = 2;
        int y = 4;
        CagePojo cp = new CagePojo(id,codeAnimal,nom,age,poids,x,y);
        assertEquals(cp.getImage(),"images/lion.gif");

        cp.setImage("images/lion.gif");
        assertNotNull(cp.getImage());

    }

    @Test
    void getPancarde(){
        int id = 1;
        String codeAnimal = "Lion";
        String nom = "Toto";
        int age = 4;
        double poids = 70;
        int x = 2;
        int y = 4;
        GazellePojo gp = new GazellePojo();
        gp.setId(2);
        gp.setIdAnimal(5);
        gp.setLgCornes(23);

        CagePojo cp = new CagePojo(id,codeAnimal,nom,age,poids,x,y);

        StringJoiner temp = new StringJoiner(" ");
        temp.add(nom).add(Integer.toString(age)).add("ans");
        temp.add(Double.toString(poids)).add("Kg");
        assertEquals(cp.getPancarde(),temp.toString());
        cp.setGazelle(gp);
        cp.setCodeAnimal("Gazelle");
        temp.add(", cornes =").add(Integer.toString(cp.getGazelle().getLgCornes())).add("cm");

        assertEquals(cp.getPancarde(),temp.toString());
        cp.setCodeAnimal(null);
        assertEquals(cp.getPancarde(),"Cage vide");
    }

    @Test
    void testPancard(){
        int id = 1;
        String codeAnimal = "Lion";
        String nom = "Toto";
        int age = 4;
        double poids = 70;
        int x = 2;
        int y = 4;


        CagePojo cp = new CagePojo(id,codeAnimal,nom,age,poids,x,y);
        cp.setPancarde("test");
        assertNotNull(cp.getPancarde());
    }

    @Test
    void testToString(){
        int id = 1;
        String codeAnimal = "Lion";
        String nom = "Toto";
        int age = 4;
        double poids = 70;
        int x = 2;
        int y = 4;
        GazellePojo gazelle = null;
        CagePojo cp = new CagePojo(id,codeAnimal,nom,age,poids,x,y);
        String cpToString = "CagePOJO [idAnimal=" + id + ", codeAnimal=" + codeAnimal + ", nom=" + nom + ", age=" + age
                + ", poids=" + poids + ", x=" + x + ", y=" + y + ", gazelle=" + gazelle + "]";
        assertEquals(cpToString,cp.toString());
    }

}
