package repo;

import application.Env;
import entity.Fourniture;
import java.sql.*;
import java.util.ArrayList;


public class FournitureRepository {

    public ArrayList<Fourniture> findAll(){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Fourniture");
            ResultSet res = req.executeQuery();
            ArrayList<Fourniture> list = new ArrayList<Fourniture>();
            while (res.next()){
                list.add( new Fourniture( res.getInt("id"), res.getString("description"), res.getString("libelle"), res.getInt("qteStock") ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Fourniture entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("UPDATE Fourniture set description = ?,  libelle = ?,  qtestock = ? WHERE id = ?;");

            req.setString(1, entity.getDescription());
            req.setString(2, entity.getLibelle());
            req.setInt(3, entity.getQteStock());
            req.setInt(4, entity.getId());
            req.executeUpdate();

            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public boolean delete(Fourniture entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("DELETE FROM Fourniture WHERE id = ?;");
            req.setInt(1,entity.getId());
            req.executeUpdate();
            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public int upload(Fourniture entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("INSERT into Fourniture(description, libelle, qteStock) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            req.setString(1, entity.getDescription());
            req.setString(2, entity.getLibelle());
            req.setInt(3, entity.getQteStock());
            req.executeUpdate();
            ResultSet rs = req.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Fourniture> findBy(String filters){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Fourniture WHERE "+((!filters.isEmpty() && !filters.isBlank())?filters:"1 = 1"));
            ResultSet res = req.executeQuery();
            ArrayList<Fourniture> list = new ArrayList<Fourniture>();
            while (res.next()){
                list.add( new Fourniture( res.getInt("id"), res.getString("description"), res.getString("libelle"), res.getInt("qteStock") ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Fourniture findById(int id){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Fourniture WHERE id = ?");
            req.setInt(1, id);
            ResultSet res = req.executeQuery();
            res.next();
            Fourniture rep = new Fourniture( res.getInt("id"), res.getString("description"), res.getString("libelle"), res.getInt("qteStock") );
            return rep;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
