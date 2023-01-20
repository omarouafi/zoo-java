package org.formation.ouafi.stockage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaoFactoryTest {
    @Test
    void testGetDao(){
        DaoFactory dao = DaoFactory.getInstance();
        assertNotNull(dao.getDao());

    }
}