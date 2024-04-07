package repo;

import application.Env;
import entity.CommandeFourniture;
import java.sql.*;
import java.util.ArrayList;


public class CommandeFournitureRepository {

    public ArrayList<CommandeFourniture> findAll(){
        try {
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();

        FournisseurRepository fournisseurRepo = new FournisseurRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from CommandeFourniture");
            ResultSet res = req.executeQuery();
            ArrayList<CommandeFourniture> list = new ArrayList<CommandeFourniture>();
            while (res.next()){
                list.add( new CommandeFourniture( res.getInt("id"), res.getBoolean("valid"), res.getString("raison"), res.getInt("etat"), utilisateurRepo.findById(res.getInt("ref_utilisateur")) , fournisseurRepo.findById(res.getInt("ref_fournisseur"))  ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(CommandeFourniture entity){
        try {
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();

        FournisseurRepository fournisseurRepo = new FournisseurRepository();

            if(entity.getUtilisateur().getId() == 0){
                utilisateurRepo.update( entity.getUtilisateur());
            }
            else{
                entity.getUtilisateur().setId(utilisateurRepo.upload( entity.getUtilisateur()));
            }
        
            if(entity.getFournisseur().getId() == 0){
                fournisseurRepo.update( entity.getFournisseur());
            }
            else{
                entity.getFournisseur().setId(fournisseurRepo.upload( entity.getFournisseur()));
            }
        
            PreparedStatement req = Env.getBdd().prepareStatement("UPDATE CommandeFourniture set valid = ?,  raison = ?,  etat = ?,  ref_utilisateur = ?,  ref_fournisseur = ? WHERE id = ?;");

            req.setBoolean(1, entity.isValid());
            req.setString(2, entity.getRaison());
            req.setInt(3, entity.getEtat());
            req.setInt(4, entity.getUtilisateur().getId());
            req.setInt(5, entity.getFournisseur().getId());
            req.setInt(6, entity.getId());
            req.executeUpdate();

            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public boolean delete(CommandeFourniture entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("DELETE FROM CommandeFourniture WHERE id = ?;");
            req.setInt(1,entity.getId());
            req.executeUpdate();
            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public int upload(CommandeFourniture entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("INSERT into CommandeFourniture(valid, raison, etat, Utilisateur, Fournisseur) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            req.setBoolean(1, entity.isValid());
            req.setString(2, entity.getRaison());
            req.setInt(3, entity.getEtat());
            req.setInt(4, entity.getUtilisateur().getId());
            req.setInt(5, entity.getFournisseur().getId());
            req.executeUpdate();
            ResultSet rs = req.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public ArrayList<CommandeFourniture> findBy(String filters){
        try {
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();

        FournisseurRepository fournisseurRepo = new FournisseurRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from CommandeFourniture WHERE "+((!filters.isEmpty() && !filters.isBlank())?filters:"1 = 1"));
            ResultSet res = req.executeQuery();
            ArrayList<CommandeFourniture> list = new ArrayList<CommandeFourniture>();
            while (res.next()){
                list.add( new CommandeFourniture( res.getInt("id"), res.getBoolean("valid"), res.getString("raison"), res.getInt("etat"), utilisateurRepo.findById(res.getInt("ref_utilisateur")) , fournisseurRepo.findById(res.getInt("ref_fournisseur"))  ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CommandeFourniture findById(int id){
        try {
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();

        FournisseurRepository fournisseurRepo = new FournisseurRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from CommandeFourniture WHERE id = ?");
            req.setInt(1, id);
            ResultSet res = req.executeQuery();
            res.next();
            CommandeFourniture rep = new CommandeFourniture( res.getInt("id"), res.getBoolean("valid"), res.getString("raison"), res.getInt("etat"), utilisateurRepo.findById(res.getInt("ref_utilisateur")) , fournisseurRepo.findById(res.getInt("ref_fournisseur"))  );
            return rep;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
