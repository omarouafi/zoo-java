package org.formation.ouafi.stockage;

import java.util.ArrayList;
import java.util.List;

import org.formation.ouafi.model.Animal;
import org.formation.ouafi.service.CagePojo;
import org.formation.ouafi.service.GazellePojo;

public class DaoMemoire implements Dao<CagePojo> {
    private List<CagePojo> pojos;
    public DaoMemoire() {
        pojos=new ArrayList<>();
        init();
    }

    private void init() {
        CagePojo cp=null;
        GazellePojo gp=null;
        cp=new CagePojo();
        cp.setX(800);
        cp.setY(400);
        cp.setNom("clarence");
        cp.setCodeAnimal("Lion");
        cp.setAge(10);
        cp.setPoids(170.4);
        cp.setGazelle(null);
        pojos.add(cp);
    }
    public List<CagePojo> lireTous(){
        return pojos;
    }

    @Override
    public CagePojo lire(int cle) {
        return pojos.get(cle);
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
        pojos.remove(cle);
    }


}
