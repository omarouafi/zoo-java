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


    public static Cage pojoToCage(CagePojo cp) {
        Cage ret = null;
        Class<?>[] lesTypes;
        Object[] lesValeurs;
        Animal laBete;
        Constructor<?> construct;
        Class<?> laClasse;

        ret = new Cage(cp.getX(), cp.getY());
        // on a un animal dedans
        if (cp.getCodeAnimal() != null) {
            if (!cp.getCodeAnimal().equals("Gazelle")) {
                lesTypes = new Class<?>[3];
                lesValeurs = new Object[3];
            } else {
                lesTypes = new Class<?>[4];
                lesValeurs = new Object[4];
                lesTypes[3] = int.class;
                lesValeurs[3] = cp.getGazelle().getLgCornes();
            }
            lesTypes[0] = String.class;
            lesTypes[1] = int.class;
            lesTypes[2] = double.class;
            lesValeurs[0] = cp.getNom();
            lesValeurs[1] = cp.getAge();
            lesValeurs[2] = cp.getPoids();
            // forname
            try {
                laClasse = Class.forName(PACKAGE + cp.getCodeAnimal());
                // recuperer le constructeur
                construct = laClasse.getConstructor(lesTypes);
                // instancier l'animal
                laBete = (Animal) construct.newInstance(lesValeurs);
                // le faire entrer dans la cage (ret)
                ret.ouvrir();
                ret.entrer(laBete);
                // fermer la cage (ret)
                ret.fermer();
            } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                     | IllegalAccessException | IllegalArgumentException | InvocationTargetException | PorteException
                     | CagePleineException e) {
                System.out.println(e.getMessage());

            }
        }
        return ret;

    }
}
