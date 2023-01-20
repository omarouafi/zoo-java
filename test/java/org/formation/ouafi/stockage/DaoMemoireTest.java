package org.formation.ouafi.stockage;
import org.formation.ouafi.model.Cage;
import org.formation.ouafi.service.CagePojo;
import org.formation.ouafi.service.GazellePojo;
import org.formation.ouafi.stockage.DaoMemoire;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.formation.ouafi.model.Gazelle;
import org.formation.ouafi.model.Mangeable;
import org.formation.ouafi.model.technique.BeurkException;

import java.util.ArrayList;
import java.util.List;

class DaoMemoireTest {


    @Test
    void lireTous() {
        List<CagePojo> pojos;
        pojos=new ArrayList<>();
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

      DaoMemoire daoMemoire = new DaoMemoire();
        //test lire tous
        assertEquals(pojos.size(),daoMemoire.lireTous().size());
        //test cree pojo
        CagePojo test_cage =new CagePojo(1,"test","test",1,1,1,1);
        daoMemoire.creer(test_cage);
        assertEquals(pojos.size() + 1,daoMemoire.lireTous().size());
        //test modifier pojo et lire pojo
        test_cage.setY(2);
        daoMemoire.modifier(test_cage);
        CagePojo cage_pojo_lu = daoMemoire.lire(1);
        assertEquals(cage_pojo_lu.getY(),2);
        //test supprimer pojo
        daoMemoire.supprimer(1);
        assertEquals(pojos.size(),daoMemoire.lireTous().size());




    }





}
