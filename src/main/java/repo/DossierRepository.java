package repo;

import application.Env;
import entity.Dossier;
import java.sql.*;
import java.util.ArrayList;
import application.Security;


public class DossierRepository {

    public ArrayList<Dossier> findAll(){
        try {
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();

        EtudiantRepository etudiantRepo = new EtudiantRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Dossier");
            ResultSet res = req.executeQuery();
            ArrayList<Dossier> list = new ArrayList<Dossier>();
            while (res.next()){
                list.add( new Dossier( res.getInt("id"), res.getDate("date"), res.getString("filiere"), res.getString("motivation"), utilisateurRepo.findById(res.getInt("ref_utilisateur")) , etudiantRepo.findById(res.getInt("ref_etudiant"))  ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Dossier entity){
        try {
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();

        EtudiantRepository etudiantRepo = new EtudiantRepository();

            if(entity.getUtilisateur().getId() == 0){
                utilisateurRepo.update( entity.getUtilisateur());
            }
            else{
                entity.getUtilisateur().setId(utilisateurRepo.upload( entity.getUtilisateur()));
            }
        
            if(entity.getEtudiant().getId() == 0){
                etudiantRepo.update( entity.getEtudiant());
            }
            else{
                entity.getEtudiant().setId(etudiantRepo.upload( entity.getEtudiant()));
            }
        
            PreparedStatement req = Env.getBdd().prepareStatement("UPDATE Dossier set date = ?,  filiere = ?,  motivation = ?,  ref_utilisateur = ?,  ref_etudiant = ? WHERE id = ?;");

            req.setDate(1, new Date(entity.getDate().getTime()));
            req.setString(2, entity.getFiliere());
            req.setString(3, entity.getMotivation());
            req.setInt(4, entity.getUtilisateur().getId());
            req.setInt(5, entity.getEtudiant().getId());
            req.setInt(6, entity.getId());
            req.executeUpdate();

            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public boolean delete(Dossier entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("DELETE FROM Dossier WHERE id = ?;");
            req.setInt(1,entity.getId());
            req.executeUpdate();
            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public int upload(Dossier entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("INSERT into Dossier(date, filiere, motivation, Utilisateur, Etudiant) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            req.setDate(1, new Date(entity.getDate().getTime()));
            req.setString(2, entity.getFiliere());
            req.setString(3, entity.getMotivation());
            req.setInt(4, entity.getUtilisateur().getId());
            req.setInt(5, entity.getEtudiant().getId());
            req.executeUpdate();
            ResultSet rs = req.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Dossier> findBy(String filters){
        try {
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();

        EtudiantRepository etudiantRepo = new EtudiantRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Dossier WHERE "+((!filters.isEmpty() && !filters.isBlank())?filters:"1 = 1"));
            ResultSet res = req.executeQuery();
            ArrayList<Dossier> list = new ArrayList<Dossier>();
            while (res.next()){
                list.add( new Dossier( res.getInt("id"), res.getDate("date"), res.getString("filiere"), res.getString("motivation"), utilisateurRepo.findById(res.getInt("ref_utilisateur")) , etudiantRepo.findById(res.getInt("ref_etudiant"))  ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Dossier findById(int id){
        try {
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();

        EtudiantRepository etudiantRepo = new EtudiantRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Dossier WHERE id = ?");
            req.setInt(1, id);
            ResultSet res = req.executeQuery();
            res.next();
            Dossier rep = new Dossier( res.getInt("id"), res.getDate("date"), res.getString("filiere"), res.getString("motivation"), utilisateurRepo.findById(res.getInt("ref_utilisateur")) , etudiantRepo.findById(res.getInt("ref_etudiant"))  );
            return rep;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
