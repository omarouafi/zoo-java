package org.formation.ouafi.stockage;

import org.formation.ouafi.service.CagePojo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DaoJDBCImplTest {
    private static DaoJDBCImpl dao = new DaoJDBCImpl();
    @Test
    void lireTous() {
        List<CagePojo> tous = null;
        tous = dao.lireTous();
        assertNotNull(tous);
        assertEquals(5,tous.size());
    }

    @Test
    void lire(){
        CagePojo cp = dao.lire(1);
        assertEquals(cp.getIdAnimal(),1);
    }

    @Test
    void cree(){
        CagePojo cp = new CagePojo();
        cp.setIdAnimal(6);
        cp.setX(630);
        cp.setY(120);
        cp.setNom("Aken");
        cp.setCodeAnimal("Lion");
        cp.setAge(9);
        cp.setPoids(134.7);
        cp.setGazelle(null);
        dao.creer(cp);
        List<CagePojo> tous = null;
        tous = dao.lireTous();
        assertEquals(tous.size(),6);
        dao.supprimer(6);

    }

    @Test
    void supprimer(){
        CagePojo cp = new CagePojo();
        cp.setIdAnimal(6);
        cp.setX(630);
        cp.setY(120);
        cp.setNom("Aken");
        cp.setCodeAnimal("Lion");
        cp.setAge(9);
        cp.setPoids(134.7);
        cp.setGazelle(null);
        dao.creer(cp);
        dao.supprimer(6);
        List<CagePojo> tous = null;
        tous = dao.lireTous();
        assertEquals(tous.size(),5);
    }

    @Test
    void modifier(){
        CagePojo cp = new CagePojo();
        cp.setIdAnimal(6);
        cp.setX(630);
        cp.setY(120);
        cp.setNom("Aken");
        cp.setCodeAnimal("Lion");
        cp.setAge(9);
        cp.setPoids(134.7);
        cp.setGazelle(null);
        dao.creer(cp);
        cp.setNom("Oper");
        dao.modifier(cp);
        cp = dao.lire(cp.getIdAnimal());
        assertEquals(cp.getNom(),"Oper");
        dao.supprimer(6);
    }

}