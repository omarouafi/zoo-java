package org.formation.ouafi.stockage;

import org.formation.ouafi.service.CagePojo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DaoFichierTest {
    private static DaoFichier<CagePojo> dao = new DaoFichier<>();
    @Test
    void lireTous() {
        List<CagePojo> tous = dao.lireTous();
        assertEquals(5, tous.size());

    }
}