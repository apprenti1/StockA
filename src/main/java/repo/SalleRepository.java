package repo;

import application.Env;
import entity.Salle;
import java.sql.*;
import java.util.ArrayList;

public class SalleRepository{

    public ArrayList<Salle> FindAll(){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Salle");
            ResultSet res = req.executeQuery();
            ArrayList<Salle> list = new ArrayList<Salle>();
            while (res.next()){
                list.add(new Salle( res.getInt("id"), res.getString("nom"), res.getBoolean("occupee") ));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean Update(Salle entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("UPDATE Salle set nom = ?, occupee = ? WHERE id = ?;");
            req.setString(1,entity.getNom());
            req.setBoolean(2,entity.getOccupee());
            req.setInt(3,entity.getId());
            req.executeQuery();

            return true;
        } catch (SQLException e) {
           // return false;
            throw new RuntimeException(e);
        }
    }

    public boolean Delete(Salle entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("DELETE FROM Salle WHERE id = ?;");
            req.setInt(1,entity.getId());
            req.executeQuery();
            return true;
        } catch (SQLException e) {
           // return false;
            throw new RuntimeException(e);
        }
    }

    public boolean Upload(Salle entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("INSERT into Salle(nom, occupee");
            req.setInt(1,entity.getId());
            req.executeQuery();
            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Salle> FindBy(String filters){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Salle WHERE "+((!filters.isEmpty() && !filters.isBlank())?filters:"1 = 1"));
            ResultSet res = req.executeQuery();
            ArrayList<Salle> list = new ArrayList<Salle>();
            while (res.next()){
                list.add(new Salle( res.getInt("id"), res.getString("nom"), res.getBoolean("occupee") ));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Salle FindById(Salle entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Salle WHERE id = ?");
            req.setInt(1,entity.getId());
            ResultSet res = req.executeQuery();
            res.next();
            Salle rep = new Salle( res.getInt("id"), res.getString("nom"), res.getBoolean("occupee") );
            return rep;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}