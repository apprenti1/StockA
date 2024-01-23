public class NameRepository{

    public ArrayList<Name> FindAll(){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("Select * from Name");
            ResultSet res = req.executeQuery();
            ArrayList<Name> list = new ArrayList<Name>();
            EntityRepository entityRepo = new EntityRepository();
            while (res.next()){
                list.add(new Name( res.getInt("id"), entityRepo.find(res.getInt("refEntity")) ));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean Update(Name entity){
        try {
            EntityRepository entityRepo = new EntityRepository();
            entityRepo.update( entity.getEntity())
            PreparedStatement req = Env.getBdd().prepareStatement("UPDATE Name set attr1 = ?, attr2 = ? WHERE id = ?;");
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

    public boolean Delete(Name entity){
        try {
            PreparedStatement req = Env.getBdd().prepareStatement("DELETE FROM Name WHERE id = ?;");
            req.setInt(1,entity.getId());
            req.executeQuery();
            return true;
        } catch (SQLException e) {
            return false;
            throw new RuntimeException(e);
        }
    }

    public boolean Upload(Name entity){
        try {
            EntityRepository entityRepo = new EntityRepository();
            entityRepo.upload( entity.getEntity())
            PreparedStatement req = Env.getBdd().prepareStatement("INSERT into Name(attr1, attr2");
            req.setInt(1,entity.getId());
            req.executeQuery();
            return true;
        } catch (SQLException e) {
            return false;
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Name> FindBy(String filters){
        try {
            PreparedStatement req = Bdd.getBdd().prepareStatement("Select * from Name WHERE "+(!filters.isEmpty && filters)?filters:"1 = 1");
            ResultSet res = req.executeQuery();
            ArrayList<Name> list = new ArrayList<Name>();
            EntityRepository entityRepo = new EntityRepository();
            while (res.next()){
                list.add(new Name( res.getInt("id"), entityRepo.find(res.getInt("refEntity")) ));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Name FindById(Name entity){
        try {
            PreparedStatement req = Bdd.getBdd().prepareStatement("Select * from Name WHERE id = ?");
            req.setInt(1,entity.getId());
            ResultSet res = req.executeQuery();
            EntityRepository entityRepo = new EntityRepository();
            res.next()
            Name rep = new Name( res.getInt("id"), entityRepo.find(res.getInt("refEntity")) );
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    }