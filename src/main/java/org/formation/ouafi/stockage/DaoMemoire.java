package org.formation.ouafi.stockage;

import java.util.ArrayList;
import java.util.List;

import org.formation.ouafi.service.CagePojo;
import org.formation.ouafi.service.GazellePojo;

public class DaoMemoire implements Dao<CagePojo> {
    private List<CagePojo> pojos;
    public DaoMemoire() {
        pojos=new ArrayList<>();
        init();
    }

    private void init() {
        CagePojo cp = null;
        GazellePojo gp = null;

        cp = new CagePojo();
        cp.setX(800);
        cp.setY(400);
        cp.setIdAnimal(1);
        cp.setCodeAnimal("Lion");
        cp.setNom("clarence");
        cp.setPoids(170.4);
        cp.setAge(10);
        cp.setGazelle(null);
        pojos.add(cp);

        cp = new CagePojo();
        cp.setX(200);
        cp.setY(400);
        cp.setIdAnimal(2);
        cp.setCodeAnimal("Gazelle");
        cp.setNom("GAGAG");
        cp.setPoids(135.2);
        cp.setAge(5);
        gp = new GazellePojo();
        gp.setId(1);
        gp.setIdAnimal(2);
        gp.setLgCornes(34);
        cp.setGazelle(gp);
        pojos.add(cp);

        cp = new CagePojo();
        cp.setX(500);
        cp.setY(480);
        cp.setIdAnimal(3);
        cp.setCodeAnimal("Singe");
        cp.setNom("chita");
        cp.setPoids(38);
        cp.setAge(4);
        cp.setGazelle(null);
        pojos.add(cp);

        cp = new CagePojo();
        cp.setX(300);
        cp.setY(300);
        cp.setIdAnimal(4);
        cp.setCodeAnimal(null);
        cp.setNom(null);
        cp.setPoids(0);
        cp.setAge(0);
        pojos.add(cp);

        cp = new CagePojo();
        cp.setX(700);
        cp.setY(230);
        cp.setIdAnimal(5);
        cp.setCodeAnimal("Gazelle");
        cp.setNom("Beep Beep");
        cp.setPoids(135.2);
        cp.setAge(5);
        gp = new GazellePojo();
        gp.setId(2);
        gp.setIdAnimal(5);
        gp.setLgCornes(23);
        cp.setGazelle(gp);
        pojos.add(cp);
    }
    public List<CagePojo> lireTous(){
        return pojos;
    }

    @Override
    public CagePojo lire(int cle) {
        return pojos.get(cle-1);
    }

    @Override
    public void creer(CagePojo cp) {
        pojos.add(cp);
    }

    @Override
    public void modifier(CagePojo cp) {
        pojos.set(pojos.indexOf(cp),cp);
    }

    @Override
    public void supprimer(int cle) {
        pojos.remove(cle-1);
    }


}
