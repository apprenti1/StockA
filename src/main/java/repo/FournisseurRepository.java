package repo;

import application.Env;
import entity.Fournisseur;
import java.sql.*;
import java.util.ArrayList;


public class FournisseurRepository {

    public ArrayList<Fournisseur> findAll(){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Fournisseur");
            ResultSet res = req.executeQuery();
            ArrayList<Fournisseur> list = new ArrayList<Fournisseur>();
            while (res.next()){
                list.add( new Fournisseur( res.getInt("id"), res.getString("libelle"), res.getString("tel"), res.getString("email") ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Fournisseur entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("UPDATE Fournisseur set libelle = ?,  tel = ?,  email = ? WHERE id = ?;");

            req.setString(1, entity.getLibelle());
            req.setString(2, entity.getTel());
            req.setString(3, entity.getEmail());
            req.setInt(4, entity.getId());
            req.executeUpdate();

            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public boolean delete(Fournisseur entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("DELETE FROM Fournisseur WHERE id = ?;");
            req.setInt(1,entity.getId());
            req.executeUpdate();
            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public int upload(Fournisseur entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("INSERT into Fournisseur(libelle, tel, email) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            req.setString(1, entity.getLibelle());
            req.setString(2, entity.getTel());
            req.setString(3, entity.getEmail());
            req.executeUpdate();
            ResultSet rs = req.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Fournisseur> findBy(String filters){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Fournisseur WHERE "+((!filters.isEmpty() && !filters.isBlank())?filters:"1 = 1"));
            ResultSet res = req.executeQuery();
            ArrayList<Fournisseur> list = new ArrayList<Fournisseur>();
            while (res.next()){
                list.add( new Fournisseur( res.getInt("id"), res.getString("libelle"), res.getString("tel"), res.getString("email") ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Fournisseur findById(int id){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Fournisseur WHERE id = ?");
            req.setInt(1, id);
            ResultSet res = req.executeQuery();
            res.next();
            Fournisseur rep = new Fournisseur( res.getInt("id"), res.getString("libelle"), res.getString("tel"), res.getString("email") );
            return rep;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
