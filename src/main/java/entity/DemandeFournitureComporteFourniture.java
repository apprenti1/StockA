package entity;
import java.util.List;
public class DemandeFournitureComporteFourniture {
    private int id;
    private DemandeFournitureProfesseur demandeFourniture;
    private List<Fourniture> fournitures;

    public DemandeFournitureComporteFourniture(int id, DemandeFournitureProfesseur demandeFourniture, List<Fourniture> fournitures){
        this.id =id;
        this.demandeFourniture = demandeFourniture;
        this.fournitures = fournitures;
    }

    public int getid (){
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public DemandeFournitureProfesseur getDemandeFourniture() {
        return demandeFourniture;
    }

    public void setDemandeFourniture(DemandeFournitureProfesseur demandeFourniture) {
        this.demandeFourniture = demandeFourniture;
    }

    public List<Fourniture> getFournitures() {
        return fournitures;
    }

    public void setFournitures(List<Fourniture> fournitures) {
        this.fournitures = fournitures;
    }

    @Override
    public String toString() {
        return "DemandeFournitureComporteFourniture{" +
                "id=" + id +
                ", demandeFourniture=" + demandeFourniture +
                ", fournitures=" + fournitures +
                '}';
    }
}
