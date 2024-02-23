/*package repo;


import bdd.Env;
import entity.Fournisseur;

import java.sql.*;
import java.util.ArrayList;


public class FournisseurRepository {
    public ArrayList<Fournisseur> FindAll(){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Fournisseur");
            ResultSet res = req.executeQuery();
            ArrayList<Fournisseur> list = new ArrayList<Fournisseur>();
            while (res.next()){
                list.add(new Fournisseur( res.getInt("id"),res.getString("libelle"), res.getString("tel"), res.getString("email")));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean Update(Fournisseur entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("UPDATE Fournisseur set libelle = ?, tel = ?, email = ? WHERE id = ?;");
            req.setString(1,(entity.getLibelle()));
            req.setString(2,(entity.getTel()));
            req.setString(3,(entity.getEmail()));
            req.setInt(4,entity.getId());
            req.executeQuery();

            return true;
        } catch (SQLException e) {
            //return false;
            throw new RuntimeException(e);
        }
    }
}
*/