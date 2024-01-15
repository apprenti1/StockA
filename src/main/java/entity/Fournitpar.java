package entity;

public class Fournitpar {
    private int prix;
    private int ref_fournisseur;
    private int ref_fourniture;

    public Fournitpar(int prix, int ref_fournisseur, int ref_fourniture) {
        this.prix = prix;
        this.ref_fournisseur = ref_fournisseur;
        this.ref_fourniture = ref_fourniture;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getRef_fournisseur() {
        return ref_fournisseur;
    }

    public void setRef_fournisseur(int ref_fournisseur) {
        this.ref_fournisseur = ref_fournisseur;
    }

    public int getRef_fourniture() {
        return ref_fourniture;
    }

    public void setRef_fourniture(int ref_fourniture) {
        this.ref_fourniture = ref_fourniture;
    }
}
