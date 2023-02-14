package org.formation.ouafi.stockage;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.formation.ouafi.stockage.Dao;

public class DaoJPA<T> implements Dao<T> {

    private EntityManager manager;
    public DaoJPA() {
        manager=Persistence.createEntityManagerFactory("zoo23").createEntityManager();
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<T> lireTous() {
        return manager.createNamedQuery("tous").getResultList();
    }
    @Override
    public T lire(int cle) {
        return (T) manager.createNamedQuery("un").setParameter("bestiole", cle).getSingleResult();
    }
    @Override
    public void creer(T cp) {
        manager.getTransaction().begin();
        manager.persist(cp);
        manager.flush();
        manager.refresh(cp);
        manager.getTransaction().commit();
    }
    @Override
    public void supprimer(int cle) {
        T aSuppimerT=null;
        aSuppimerT=lire(cle);
        manager.getTransaction().begin();;
        manager.remove(aSuppimerT);
        manager.flush();
        manager.getTransaction().commit();

    }
    @Override
    public void modifier(T cp) {
        manager.getTransaction().begin();
        manager.merge(cp);
        manager.flush();
        manager.getTransaction().commit();
    }

    public int getDernierCle()
    {
        return (int) manager.createNamedQuery("derniere").getSingleResult();
    }

}
