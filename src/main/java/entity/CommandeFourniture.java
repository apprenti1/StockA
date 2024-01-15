package entity;

public class CommandeFourniture {

    private int id;
    private int valid;
    private String raison ;
    private int etat;
    private int ref_utilisateur;
    private int ref_fournisseur;

    public CommandeFourniture(int id, int valid, String raison, int etat, int ref_utilisateur, int ref_fournisseur) {
        this.id = id;
        this.valid = valid;
        this.raison = raison;
        this.etat = etat;
        this.ref_utilisateur = ref_utilisateur;
        this.ref_fournisseur = ref_fournisseur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getRef_utilisateur() {
        return ref_utilisateur;
    }

    public void setRef_utilisateur(int ref_utilisateur) {
        this.ref_utilisateur = ref_utilisateur;
    }

    public int getRef_fournisseur() {
        return ref_fournisseur;
    }

    public void setRef_fournisseur(int ref_fournisseur) {
        this.ref_fournisseur = ref_fournisseur;
    }
}
