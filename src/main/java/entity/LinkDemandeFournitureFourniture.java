package entity;

public class LinkDemandeFournitureFourniture {

    // attribute déclaration
    private int id;
    private int quantite;
    private DemandeFourniture demandeFourniture;
    private Fourniture fourniture;


    public LinkDemandeFournitureFourniture(int id, int quantite, DemandeFourniture demandeFourniture, Fourniture fourniture) {
        this.id = id;
        this.quantite = quantite;
        this.demandeFourniture = demandeFourniture;
        this.fourniture = fourniture;
    }


    public int getId() {
        return id;
    }

    public int getQuantite() {
        return quantite;
    }

    public DemandeFourniture getDemandeFourniture() {
        return demandeFourniture;
    }

    public Fourniture getFourniture() {
        return fourniture;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setDemandeFourniture(DemandeFourniture demandeFourniture) {
        this.demandeFourniture = demandeFourniture;
    }

    public void setFourniture(Fourniture fourniture) {
        this.fourniture = fourniture;
    }
}
