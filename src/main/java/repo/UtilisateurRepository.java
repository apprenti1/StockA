package repo;

import application.Env;
import application.Security;
import entity.Utilisateur;
import java.sql.*;
import java.util.ArrayList;


public class UtilisateurRepository {

    public ArrayList<Utilisateur> findAll(){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select id, nom, prenom, email, roles from Utilisateur");
            ResultSet res = req.executeQuery();
            ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
            while (res.next()){
                list.add( new Utilisateur( res.getInt("id"), res.getString("nom"), res.getString("prenom"), res.getString("email"), null, res.getInt("roles") ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Utilisateur entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("UPDATE Utilisateur set nom = ?,  prenom = ?,  email = ?,  "+((entity.getMdp() != null)?"mdp = ?,  ":"")+"roles = ? WHERE id = ?;");

            req.setString(1, entity.getNom());
            req.setString(2, entity.getPrenom());
            req.setString(3, entity.getEmail());
            if (entity.getMdp() != null) {
                req.setString(4, Security.hash(entity.getMdp()));
            }
            req.setInt((entity.getMdp() == null)?4:5, entity.getRoles());
            req.setInt((entity.getMdp() == null)?5:6, entity.getId());
            req.executeUpdate();

            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public int updateMdp(Utilisateur entity)throws SQLException{
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("UPDATE `utilisateur` SET `mdp`=? WHERE `email`=?");
            req.setString(1, Security.hash(entity.getMdp())); // Mettre à jour le mot de passe avec le nouveau hash
            req.setString(2, entity.getEmail()); // Pour l'utilisateur avec cet e-mail
            System.out.println(req);
            return req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Utilisateur findByEmail(String email) {
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("SELECT id, nom, prenom, email, roles FROM Utilisateur WHERE email = ?");
            req.setString(1, email);
            ResultSet res = req.executeQuery();
            if (res.next()) {
                Utilisateur utilisateur = new Utilisateur(
                        res.getInt("id"),
                        res.getString("nom"),
                        res.getString("prenom"),
                        res.getString("email"),
                        null,
                        res.getInt("roles")
                );
                return utilisateur;
            } else {
                return null; // Utilisateur non trouvé
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean delete(Utilisateur entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("DELETE FROM Utilisateur WHERE id = ?;");
            req.setInt(1,entity.getId());
            req.executeUpdate();
            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public int upload(Utilisateur entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("INSERT into Utilisateur(nom, prenom, email, mdp, roles) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            req.setString(1, entity.getNom());
            req.setString(2, entity.getPrenom());
            req.setString(3, entity.getEmail());
            req.setString(4, Security.hash(entity.getMdp()));
            req.setInt(5, entity.getRoles());
            req.executeUpdate();
            ResultSet rs = req.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Utilisateur> findBy(String filters){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select nom, prenom, email, roles from Utilisateur WHERE "+((!filters.isEmpty() && !filters.isBlank())?filters:"1 = 1"));
            ResultSet res = req.executeQuery();
            ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
            while (res.next()){
                list.add( new Utilisateur( res.getInt("id"), res.getString("nom"), res.getString("prenom"), res.getString("email"), null, res.getInt("roles") ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Utilisateur findById(int id){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select id, nom, prenom, email, roles from Utilisateur WHERE id = ?");
            req.setInt(1, id);
            ResultSet res = req.executeQuery();
            res.next();
            Utilisateur rep = new Utilisateur( res.getInt("id"), res.getString("nom"), res.getString("prenom"), res.getString("email"), null, res.getInt("roles") );
            return rep;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Utilisateur connect(String email, String mdp) {
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select id, nom, prenom, email, roles from Utilisateur WHERE email = ? and mdp = ? ;");
            req.setString(1, email);
            req.setString(2, Security.hash(mdp));
            ResultSet res = req.executeQuery();
            if (res.next()) {
                Utilisateur rep = new Utilisateur(res.getInt("id"), res.getString("nom"), res.getString("prenom"), res.getString("email"), null, res.getInt("roles"));
                return rep;
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
