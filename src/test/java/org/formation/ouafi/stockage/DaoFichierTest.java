package org.formation.ouafi.stockage;

import org.formation.ouafi.service.CagePojo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DaoFichierTest {

    @Test
    void lireTous() {
        DaoFichier<CagePojo> dao = new DaoFichier<CagePojo>();
        List<CagePojo> tous = dao.lireTous();
        assertEquals(1, tous.size());
    }

    @Test
    void ecrire() {
        DaoFichier<CagePojo> dao = new DaoFichier<CagePojo>();
        dao.enregistrer();
        List<CagePojo> tous = dao.lireTous();
        assertEquals(1, tous.size());
    }

    @Test
    void creer() {
        DaoFichier<CagePojo> dao = new DaoFichier<CagePojo>();
        CagePojo cp = new CagePojo();
        cp.setX(630);
        cp.setY(120);
        cp.setNom("Aken");
        cp.setCodeAnimal("Lion");
        cp.setAge(9);
        cp.setPoids(134.7);
        cp.setGazelle(null);
        dao.creer(cp);
        List<CagePojo> tous = dao.lireTous();
        assertEquals(2,tous.size());
        tous.remove(1);
        assertEquals(1,tous.size());
    }

    @Test
    void supprimer(){
        DaoFichier<CagePojo> dao = new DaoFichier<CagePojo>();
        CagePojo cp = new CagePojo();
        cp.setX(630);
        cp.setY(120);
        cp.setNom("Aken");
        cp.setCodeAnimal("Lion");
        cp.setAge(9);
        cp.setPoids(134.7);
        cp.setGazelle(null);
        dao.creer(cp);
        List<CagePojo> tous = dao.lireTous();
        int tous_taille = tous.size();
        dao.supprimer(0);
        assertEquals(tous.size(),tous_taille-1);
    }

    @Test
    void lire(){
        DaoFichier<CagePojo> dao = new DaoFichier<CagePojo>();
        CagePojo cp = new CagePojo();
        cp.setX(630);
        cp.setY(120);
        cp.setNom("Aken");
        cp.setCodeAnimal("Lion");
        cp.setAge(9);
        cp.setPoids(134.7);
        cp.setGazelle(null);
        List<CagePojo> tous = dao.lireTous();
        int index = tous.size();
        dao.creer(cp);
        CagePojo cp_obj = dao.lire(index);
        assertEquals(cp_obj.getNom(),cp.getNom());
        assertEquals(cp_obj.getAge(),cp.getAge());
        assertEquals(cp_obj.getY(),cp.getY());
        assertEquals(cp_obj.getPoids(),cp.getPoids());
    }



    @Test
    void modifier(){
        DaoFichier<CagePojo> dao = new DaoFichier<CagePojo>();
        CagePojo cp = new CagePojo();
        cp.setX(630);
        cp.setY(120);
        cp.setNom("Aken");
        cp.setCodeAnimal("Lion");
        cp.setAge(9);
        cp.setPoids(134.7);
        cp.setGazelle(null);
        dao.creer(cp);

        cp.setNom("Sop");
        cp.setCodeAnimal("Singe");
        dao.modifier(cp);
        List<CagePojo> tous = dao.lireTous();
        CagePojo cp1 = dao.lire(tous.indexOf(cp));
        assertEquals(cp1.getNom(),"Sop");
        assertEquals(cp1.getCodeAnimal(),"Singe");
    }

    @Test
    void setGetNomFichier(){
        DaoFichier<CagePojo> dao = new DaoFichier<CagePojo>();
        dao.setNomFichier("test");
        assertEquals(dao.getNomFichier(),"test");
    }

}