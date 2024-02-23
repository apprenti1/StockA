/*package repo;

import bdd.Env;
import entity.RDV;
import java.sql.*;
import java.util.ArrayList;


public class RDVRepository {

    public ArrayList<RDV> FindAll(){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from RDV");
            ResultSet res = req.executeQuery();
            ArrayList<RDV> list = new ArrayList<RDV>();
            DemandeFournitureProfesseurRepository entityRepo = new DemandeFournitureProfesseurRepository();
            ProfesseurRepository entityRepo = new ProfesseurRepository();
            EtudiantRepository entityRepo = new EtudiantRepository();
            SalleRepository entityRepo = new SalleRepository();
            while (res.next()){
                list.add(new RDV( res.getInt("id"), res.getDate("date"), demandeFournitureProfesseurRepo.find(res.getInt("demandeFourniture")), profeseurRepo.find(res.getInt(res.getInt("professeur")), etudiantRepo.find(res.getInt(res.getInt("etudiant")), salleRepo.find(res.getInt(res.getInt("salle"))));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean Update(RDV entity){
        try {
            DemandeFournitureRepository demandeFournitureRepository = new DemandeFournitureRepository();
            DemandeFournitureRepository.update(entity.getDemandeFourniture());
            DemandeFournitureRepository demandeFournitureRepository = new DemandeFournitureRepository();
            DemandeFournitureRepository.update(entity.getProfesseur());
            DemandeFournitureRepository demandeFournitureRepository = new DemandeFournitureRepository();
            DemandeFournitureRepository.update(entity.getEtudiant());
            PreparedStatement req = Env.getBdd().prepareStatement("UPDATE RDV set date = ?, demandeFourniture = ?, professeur = ?, etudiant = ?, salle = ? WHERE id = ?;");
            req.setDate(1,(entity.getDate()));
            req.setInt(2,(entity.getDemandeFourniture().getId()));
            req.setInt(3,(entity.getProfesseur().getId()));
            req.setInt(4,entity.getEtudiant().getId());
            req.setInt(4,entity.getSalle().getId());
            req.setInt(6,entity.getId());
            req.executeQuery();

            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }



    public boolean Upload(RDV entity){
        try {
            EntityRepository entityRepo = new EntityRepository();
            entityRepo.upload( entity.getEntity());
            PreparedStatement req = Env.getBdd().prepareStatement("INSERT into Name(attr1, attr2");
            req.setInt(1,entity.getId());
            req.executeQuery();
            return true;
        } catch (SQLException e) {
            return false;
            throw new RuntimeException(e);
        }
    }

    public ArrayList<RDV> FindBy(String filters){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Name WHERE "+((!filters.isEmpty() && !filters.isBlank())?filters:"1 = 1"));
            ResultSet res = req.executeQuery();
            ArrayList<RDV> list = new ArrayList<RDV>();
            DemandeFournitureProfesseurRepository entityRepo = new DemandeFournitureProfesseurRepository();
            ProfesseurRepository entityRepo = new ProfesseurRepository();
            EtudiantRepository entityRepo = new EtudiantRepository();
            SalleRepository entityRepo = new SalleRepository();
            while (res.next()){
                list.add(new RDV( res.getInt("id"), res.getDate("date"), demandeFournitureProfesseurRepo.find(res.getInt("demandeFourniture")), profeseurRepo.find(res.getInt(res.getInt("professeur")), etudiantRepo.find(res.getInt(res.getInt("etudiant")), salleRepo.find(res.getInt(res.getInt("salle"))));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean Delete(RDV entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("DELETE FROM RDV WHERE id = ?;");
            req.setInt(1,entity.getId());
            req.executeQuery();
            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }


    public RDV FindById(RDV entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from RDV WHERE id = ?");
            req.setInt(1,entity.getId());
            ResultSet res = req.executeQuery();
            DemandeFournitureProfesseurRepository entityRepo = new DemandeFournitureProfesseurRepository();
            ProfesseurRepository entityRepo = new ProfesseurRepository();
            EtudiantRepository entityRepo = new EtudiantRepository();
            SalleRepository entityRepo = new SalleRepository();
            res.next();
            RDV list = (new RDV( res.getInt("id"), res.getDate("date"), demandeFournitureProfesseurRepo.find(res.getInt("demandeFourniture")), profeseurRepo.find(res.getInt(res.getInt("professeur")), etudiantRepo.find(res.getInt(res.getInt("etudiant")), salleRepo.find(res.getInt(res.getInt("salle"))));
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
*/