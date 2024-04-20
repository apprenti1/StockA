package repo;

import application.Env;
import entity.RDV;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;


public class RDVRepository {

    public ArrayList<RDV> findAll(){
        try {
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();

        SalleRepository salleRepo = new SalleRepository();

        DossierRepository dossierRepo = new DossierRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from RDV");
            ResultSet res = req.executeQuery();
            ArrayList<RDV> list = new ArrayList<RDV>();
            while (res.next()){
                list.add( new RDV( res.getInt("id"), res.getDate("date").toLocalDate(), res.getTime("heure").toLocalTime(), utilisateurRepo.findById(res.getInt("ref_utilisateur")) , salleRepo.findById(res.getInt("ref_salle")) , dossierRepo.findById(res.getInt("ref_dossier"))  ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(RDV entity){
        try {
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();

        SalleRepository salleRepo = new SalleRepository();

        DossierRepository dossierRepo = new DossierRepository();

            if(entity.getUtilisateur().getId() == 0){
                utilisateurRepo.update( entity.getUtilisateur());
            }
            else{
                entity.getUtilisateur().setId(utilisateurRepo.upload( entity.getUtilisateur()));
            }
        
            if(entity.getSalle().getId() == 0){
                salleRepo.update( entity.getSalle());
            }
            else{
                entity.getSalle().setId(salleRepo.upload( entity.getSalle()));
            }
        
            if(entity.getDossier().getId() == 0){
                dossierRepo.update( entity.getDossier());
            }
            else{
                entity.getDossier().setId(dossierRepo.upload( entity.getDossier()));
            }
        
            PreparedStatement req = Env.getBdd().prepareStatement("UPDATE RDV set date = ?,  heure = ?,  ref_utilisateur = ?,  ref_salle = ?,  ref_dossier = ? WHERE id = ?;");

            req.setDate(1, Date.valueOf(entity.getDate()));
            req.setTime(2, Time.valueOf(entity.getHeure()));
            req.setInt(3, entity.getUtilisateur().getId());
            req.setInt(4, entity.getSalle().getId());
            req.setInt(5, entity.getDossier().getId());
            req.setInt(6, entity.getId());
            req.executeUpdate();

            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }
    public int upload(RDV entity, LocalTime heure) {
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("INSERT into RDV(date, heure, Utilisateur, Salle, Dossier) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            req.setDate(1, Date.valueOf(entity.getDate()));
            req.setTime(2, Time.valueOf(heure)); // Utilisation de l'heure spécifiée
            req.setInt(3, entity.getUtilisateur().getId());
            req.setInt(4, entity.getSalle().getId());
            req.setInt(5, entity.getDossier().getId());
            req.executeUpdate();
            ResultSet rs = req.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(RDV entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("DELETE FROM RDV WHERE id = ?;");
            req.setInt(1,entity.getId());
            req.executeUpdate();
            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public int upload(RDV entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("INSERT into RDV(date, heure, Utilisateur, Salle, Dossier) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            req.setDate(1, Date.valueOf(entity.getDate()));
            req.setTime(2, Time.valueOf(entity.getHeure()));
            req.setInt(3, entity.getUtilisateur().getId());
            req.setInt(4, entity.getSalle().getId());
            req.setInt(5, entity.getDossier().getId());
            req.executeUpdate();
            ResultSet rs = req.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public ArrayList<RDV> findBy(String filters){
        try {
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();

        SalleRepository salleRepo = new SalleRepository();

        DossierRepository dossierRepo = new DossierRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from RDV WHERE "+((!filters.isEmpty() && !filters.isBlank())?filters:"1 = 1"));
            ResultSet res = req.executeQuery();
            ArrayList<RDV> list = new ArrayList<RDV>();
            while (res.next()){
                list.add( new RDV( res.getInt("id"), res.getDate("date").toLocalDate(), res.getTime("heure").toLocalTime(), utilisateurRepo.findById(res.getInt("ref_utilisateur")) , salleRepo.findById(res.getInt("ref_salle")) , dossierRepo.findById(res.getInt("ref_dossier"))  ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public RDV findById(int id){
        try {
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();

        SalleRepository salleRepo = new SalleRepository();

        DossierRepository dossierRepo = new DossierRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from RDV WHERE id = ?");
            req.setInt(1, id);
            ResultSet res = req.executeQuery();
            res.next();
            RDV rep = new RDV( res.getInt("id"), res.getDate("date").toLocalDate(), res.getTime("heure").toLocalTime(), utilisateurRepo.findById(res.getInt("ref_utilisateur")) , salleRepo.findById(res.getInt("ref_salle")) , dossierRepo.findById(res.getInt("ref_dossier"))  );
            return rep;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
