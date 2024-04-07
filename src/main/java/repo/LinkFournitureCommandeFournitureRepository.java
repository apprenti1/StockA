package repo;

import application.Env;
import entity.LinkFournitureCommandeFourniture;
import java.sql.*;
import java.util.ArrayList;
import application.Security;


public class LinkFournitureCommandeFournitureRepository {

    public ArrayList<LinkFournitureCommandeFourniture> findAll(){
        try {
        FournitureRepository fournitureRepo = new FournitureRepository();

        CommandeFournitureRepository commandefournitureRepo = new CommandeFournitureRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from LinkFournitureCommandeFourniture");
            ResultSet res = req.executeQuery();
            ArrayList<LinkFournitureCommandeFourniture> list = new ArrayList<LinkFournitureCommandeFourniture>();
            while (res.next()){
                list.add( new LinkFournitureCommandeFourniture( res.getInt("id"), res.getInt("quantite"), fournitureRepo.findById(res.getInt("ref_fourniture")) , commandefournitureRepo.findById(res.getInt("ref_commandefourniture"))  ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(LinkFournitureCommandeFourniture entity){
        try {
        FournitureRepository fournitureRepo = new FournitureRepository();

        CommandeFournitureRepository commandefournitureRepo = new CommandeFournitureRepository();

            if(entity.getFourniture().getId() == 0){
                fournitureRepo.update( entity.getFourniture());
            }
            else{
                entity.getFourniture().setId(fournitureRepo.upload( entity.getFourniture()));
            }
        
            if(entity.getCommandeFourniture().getId() == 0){
                commandefournitureRepo.update( entity.getCommandeFourniture());
            }
            else{
                entity.getCommandeFourniture().setId(commandefournitureRepo.upload( entity.getCommandeFourniture()));
            }
        
            PreparedStatement req = Env.getBdd().prepareStatement("UPDATE LinkFournitureCommandeFourniture set quantite = ?,  ref_fourniture = ?,  ref_commandefourniture = ? WHERE id = ?;");

            req.setInt(1, entity.getQuantite());
            req.setInt(2, entity.getFourniture().getId());
            req.setInt(3, entity.getCommandeFourniture().getId());
            req.setInt(4, entity.getId());
            req.executeUpdate();

            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public boolean delete(LinkFournitureCommandeFourniture entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("DELETE FROM LinkFournitureCommandeFourniture WHERE id = ?;");
            req.setInt(1,entity.getId());
            req.executeUpdate();
            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public int upload(LinkFournitureCommandeFourniture entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("INSERT into LinkFournitureCommandeFourniture(quantite, Fourniture, CommandeFourniture) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            req.setInt(1, entity.getQuantite());
            req.setInt(2, entity.getFourniture().getId());
            req.setInt(3, entity.getCommandeFourniture().getId());
            req.executeUpdate();
            ResultSet rs = req.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }

    public ArrayList<LinkFournitureCommandeFourniture> findBy(String filters){
        try {
        FournitureRepository fournitureRepo = new FournitureRepository();

        CommandeFournitureRepository commandefournitureRepo = new CommandeFournitureRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from LinkFournitureCommandeFourniture WHERE "+((!filters.isEmpty() && !filters.isBlank())?filters:"1 = 1"));
            ResultSet res = req.executeQuery();
            ArrayList<LinkFournitureCommandeFourniture> list = new ArrayList<LinkFournitureCommandeFourniture>();
            while (res.next()){
                list.add( new LinkFournitureCommandeFourniture( res.getInt("id"), res.getInt("quantite"), fournitureRepo.findById(res.getInt("ref_fourniture")) , commandefournitureRepo.findById(res.getInt("ref_commandefourniture"))  ) );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkFournitureCommandeFourniture findById(int id){
        try {
        FournitureRepository fournitureRepo = new FournitureRepository();

        CommandeFournitureRepository commandefournitureRepo = new CommandeFournitureRepository();

            PreparedStatement req = Env.getBdd().prepareStatement("Select * from LinkFournitureCommandeFourniture WHERE id = ?");
            req.setInt(1, id);
            ResultSet res = req.executeQuery();
            res.next();
            LinkFournitureCommandeFourniture rep = new LinkFournitureCommandeFourniture( res.getInt("id"), res.getInt("quantite"), fournitureRepo.findById(res.getInt("ref_fourniture")) , commandefournitureRepo.findById(res.getInt("ref_commandefourniture"))  );
            return rep;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
