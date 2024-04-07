package repo;

import application.Env;
import entity.LinkFournitureFournisseur;
import java.sql.*;
import java.util.ArrayList;
import application.Security;


public class LinkFournitureFournisseurRepository {

    public ArrayList<LinkFournitureFournisseur> findAll(){
        try {
        FournitureRepository fournitureRepo = new FournitureRepository();

        FournisseurRepository fournisseurRepo = new FournisseurRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from LinkFournitureFournisseur");
            ResultSet res = req.executeQuery();
            ArrayList<LinkFournitureFournisseur> list = new ArrayList<LinkFournitureFournisseur>();
            while (res.next()){
                list.add( new LinkFournitureFournisseur( res.getInt("id"), res.getDouble("prix"), fournitureRepo.findById(res.getInt("ref_fourniture")) , fournisseurRepo.findById(res.getInt("ref_fournisseur"))  ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(LinkFournitureFournisseur entity){
        try {
        FournitureRepository fournitureRepo = new FournitureRepository();

        FournisseurRepository fournisseurRepo = new FournisseurRepository();

            if(entity.getFourniture().getId() == 0){
                fournitureRepo.update( entity.getFourniture());
            }
            else{
                entity.getFourniture().setId(fournitureRepo.upload( entity.getFourniture()));
            }
        
            if(entity.getFournisseur().getId() == 0){
                fournisseurRepo.update( entity.getFournisseur());
            }
            else{
                entity.getFournisseur().setId(fournisseurRepo.upload( entity.getFournisseur()));
            }
        
            PreparedStatement req = Env.getBdd().prepareStatement("UPDATE LinkFournitureFournisseur set prix = ?,  ref_fourniture = ?,  ref_fournisseur = ? WHERE id = ?;");

            req.setDouble(1, entity.getPrix());
            req.setInt(2, entity.getFourniture().getId());
            req.setInt(3, entity.getFournisseur().getId());
            req.setInt(4, entity.getId());
            req.executeUpdate();

            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public boolean delete(LinkFournitureFournisseur entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("DELETE FROM LinkFournitureFournisseur WHERE id = ?;");
            req.setInt(1,entity.getId());
            req.executeUpdate();
            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public int upload(LinkFournitureFournisseur entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("INSERT into LinkFournitureFournisseur(prix, Fourniture, Fournisseur) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            req.setDouble(1, entity.getPrix());
            req.setInt(2, entity.getFourniture().getId());
            req.setInt(3, entity.getFournisseur().getId());
            req.executeUpdate();
            ResultSet rs = req.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public ArrayList<LinkFournitureFournisseur> findBy(String filters){
        try {
        FournitureRepository fournitureRepo = new FournitureRepository();

        FournisseurRepository fournisseurRepo = new FournisseurRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from LinkFournitureFournisseur WHERE "+((!filters.isEmpty() && !filters.isBlank())?filters:"1 = 1"));
            ResultSet res = req.executeQuery();
            ArrayList<LinkFournitureFournisseur> list = new ArrayList<LinkFournitureFournisseur>();
            while (res.next()){
                list.add( new LinkFournitureFournisseur( res.getInt("id"), res.getDouble("prix"), fournitureRepo.findById(res.getInt("ref_fourniture")) , fournisseurRepo.findById(res.getInt("ref_fournisseur"))  ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkFournitureFournisseur findById(int id){
        try {
        FournitureRepository fournitureRepo = new FournitureRepository();

        FournisseurRepository fournisseurRepo = new FournisseurRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from LinkFournitureFournisseur WHERE id = ?");
            req.setInt(1, id);
            ResultSet res = req.executeQuery();
            res.next();
            LinkFournitureFournisseur rep = new LinkFournitureFournisseur( res.getInt("id"), res.getDouble("prix"), fournitureRepo.findById(res.getInt("ref_fourniture")) , fournisseurRepo.findById(res.getInt("ref_fournisseur"))  );
            return rep;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
