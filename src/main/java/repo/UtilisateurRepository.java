package repo;

import application.Env;
import entity.Utilisateur;
import java.sql.*;
import java.util.ArrayList;
import application.Security;


public class UtilisateurRepository {

    public ArrayList<Utilisateur> FindAll(){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Utilisateur");
            ResultSet res = req.executeQuery();
            ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
            while (res.next()){
                list.add(new Utilisateur( res.getInt("id"), res.getString("nom"), res.getString("prenom"), res.getString("email"), res.getString("mdp"), res.getInt("role")));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean Update(Utilisateur entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("UPDATE Utilisateur set nom = ?, prenom = ?, email = ?, mdp = ?, role = ? WHERE id = ?;");
            req.setString(1,Security.crypt(entity.getNom()));
            req.setString(2,Security.crypt(entity.getPrenom()));
            req.setString(3,Security.crypt(entity.getEmail()));
            req.setString(4,Security.hash(entity.getMdp()));
            req.setInt(5,entity.getRole());
            req.setInt(6,entity.getId());
            req.executeQuery();

            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public boolean Delete(Utilisateur entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("DELETE FROM Utilisateur WHERE id = ?;");
            req.setInt(1,entity.getId());
            req.executeQuery();
            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public boolean Upload(Utilisateur entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("INSERT into Utilisateur(attr1, attr2");
            req.setInt(1,entity.getId());
            req.executeQuery();
            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Utilisateur> FindBy(String filters){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Utilisateur WHERE "+((!filters.isEmpty() && !filters.isBlank())?filters:"1 = 1"));
            ResultSet res = req.executeQuery();
            ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
            while (res.next()){
                list.add(new Utilisateur( res.getInt("id"), res.getString("nom"), res.getString("prenom"), res.getString("email"), res.getString("mdp"), res.getInt("role")));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Utilisateur FindById(Utilisateur entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Utilisateur WHERE id = ?");
            req.setInt(1,entity.getId());
            ResultSet res = req.executeQuery();
            res.next();
            Utilisateur rep = new Utilisateur( res.getInt("id"), res.getString("nom"), res.getString("prenom"), res.getString("email"), res.getString("mdp"), res.getInt("role"));
            return rep;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
