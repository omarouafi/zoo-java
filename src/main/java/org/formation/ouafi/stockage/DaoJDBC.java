package org.formation.ouafi.stockage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoJDBC {
    private Connection con;

    public void setCon(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public DaoJDBC(){
        try {
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo","root","");
//              con = DriverManager.getConnection("jdbc:mysql://mysql:3306/zoo","root","!adm1n1strat3ur?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
