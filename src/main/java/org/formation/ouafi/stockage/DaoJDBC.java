package org.formation.ouafi.stockage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoJDBC {
    private Connection con;

    public void setCon(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public DaoJDBC(){
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream("zoo.properties")) {
            props.load(in);
            String url = props.getProperty("url");
            String user = props.getProperty("login");
            String password = props.getProperty("passwd");
            con = DriverManager.getConnection(url, user, password);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
