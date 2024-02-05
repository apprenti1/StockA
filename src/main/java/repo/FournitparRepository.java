package repo;

import application.Env;
import entity.Fournitpar;
import java.sql.*;
import java.util.ArrayList;

public class FournitparRepository{

    public ArrayList<Fournitpar> FindAll(){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Fournitpar");
            ResultSet res = req.executeQuery();
            ArrayList<Fournitpar> list = new ArrayList<Fournitpar>();
            FournitureRepository fournitureRepo = new FournitureRepository();
            FournisseurRepository fournisseurRepo = new FournisseurRepository();
            while (res.next()){
                list.add(new Fournitpar( res.getInt("id"), fournitureRepo.find(res.getInt("ref_fourniture")), fournisseurRepo.find(res.getInt("ref_fournisseur")) ));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean Update(Fournitpar entity){
        try {
            FournitureRepository fournitureRepo = new FournitureRepository();
            FournisseurRepository fournisseurRepo = new FournisseurRepository();
            entityRepo.update( entity.getEntity());
            PreparedStatement req = Env.getBdd().prepareStatement("UPDATE Fournitpar set attr1 = ?, attr2 = ? WHERE id = ?;");
            req.setInt(1,entity.getAttr1());
            req.setInt(2,entity.getAttr2());
            req.setInt(3,entity.getId());
            req.executeQuery();

            return true;
        } catch (SQLException e) {
            return false;
            throw new RuntimeException(e);
        }
    }

    public boolean Delete(Fournitpar entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("DELETE FROM Fournitpar WHERE id = ?;");
            req.setInt(1,entity.getId());
            req.executeQuery();
            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public boolean Upload(Fournitpar entity){
        try {

            FournitureRepository fournitureRepo = new FournitureRepository();
            FournisseurRepository fournisseurRepo = new FournisseurRepository();
            entityRepo.upload( entity.getEntity());
            PreparedStatement req = Env.getBdd().prepareStatement("INSERT into Fournitpar(attr1, attr2");
            req.setInt(1,entity.getId());
            req.executeQuery();
            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Fournitpar> FindBy(String filters){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Fournitpar WHERE "+((!filters.isEmpty() && !filters.isBlank())?filters:"1 = 1"));
            ResultSet res = req.executeQuery();
            ArrayList<Fournitpar> list = new ArrayList<Fournitpar>();

            FournitureRepository fournitureRepo = new FournitureRepository();
            FournisseurRepository fournisseurRepo = new FournisseurRepository();            while (res.next()){
                list.add(new Fournitpar( res.getInt("id"), entityRepo.find(res.getInt("refEntity")) ));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Fournitpar FindById(Fournitpar entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Fournitpar WHERE id = ?");
            req.setInt(1,entity.getId());
            ResultSet res = req.executeQuery();
            FournitureRepository fournitureRepo = new FournitureRepository();
            FournisseurRepository fournisseurRepo = new FournisseurRepository();            res.next();
            Fournitpar rep = new Fournitpar( res.getBoo("id"), entityRepo.find(res.getInt("refEntity")) );
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    }