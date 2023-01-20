package org.formation.ouafi.model;

import org.formation.ouafi.service.CagePojo;
import org.formation.ouafi.service.GazellePojo;
import org.formation.ouafi.utilitaire.Conversion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConversionTest {

    @Test
    void testProjoCage(){
        CagePojo cp;
        Cage cage;

        cp = new CagePojo();
        cp.setX(30);
        cp.setY(10);



        cp.setCodeAnimal("Lion");
        cp.setNom("Leo");
        cp.setAge(3);
        cp.setPoids(123.33);
        cp.setGazelle(null);
        cage = Conversion.cageToPojo(cp);

        assertNotNull(cage.getOccupant());
        assertEquals(cp.getNom(), cage.getOccupant().getNom());
        assertEquals(cp.getAge(), cage.getOccupant().getAge());
        assertEquals(cp.getPoids(), cage.getOccupant().getPoids());


    }
    @Test
    void testProjoCageGazelle(){
        CagePojo cp;
        Cage cage;

        cp = new CagePojo();
        cp.setX(30);
        cp.setY(10);

        cp.setCodeAnimal("Gazelle");
        cp.setNom("G1");
        cp.setAge(3);
        cp.setPoids(123.33);
        GazellePojo g1 = new GazellePojo(1,1,12);
        cp.setGazelle(g1);
        cage = Conversion.cageToPojo(cp);

        assertNotNull(cage.getOccupant());
        assertEquals(cp.getNom(), cage.getOccupant().getNom());
        assertEquals(cp.getAge(), cage.getOccupant().getAge());
        assertEquals(cp.getPoids(), cage.getOccupant().getPoids());

        Gazelle gazelle = (Gazelle) cage.getOccupant();

        assertEquals(gazelle.getLgCornes(), cp.getGazelle().getLgCornes());




    }

}