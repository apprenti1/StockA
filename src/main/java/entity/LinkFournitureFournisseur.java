package entity;

public class LinkFournitureFournisseur {

    // attribute déclaration
    private int id;
    private double prix;
    private Fourniture fourniture;
    private Fournisseur fournisseur;


    public LinkFournitureFournisseur(int id, double prix, Fourniture fourniture, Fournisseur fournisseur) {
        this.id = id;
        this.prix = prix;
        this.fourniture = fourniture;
        this.fournisseur = fournisseur;
    }


    public int getId() {
        return id;
    }

    public double getPrix() {
        return prix;
    }

    public Fourniture getFourniture() {
        return fourniture;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }


    public void setId(int id) {
        this.id = id;
    }
}
