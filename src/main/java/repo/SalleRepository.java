package repo;

import application.Env;
import entity.Salle;
import java.sql.*;
import java.util.ArrayList;


public class SalleRepository {

    public ArrayList<Salle> findAll(){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Salle");
            ResultSet res = req.executeQuery();
            ArrayList<Salle> list = new ArrayList<Salle>();
            while (res.next()){
                list.add( new Salle( res.getInt("id"), res.getString("libelle") ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Salle entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("UPDATE Salle set libelle = ? WHERE id = ?;");

            req.setString(1, entity.getLibelle());
            req.setInt(2, entity.getId());
            req.executeUpdate();

            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public boolean delete(Salle entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("DELETE FROM Salle WHERE id = ?;");
            req.setInt(1,entity.getId());
            req.executeUpdate();
            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public int upload(Salle entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("INSERT into Salle(libelle) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            req.setString(1, entity.getLibelle());
            req.executeUpdate();
            ResultSet rs = req.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Salle> findBy(String filters){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Salle WHERE "+((!filters.isEmpty() && !filters.isBlank())?filters:"1 = 1"));
            ResultSet res = req.executeQuery();
            ArrayList<Salle> list = new ArrayList<Salle>();
            while (res.next()){
                list.add( new Salle( res.getInt("id"), res.getString("libelle") ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Salle findById(int id){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Salle WHERE id = ?");
            req.setInt(1, id);
            ResultSet res = req.executeQuery();
            res.next();
            Salle rep = new Salle( res.getInt("id"), res.getString("libelle") );
            return rep;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
