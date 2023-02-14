package org.formation.ouafi.stockage;

import org.formation.ouafi.service.CagePojo;
import org.formation.ouafi.service.GazellePojo;

import java.sql.PreparedStatement;
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
        Statement st = null;
        ResultSet result = null;
        CagePojo ret = null;
        String requete = "select * from animal a left join gazelle g on g.idAnimal = a.idAnimal where a.idAnimal="+cle;
        try {
            st = jdbc.getCon().createStatement();
            result = st.executeQuery(requete);
            while (result.next()) {
                ret=transfo(result);

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public void creer(CagePojo cp) {
        Statement st = null;
        ResultSet result = null;
        CagePojo ret = null;

        String requete = "INSERT INTO animal (idAnimal,codeAnimal,nom,age,poids,x,y) " +
                "values(?,?,?,?,?,?,?)";
        try {
            jdbc.getCon().setAutoCommit(false);
            PreparedStatement pst = jdbc.getCon().prepareStatement(requete);
            pst.setString(1,Integer.toString(cp.getIdAnimal()));
            pst.setString(2,cp.getCodeAnimal());
            pst.setString(3,cp.getNom());
            pst.setString(4,Integer.toString(cp.getAge()));
            pst.setString(5,Double.toString(cp.getPoids()));
            pst.setString(6,Integer.toString(cp.getX()));
            pst.setString(7,Integer.toString(cp.getY()));
            pst.executeUpdate();
            if(cp.getGazelle() != null){
                requete = "INSERT INTO gazelle (id,idAnimal,lgCornes) " +
                        "values(?,?,?)";
                pst = jdbc.getCon().prepareStatement(requete);
                pst.setString(1,Integer.toString(cp.getGazelle().getId()));
                pst.setString(2,Integer.toString(cp.getGazelle().getIdAnimal()));
                pst.setString(3,Double.toString(cp.getGazelle().getLgCornes()));
                pst.executeUpdate();
            }
            jdbc.getCon().commit();
            jdbc.getCon().setAutoCommit(true);
        } catch (SQLException e) {
            try {
                jdbc.getCon().rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            throw new RuntimeException(e);
        }
    }

    @Override
    public void modifier(CagePojo cp) {
        Statement st = null;
        ResultSet result = null;
        CagePojo ret = null;
        ret = this.lire(cp.getIdAnimal());
        String requete = "";
        if(ret != null){
            try {
                jdbc.getCon().setAutoCommit(false);
                requete = "UPDATE animal set nom=?,age=?,poids=?,x=?,y=? where idAnimal=?";
                PreparedStatement pst = jdbc.getCon().prepareStatement(requete);
                pst.setString(1,cp.getNom());
                pst.setString(2,Integer.toString( cp.getAge()));
                pst.setString(3, Double.toString(cp.getPoids()));
                pst.setString(4, Integer.toString(cp.getX()));
                pst.setString(5, Integer.toString(cp.getY()));
                pst.setString(6, Integer.toString(cp.getIdAnimal()));
                pst.executeUpdate();

                if(ret.getGazelle() != null){
                    requete = "UPDATE gazelle set idAnimal=?,lgCornes=? where id=?";
                    pst = jdbc.getCon().prepareStatement(requete);
                    pst.setString(1,Integer.toString(cp.getIdAnimal()));
                    pst.setString(2,Double.toString(cp.getGazelle().getLgCornes()));
                    pst.setString(3,Integer.toString(cp.getGazelle().getId()));
                    pst.executeUpdate();
                }
                jdbc.getCon().commit();
                jdbc.getCon().setAutoCommit(true);

            } catch (SQLException e) {
               System.out.println(e);
            }

        }else{
            System.out.println("Animal n'existe pas");
        }
    }

    @Override
    public void supprimer(int cle) {
        Statement st = null;
        ResultSet result = null;
        CagePojo ret = null;
        ret = this.lire(cle);
        String requete = "";
        if(ret != null){
            try {
                jdbc.getCon().setAutoCommit(false);
                requete = "DELETE from animal where idAnimal=?";
                PreparedStatement pst = jdbc.getCon().prepareStatement(requete);
                pst.setString(1,Integer.toString(ret.getIdAnimal()));
                pst.executeUpdate();

                if(ret.getGazelle() != null){
                    requete = "DELETE gazelle where id=?";
                    pst = jdbc.getCon().prepareStatement(requete);
                    pst.setString(1,Integer.toString(ret.getGazelle().getId()));
                    pst.executeUpdate();
                }
                jdbc.getCon().commit();
                jdbc.getCon().setAutoCommit(true);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }else{
            System.out.println("Animal n'existe pas");
        }
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
            ret.setIdAnimal(res.getInt("idAnimal"));
            ret.setY(res.getInt("y"));
            ret.setX(res.getInt("x"));
            ret.setGazelle(null);
            String k = res.getString("codeAnimal");
            if(k != null && k.equals("Gazelle")){
                gp = new GazellePojo();
                gp.setIdAnimal(ret.getIdAnimal());
                gp.setLgCornes(res.getInt("lgCornes"));
                ret.setGazelle(gp);
            }
        }catch(SQLException e){

        }
        return ret;
    }
}
