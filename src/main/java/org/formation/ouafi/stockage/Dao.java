package org.formation.ouafi.stockage;
import java.util.List;

public interface Dao<T> {
    public List<T> lireTous();
    public T lire(int cle);
    public void creer(T cp);
    public void modifier(T cp);
    public void supprimer(int cle);
}
