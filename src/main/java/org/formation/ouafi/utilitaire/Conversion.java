package org.formation.ouafi.utilitaire;

import org.formation.ouafi.model.Animal;
import org.formation.ouafi.model.Cage;
import org.formation.ouafi.model.technique.CagePleineException;
import org.formation.ouafi.model.technique.PorteException;
import org.formation.ouafi.service.CagePojo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Conversion {
    public static final String PACKAGE = "org.formation.ouafi.model.";
    public static Cage cageToPojo(CagePojo cp){
        Cage ret = null;
        Class<?> lesTypes[];
        Object lesValeurs[];
        Animal laBete;
        Constructor<?> construct;
        Class<?> laClasse;
        ret = new Cage(cp.getX(),cp.getY());
        if(cp.getCodeAnimal().equals("Gazelle")){
            lesTypes = new Class<?>[4];
            lesValeurs = new Object[4];

            lesTypes[3] = int.class;
            int lg = (int) cp.getGazelle().getLgCornes();
            lesValeurs[3] = lg;

        }else {
            lesTypes = new Class<?>[3];
            lesValeurs = new Object[3];
        }

        lesTypes[0] = String.class;
        lesTypes[1] = int.class;
        lesTypes[2] = double.class;
        lesValeurs[0] = cp.getNom();
        lesValeurs[1] = cp.getAge();
        lesValeurs[2] = cp.getPoids();



        try{
            laClasse = Class.forName(PACKAGE+cp.getCodeAnimal());
            construct = laClasse.getConstructor(lesTypes);
            laBete = (Animal) construct.newInstance(lesValeurs);
            ret.ouvrir();
            ret.entrer(laBete);
            ret.fermer();
            return ret;
        }catch(ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException |
               IllegalAccessException | InvocationTargetException | PorteException | CagePleineException e){
            e.printStackTrace();
            return ret;
        }


    }
}
