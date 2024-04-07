package repo;

import application.Env;
import entity.LinkDemandeFournitureFourniture;
import java.sql.*;
import java.util.ArrayList;
import application.Security;


public class LinkDemandeFournitureFournitureRepository {

    public ArrayList<LinkDemandeFournitureFourniture> findAll(){
        try {
        DemandeFournitureRepository demandefournitureRepo = new DemandeFournitureRepository();

        FournitureRepository fournitureRepo = new FournitureRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from LinkDemandeFournitureFourniture");
            ResultSet res = req.executeQuery();
            ArrayList<LinkDemandeFournitureFourniture> list = new ArrayList<LinkDemandeFournitureFourniture>();
            while (res.next()){
                list.add( new LinkDemandeFournitureFourniture( res.getInt("id"), res.getInt("quantite"), demandefournitureRepo.findById(res.getInt("ref_demandefourniture")) , fournitureRepo.findById(res.getInt("ref_fourniture"))  ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(LinkDemandeFournitureFourniture entity){
        try {
        DemandeFournitureRepository demandefournitureRepo = new DemandeFournitureRepository();

        FournitureRepository fournitureRepo = new FournitureRepository();

            if(entity.getDemandeFourniture().getId() == 0){
                demandefournitureRepo.update( entity.getDemandeFourniture());
            }
            else{
                entity.getDemandeFourniture().setId(demandefournitureRepo.upload( entity.getDemandeFourniture()));
            }
        
            if(entity.getFourniture().getId() == 0){
                fournitureRepo.update( entity.getFourniture());
            }
            else{
                entity.getFourniture().setId(fournitureRepo.upload( entity.getFourniture()));
            }
        
            PreparedStatement req = Env.getBdd().prepareStatement("UPDATE LinkDemandeFournitureFourniture set quantite = ?,  ref_demandefourniture = ?,  ref_fourniture = ? WHERE id = ?;");

            req.setInt(1, entity.getQuantite());
            req.setInt(2, entity.getDemandeFourniture().getId());
            req.setInt(3, entity.getFourniture().getId());
            req.setInt(4, entity.getId());
            req.executeUpdate();

            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public boolean delete(LinkDemandeFournitureFourniture entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("DELETE FROM LinkDemandeFournitureFourniture WHERE id = ?;");
            req.setInt(1,entity.getId());
            req.executeUpdate();
            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public int upload(LinkDemandeFournitureFourniture entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("INSERT into LinkDemandeFournitureFourniture(quantite, DemandeFourniture, Fourniture) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            req.setInt(1, entity.getQuantite());
            req.setInt(2, entity.getDemandeFourniture().getId());
            req.setInt(3, entity.getFourniture().getId());
            req.executeUpdate();
            ResultSet rs = req.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public ArrayList<LinkDemandeFournitureFourniture> findBy(String filters){
        try {
        DemandeFournitureRepository demandefournitureRepo = new DemandeFournitureRepository();

        FournitureRepository fournitureRepo = new FournitureRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from LinkDemandeFournitureFourniture WHERE "+((!filters.isEmpty() && !filters.isBlank())?filters:"1 = 1"));
            ResultSet res = req.executeQuery();
            ArrayList<LinkDemandeFournitureFourniture> list = new ArrayList<LinkDemandeFournitureFourniture>();
            while (res.next()){
                list.add( new LinkDemandeFournitureFourniture( res.getInt("id"), res.getInt("quantite"), demandefournitureRepo.findById(res.getInt("ref_demandefourniture")) , fournitureRepo.findById(res.getInt("ref_fourniture"))  ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkDemandeFournitureFourniture findById(int id){
        try {
        DemandeFournitureRepository demandefournitureRepo = new DemandeFournitureRepository();

        FournitureRepository fournitureRepo = new FournitureRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from LinkDemandeFournitureFourniture WHERE id = ?");
            req.setInt(1, id);
            ResultSet res = req.executeQuery();
            res.next();
            LinkDemandeFournitureFourniture rep = new LinkDemandeFournitureFourniture( res.getInt("id"), res.getInt("quantite"), demandefournitureRepo.findById(res.getInt("ref_demandefourniture")) , fournitureRepo.findById(res.getInt("ref_fourniture"))  );
            return rep;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
