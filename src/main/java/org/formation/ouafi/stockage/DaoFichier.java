package org.formation.ouafi.stockage;

import java.io.*;
import java.util.List;

public class DaoFichier<T> implements Dao<T> {

    public List<T> tous;
    private static final String NOM="./zoo.data";
    public DaoFichier() {
        charger();
    }

    @Override
    public List<T> lireTous() {
        return tous;
    }

    @Override
    public T lire(int cle) {
        return null;
    }

    @Override
    public void creer(Object cp) {

    }

    @Override
    public void modifier(T cp) {

    }

    @Override
    public void supprimer(int cle) {

    }

    private void ecrire(){
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream((NOM)))) {
             os.writeObject(tous);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void charger(){
        DaoMemoire dao= null;
        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(NOM))){
            tous = (List<T>) is.readObject();
        }catch (FileNotFoundException e){
            dao = new DaoMemoire();
            tous = (List<T>) dao.lireTous();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private void lireFichier(){
        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(NOM))){
            tous = (List<T>) is.readObject();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void enregistrer(){
        ecrire();
    }
}
