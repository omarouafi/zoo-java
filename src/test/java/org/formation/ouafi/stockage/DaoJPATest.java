package org.formation.ouafi.stockage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.formation.ouafi.service.CagePojo;
import org.junit.jupiter.api.Test;

class DaoJPATest {

    private static DaoJPA<CagePojo> daoJPA=new DaoJPA<CagePojo>();
    @Test
    void testLireTous() {
        List<CagePojo> tous=null;
        tous=daoJPA.lireTous();
        assertNotNull(tous);
        assertEquals(tous.size(), 5);
    }

    @Test
    void testLire() {
        CagePojo cp=new CagePojo();
        cp.setAge(10);
        cp.setCodeAnimal("Lion");
        cp.setNom("simba");
        cp.setPoids(120);
        cp.setX(500);
        cp.setY(200);
        daoJPA.creer(cp);
        assertNotNull(daoJPA.lire(daoJPA.getDernierCle()));
        daoJPA.supprimer(daoJPA.getDernierCle());
    }

    @Test
    void testCreerSupprimer() {
        CagePojo cp=new CagePojo();
        cp.setAge(10);
        cp.setCodeAnimal("Lion");
        cp.setNom("simba");
        cp.setPoids(120);
        cp.setX(500);
        cp.setY(200);
        daoJPA.creer(cp);
        assertEquals(daoJPA.lireTous().size(),6);
        daoJPA.supprimer(daoJPA.getDernierCle());
        assertEquals(daoJPA.lireTous().size(),5);

    }

    @Test
    void testModifier() {

    }

}
