package repo;

import application.Env;
import entity.DemandeFourniture;
import java.sql.*;
import java.util.ArrayList;
import application.Security;


public class DemandeFournitureRepository {

    public ArrayList<DemandeFourniture> findAll(){
        try {
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from DemandeFourniture");
            ResultSet res = req.executeQuery();
            ArrayList<DemandeFourniture> list = new ArrayList<DemandeFourniture>();
            while (res.next()){
                list.add( new DemandeFourniture( res.getInt("id"), res.getBoolean("valid"), res.getString("raison"), res.getInt("etat"), utilisateurRepo.findById(res.getInt("ref_utilisateur"))  ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(DemandeFourniture entity){
        try {
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();

            if(entity.getUtilisateur().getId() == 0){
                utilisateurRepo.update( entity.getUtilisateur());
            }
            else{
                entity.getUtilisateur().setId(utilisateurRepo.upload( entity.getUtilisateur()));
            }
        
            PreparedStatement req = Env.getBdd().prepareStatement("UPDATE DemandeFourniture set valid = ?,  raison = ?,  etat = ?,  ref_utilisateur = ? WHERE id = ?;");

            req.setBoolean(1, entity.isValid());
            req.setString(2, entity.getRaison());
            req.setInt(3, entity.getEtat());
            req.setInt(4, entity.getUtilisateur().getId());
            req.setInt(5, entity.getId());
            req.executeUpdate();

            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public boolean delete(DemandeFourniture entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("DELETE FROM DemandeFourniture WHERE id = ?;");
            req.setInt(1,entity.getId());
            req.executeUpdate();
            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public int upload(DemandeFourniture entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("INSERT into DemandeFourniture(valid, raison, etat, Utilisateur) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            req.setBoolean(1, entity.isValid());
            req.setString(2, entity.getRaison());
            req.setInt(3, entity.getEtat());
            req.setInt(4, entity.getUtilisateur().getId());
            req.executeUpdate();
            ResultSet rs = req.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public ArrayList<DemandeFourniture> findBy(String filters){
        try {
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from DemandeFourniture WHERE "+((!filters.isEmpty() && !filters.isBlank())?filters:"1 = 1"));
            ResultSet res = req.executeQuery();
            ArrayList<DemandeFourniture> list = new ArrayList<DemandeFourniture>();
            while (res.next()){
                list.add( new DemandeFourniture( res.getInt("id"), res.getBoolean("valid"), res.getString("raison"), res.getInt("etat"), utilisateurRepo.findById(res.getInt("ref_utilisateur"))  ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public DemandeFourniture findById(int id){
        try {
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from DemandeFourniture WHERE id = ?");
            req.setInt(1, id);
            ResultSet res = req.executeQuery();
            res.next();
            DemandeFourniture rep = new DemandeFourniture( res.getInt("id"), res.getBoolean("valid"), res.getString("raison"), res.getInt("etat"), utilisateurRepo.findById(res.getInt("ref_utilisateur"))  );
            return rep;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
