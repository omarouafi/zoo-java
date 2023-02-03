package org.formation.ouafi.stockage;

import org.formation.ouafi.service.CagePojo;
import org.formation.ouafi.service.GazellePojo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

public class DaoJDBCImpl implements Dao<CagePojo> {
    private DaoJDBC jdbc;
    public DaoJDBCImpl(){
        jdbc = new DaoJDBC();
    }
    @Override
    public List<CagePojo> lireTous() {
        Statement st = null;
        ResultSet result = null;
        List<CagePojo> ret = null;
        String requete = "select * from animal a left join gazelle g on g.idAnimal = a.idAnimal";
        try {
            st = jdbc.getCon().createStatement();
            result = st.executeQuery(requete);
            ret = new Vector();
            while (result.next()) {
                ret.add(transfo(result));

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public CagePojo lire(int cle) {
        return null;
    }

    @Override
    public void creer(CagePojo cp) {

    }

    @Override
    public void modifier(CagePojo cp) {

    }

    @Override
    public void supprimer(int cle) {

    }

    public CagePojo transfo(ResultSet res){
        CagePojo ret = null;
        GazellePojo gp = null;
        ret = new CagePojo();
        try{
            ret.setAge(res.getInt(("age")));
            ret.setCodeAnimal(res.getString("codeAnimal"));
            ret.setNom(res.getString("nom"));
            ret.setPoids(res.getDouble("poids"));
            ret.setY(res.getInt("y"));
            ret.setX(res.getInt("x"));
            ret.setGazelle(null);
            String k = res.getString("codeAnimal");
            if(k != null && k.equals("Gazelle")){
                gp = new GazellePojo();
                gp.setId(res.getInt("id"));
                gp.setIdAnimal(ret.getId());
                gp.setLgCornes(res.getInt("lgCornes"));
                ret.setGazelle(gp);
            }
        }catch(SQLException e){

        }
        return ret;
    }
}
