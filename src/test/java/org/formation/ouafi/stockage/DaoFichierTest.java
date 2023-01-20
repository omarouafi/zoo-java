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
}