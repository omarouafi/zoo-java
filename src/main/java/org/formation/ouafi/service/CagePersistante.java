package org.formation.ouafi.service;

import org.formation.ouafi.model.Cage;
import org.formation.ouafi.stockage.Dao;

public class CagePersistante {



    public CagePersistante(Cage cage){
        this.cage = cage;
    }

    public CagePersistante(Cage cage, Dao dao, CagePojo cp){
        this.cage = cage;
        this.dao = dao;
        this.cp = cp;
    }

    private Cage cage;
    private Dao dao;
    private CagePojo cp;

    public Cage getCage() {
        return cage;
    }

    public void setCage(Cage cage) {
        this.cage = cage;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public CagePojo getCp() {
        return cp;
    }

    public void setCp(CagePojo cp) {
        this.cp = cp;
    }

    public void nourrir(){
        this.cage.getOccupant().manger();
    }
}
