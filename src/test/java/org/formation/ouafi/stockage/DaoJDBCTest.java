package org.formation.ouafi.stockage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaoJDBCTest {

    @Test
    void testConnection(){
        assertNotNull(new DaoJDBC().getCon());
    }

}