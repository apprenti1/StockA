package entity;




public class Fournitpar {
    private int id;
    private Fourniture fourniture;
    private Fournisseur fournisseur;
    private double prix;

    public Fournitpar(int id, Fourniture fourniture, Fournisseur fournisseur, double prix) {
        this.id = id;
        this.fourniture = fourniture;
        this.fournisseur = fournisseur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fourniture getFourniture() {
        return fourniture;
    }

    public void setFourniture(Fourniture fourniture) {
        this.fourniture = fourniture;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "FournitPar{" +
                "id=" + id +
                ", fourniture=" + fourniture +
                ", fournisseur=" + fournisseur +
                ", prix=" + prix +
                '}';
    }
}

