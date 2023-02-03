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
    void lire() {
    }

    @Test
    void creer() {
    }

    @Test
    void modifier() {
    }

    @Test
    void supprimer() {
    }

    @Test
    void transfo() {
    }
}