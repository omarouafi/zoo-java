package org.formation.ouafi.stockage;

import org.formation.ouafi.model.Cage;
import org.formation.ouafi.service.CagePojo;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class DaoFactory {
    private static final String NOM = "zoo.properties";
    private static DaoFactory instance = new DaoFactory();
    Properties props;

    private DaoFactory() {
        props = new Properties();
        try {
            props.load(new FileInputStream(NOM));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DaoFactory getInstance(){
        return instance;
    }

    public Dao<CagePojo> getDao() {
        String paquetag = props.getProperty(("package"));
        String nomDao = props.getProperty("dao");
        Class<?> classDao = null;
        Dao<CagePojo> ret = null;

        try {
            classDao = Class.forName(String.join("", paquetag, nomDao));
            ret = (Dao<CagePojo>) classDao.getConstructor(null).newInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return ret;
    }
}
