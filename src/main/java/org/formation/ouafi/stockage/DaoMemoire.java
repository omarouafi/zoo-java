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


        CagePojo cp = new CagePojo();
        cp.setX(800);
        cp.setY(400);
        cp.setIdAnimal(1);
        cp.setCodeAnimal("Lion");
        cp.setNom("clarence");
        cp.setPoids(170.4);
        cp.setAge(10);
        cp.setGazelle(null);
        pojos.add(cp);

        CagePojo cp2 = new CagePojo();
        cp2.setX(200);
        cp2.setY(400);
        cp2.setIdAnimal(2);
        cp2.setCodeAnimal("Gazelle");
        cp2.setNom("GAGAG");
        cp2.setPoids(135.2);
        cp2.setAge(5);
        GazellePojo gp = new GazellePojo();
        gp.setId(1);
        gp.setIdAnimal(2);
        gp.setLgCornes(34);
        cp2.setGazelle(gp);
        pojos.add(cp2);

        CagePojo cp3 = new CagePojo();
        cp3.setX(500);
        cp3.setY(480);
        cp3.setIdAnimal(3);
        cp3.setCodeAnimal("Singe");
        cp3.setNom("chita");
        cp3.setPoids(38);
        cp3.setAge(4);
        cp3.setGazelle(null);
        pojos.add(cp3);

        CagePojo cp4 = new CagePojo();
        cp4.setX(300);
        cp4.setY(300);
        cp4.setIdAnimal(4);
        cp4.setCodeAnimal(null);
        cp4.setNom(null);
        cp4.setPoids(0);
        cp4.setAge(0);
        pojos.add(cp4);

        CagePojo cp5 = new CagePojo();
        cp5.setX(700);
        cp5.setY(230);
        cp5.setIdAnimal(5);
        cp5.setCodeAnimal("Gazelle");
        cp5.setNom("Beep Beep");
        cp5.setPoids(135.2);
        cp5.setAge(5);
        GazellePojo gp2 = new GazellePojo();
        gp2.setId(2);
        gp2.setIdAnimal(5);
        gp2.setLgCornes(23);
        cp5.setGazelle(gp2);
        pojos.add(cp5);
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
