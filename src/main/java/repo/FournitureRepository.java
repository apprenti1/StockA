/*package repo;

import bdd.Env;
import entity.Fourniture;
import java.sql.*;
import java.util.ArrayList;

public class FournitureRepository{

    public ArrayList<Fourniture> FindAll(){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Fourniture");
            ResultSet res = req.executeQuery();
            ArrayList<Fourniture> list = new ArrayList<Fourniture>();
            while (res.next()){
                list.add(new Fourniture( res.getInt("id"), res.getString("description"), res.getString("libelle"), res.getInt("quantiteEnStock")));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean Update(Fourniture entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("UPDATE Fourniture set description = ?, libelle = ?, quantiteEnStock = ? WHERE id = ?;");
            req.setString(1,entity.getDescription());
            req.setString(2,entity.getLibelle());
            req.setInt(3,entity.getQuantiteEnStock());
            req.setInt(4,entity.getId());
            req.executeQuery();

            return true;
        } catch (SQLException e) {
            // return false;
            throw new RuntimeException(e);
        }
    }

    public boolean Delete(Fourniture entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("DELETE FROM Fourniture WHERE id = ?;");
            req.setInt(1,entity.getId());
            req.executeQuery();
            return true;
        } catch (SQLException e) {
            // return false;
            throw new RuntimeException(e);
        }
    }

    public boolean Upload(Fourniture entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("INSERT into Fourniture(description, libelle, quantiteEnStock");
            req.setInt(1,entity.getId());
            req.executeQuery();
            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Fourniture> FindBy(String filters){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Fourniture WHERE "+((!filters.isEmpty() && !filters.isBlank())?filters:"1 = 1"));
            ResultSet res = req.executeQuery();
            ArrayList<Fourniture> list = new ArrayList<Fourniture>();
            while (res.next()){

                list.add(new Fourniture(  res.getInt("id"), res.getString("description"), res.getString("libelle"), res.getInt("quantiteEnStock")));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Fourniture FindById(Fourniture entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Fourniture WHERE id = ?");
            req.setInt(1,entity.getId());
            ResultSet res = req.executeQuery();
            res.next();
            Fourniture rep = new Fourniture( res.getInt("id"), res.getString("description"), res.getString("libelle"), res.getInt("quantiteEnStock"));
            return rep;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}

 */