package org.formation.ouafi.stockage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.formation.ouafi.service.CagePojo;
import org.formation.ouafi.service.GazellePojo;
import org.junit.jupiter.api.Test;

/**
 *
 *
 * idAnimal: 1, codeAnimal: "Lion", nom: "clarence", age: 10, poids: 170.4, x: 800, y: 400
 * idAnimal: 2, codeAnimal: "Gazelle", nom: "GAGAG", age: 5, poids:135.2, x: 200, y: 400
 * 		id: 1, idAnimal: 2, lgCornes: 34
 * idAnimal: 3,codeAnimal: "Singe", nom: "chita", age: 4, poids: 38, x: 500, y: 480
 * idAnimal: 4, age: 0, poids: 0, x: 300, y: 300
 * idAnimal: 5, codeAnimal:"Gazelle", nom: "Beep Beep", age: 5, poids: 135.2, x: 700, y: 230
 * 		id: 2,idAnimal: 5, lgCornes: 23
 *
 */

class DaoMemoireTests {
    private static DaoMemoire dao = new DaoMemoire();

    @Test
    void testLireTous() {
        List<CagePojo> tous = dao.lireTous();
        assertEquals(5, tous.size());
        assertEquals("Lion", tous.get(0).getCodeAnimal());
        assertNull(tous.get(3).getCodeAnimal());
    }

    @Test
    void testLire() {
        CagePojo aEtudier = dao.lire(3);
        assertEquals("Singe", aEtudier.getCodeAnimal());
        assertEquals(500, aEtudier.getX());
        assertEquals(480, aEtudier.getY());
        assertEquals(3, aEtudier.getIdAnimal());
        assertEquals("chita", aEtudier.getNom());
        assertEquals(4, aEtudier.getAge());
        assertEquals(38.0, aEtudier.getPoids());
    }

    @Test
    void testCreerSupprimer() {
        CagePojo aCreer = new CagePojo();
        aCreer.setX(300);
        aCreer.setY(500);
        aCreer.setIdAnimal(6);
        aCreer.setCodeAnimal(null);
        List<CagePojo> tous = dao.lireTous();

        assertEquals(5, tous.size());
        dao.creer(aCreer);
        tous = dao.lireTous();
        assertEquals(6, tous.size());
        tous = dao.lireTous();
        assertEquals(aCreer.getCodeAnimal(), tous.get(5).getCodeAnimal());
        assertEquals(aCreer.getX(), tous.get(5).getX());
        dao.supprimer(6);
        assertEquals(5, tous.size());

    }

    @Test
    void testModifier() {
        CagePojo aModifier = null;
        // changer x,y, le poids, le nom, l'age du lion cle: 1
        aModifier = dao.lire(1); // pas super un select serait mieux
        assertEquals("Lion", aModifier.getCodeAnimal());
        // nom: "clarence", age: 10, poids: 170.4, x: 800, y: 400
        assertEquals("clarence", aModifier.getNom());
        assertEquals(10, aModifier.getAge());
        aModifier.setAge(aModifier.getAge() + 1);
        aModifier.setPoids(aModifier.getPoids() + 1.0);
        aModifier.setX(aModifier.getX() + 1);
        aModifier.setY(aModifier.getY() + 1);
        aModifier.setNom("toto");
        dao.modifier(aModifier);
        aModifier = dao.lire(1);
        assertEquals("toto", aModifier.getNom());
        assertEquals(11, aModifier.getAge());
        assertEquals(171.4, aModifier.getPoids());
        assertEquals(801, aModifier.getX());
        assertEquals(401, aModifier.getY());
        // on remet dans l'etat
        aModifier.setAge(aModifier.getAge() - 1);
        aModifier.setPoids(aModifier.getPoids() - 1.0);
        aModifier.setX(aModifier.getX() - 1);
        aModifier.setY(aModifier.getY() - 1);
        aModifier.setNom("clarence");
        dao.modifier(aModifier);
        aModifier = dao.lire(1);
        assertEquals("clarence", aModifier.getNom());

        // changer la longueur des cornes de la gazelle 5 indice 4
        // idAnimal: 5, codeAnimal: "Gazelle", nom: "Beep Beep", age: 5, poids: 135.2,
        // x: 700, y: 230
        // id: 2, idAnimal: 5, lgCornes: 23
        aModifier = dao.lire(5);
        assertEquals(23, aModifier.getGazelle().getLgCornes());
        aModifier.getGazelle().setLgCornes(aModifier.getGazelle().getLgCornes() + 1);
        dao.modifier(aModifier);
        aModifier = dao.lire(5);
        assertEquals(24, aModifier.getGazelle().getLgCornes());
        aModifier.getGazelle().setLgCornes(aModifier.getGazelle().getLgCornes() - 1);
        dao.modifier(aModifier);
        aModifier = dao.lire(5);
        assertEquals(23, aModifier.getGazelle().getLgCornes());

        // faire sortir le singe 3 indeice 2
        // idAnimal: 3, codeAnimal: "Singe", nom: "chita", age: 4, poids: 38, x: 500, y:
        // 480
        aModifier = dao.lire(3);
        assertEquals("Singe", aModifier.getCodeAnimal());
        aModifier.setCodeAnimal(null);
        dao.modifier(aModifier);
        aModifier = dao.lire(3);
        assertNull(aModifier.getCodeAnimal());

        // faire entrer le singe 3
        aModifier.setCodeAnimal("Singe");
        dao.modifier(aModifier);
        aModifier = dao.lire(3);
        assertNotNull(aModifier.getCodeAnimal());
        assertEquals("Singe", aModifier.getCodeAnimal());

        // faire sortir la gazelle 2
        // idAnimal: 2, codeAnimal: "Gazelle", nom: "GAGAG", age: 5, poids: 135.2, x:
        // 200, y: 400
        // id: 1, idAnimal: 2, lgCornes: 34
        aModifier = dao.lire(2);
        GazellePojo gpSauv = aModifier.getGazelle();
        assertEquals("Gazelle", aModifier.getCodeAnimal());
        assertNotNull(aModifier.getGazelle());
        aModifier.setGazelle(null);
        aModifier.setCodeAnimal(null);
        dao.modifier(aModifier);
        aModifier = dao.lire(2);
        assertNull(aModifier.getCodeAnimal());
        assertNull(aModifier.getGazelle());

        // faire entrer la gazelle 2
        aModifier.setGazelle(gpSauv);
        aModifier.setCodeAnimal("Gazelle");
        dao.modifier(aModifier);
        aModifier = dao.lire(2);
        assertEquals("Gazelle", aModifier.getCodeAnimal());
        assertNotNull(aModifier.getGazelle());

    }

}
