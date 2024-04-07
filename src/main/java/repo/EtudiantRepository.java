package repo;

import application.Env;
import entity.Etudiant;
import java.sql.*;
import java.util.ArrayList;


public class EtudiantRepository {

    public ArrayList<Etudiant> findAll(){
        try {
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Etudiant");
            ResultSet res = req.executeQuery();
            ArrayList<Etudiant> list = new ArrayList<Etudiant>();
            while (res.next()){
                list.add( new Etudiant( res.getInt("id"), res.getString("dernierDiplome"), res.getString("tel"), res.getString("rue"), res.getString("cp"), res.getString("ville"), utilisateurRepo.findById(res.getInt("ref_utilisateur"))  ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Etudiant entity){
        try {
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();

            if(entity.getUtilisateur().getId() == 0){
                utilisateurRepo.update( entity.getUtilisateur());
            }
            else{
                entity.getUtilisateur().setId(utilisateurRepo.upload( entity.getUtilisateur()));
            }
        
            PreparedStatement req = Env.getBdd().prepareStatement("UPDATE Etudiant set dernierdiplome = ?,  tel = ?,  rue = ?,  cp = ?,  ville = ?,  ref_utilisateur = ? WHERE id = ?;");

            req.setString(1, entity.getDernierDiplome());
            req.setString(2, entity.getTel());
            req.setString(3, entity.getRue());
            req.setString(4, entity.getCp());
            req.setString(5, entity.getVille());
            req.setInt(6, entity.getUtilisateur().getId());
            req.setInt(7, entity.getId());
            req.executeUpdate();

            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public boolean delete(Etudiant entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("DELETE FROM Etudiant WHERE id = ?;");
            req.setInt(1,entity.getId());
            req.executeUpdate();
            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public int upload(Etudiant entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("INSERT into Etudiant(dernierDiplome, tel, rue, cp, ville, Utilisateur) VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            req.setString(1, entity.getDernierDiplome());
            req.setString(2, entity.getTel());
            req.setString(3, entity.getRue());
            req.setString(4, entity.getCp());
            req.setString(5, entity.getVille());
            req.setInt(6, entity.getUtilisateur().getId());
            req.executeUpdate();
            ResultSet rs = req.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Etudiant> findBy(String filters){
        try {
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Etudiant WHERE "+((!filters.isEmpty() && !filters.isBlank())?filters:"1 = 1"));
            ResultSet res = req.executeQuery();
            ArrayList<Etudiant> list = new ArrayList<Etudiant>();
            while (res.next()){
                list.add( new Etudiant( res.getInt("id"), res.getString("dernierDiplome"), res.getString("tel"), res.getString("rue"), res.getString("cp"), res.getString("ville"), utilisateurRepo.findById(res.getInt("ref_utilisateur"))  ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Etudiant findById(int id){
        try {
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Etudiant WHERE id = ?");
            req.setInt(1, id);
            ResultSet res = req.executeQuery();
            res.next();
            Etudiant rep = new Etudiant( res.getInt("id"), res.getString("dernierDiplome"), res.getString("tel"), res.getString("rue"), res.getString("cp"), res.getString("ville"), utilisateurRepo.findById(res.getInt("ref_utilisateur"))  );
            return rep;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
