package org.formation.ouafi.service;

import org.formation.ouafi.model.Animal;
import org.formation.ouafi.model.Cage;
import org.formation.ouafi.model.Gazelle;
import org.formation.ouafi.model.Mangeable;
import org.formation.ouafi.model.technique.BeurkException;
import org.formation.ouafi.model.technique.CagePleineException;
import org.formation.ouafi.model.technique.PorteException;
import org.formation.ouafi.stockage.Dao;
import org.formation.ouafi.utilitaire.Conversion;

public class CagePersistante {
    private Cage modele;
    private CagePojo pojo;
    private Dao<CagePojo> stockage;
    private int cle;
    public CagePersistante( int id, int x,int y) {
        cle = id;
        modele = new Cage(x,y);
    }
    public CagePersistante(int id, Dao<CagePojo> stockage)
    {
        this.stockage=stockage;
        pojo = stockage.lire(id);
        cle = id;
        modele = Conversion.pojoToCage(pojo);
    }
    public CagePojo getCagePojo(){
        return pojo;
    }
    public void entrer(Animal a) throws PorteException, CagePleineException
    {
        modele.entrer(a);
        sauver();
    }
    public Animal sortir() throws PorteException
    {
        Animal tmp = null;
        tmp = modele.sortir();
        sauver();
        return tmp;
    }
    public boolean estOccupee()
    {
        return modele.getOccupant() != null;
    }
    /**
     * uniquement pour les lambdas.
     * NE PAS UTILISER pour manipuler l'animal de la cage.
     * @return Animal qui est dans la cage.
     */
    public Animal getOccupant()
    {
        return modele.getOccupant();
    }
    public int getX()
    {
        return modele.getX();
    }
    public int getY()
    {
        return modele.getY();
    }
    public void ouvrir()
    {
        modele.ouvrir();
    }
    public void fermer()
    {
        modele.fermer();
    }
    public boolean estOuverte()
    {
        return modele.isOuvert();
    }
    public void nourrirOccupant()
    {
        if(modele.getOccupant() != null)
        {
            modele.getOccupant().manger();
            sauver();
        }
    }
    public String devorer(Mangeable autre) throws BeurkException
    {
        if(estOccupee())
        {
            modele.getOccupant().manger(autre);
            sauver();
            return "Miam miam";
        }
        return "";
    }
    @Override
    public String toString() {
        return "Cage n° "+cle+" " + modele.toString();
    }
    public int getCle() {
        return cle;
    }
    /**
     * méthode privée qui assure la liaison avec le stockage
     * en remplissant le pojo et en donnant le pojo au dao.
     */
    private void sauver()
    {
        GazellePojo tmp = null;
        String codeAnimal = null;
        if(modele.getOccupant() != null)
        {
            codeAnimal = modele.getOccupant().getClass().getSimpleName();
            pojo.setCodeAnimal(codeAnimal);
            pojo.setNom(modele.getOccupant().getNom());
            pojo.setAge(modele.getOccupant().getAge());
            pojo.setPoids(modele.getOccupant().getPoids());
            if(codeAnimal.equals("Gazelle"))
            {
                if(pojo.getGazelle() == null)
                {
                    tmp = new GazellePojo();
                    pojo.setGazelle(tmp);
                }
                pojo.getGazelle().setIdAnimal(cle);
                pojo.getGazelle().setLgCornes(((Gazelle)modele.getOccupant()).getLgCornes());
            }
        }
        else
        {
            pojo.setCodeAnimal(null);
            pojo.setNom(null);
            pojo.setAge(0);
            pojo.setPoids(0);
            pojo.setGazelle(tmp);

        }
        stockage.modifier(pojo);
    }

}
