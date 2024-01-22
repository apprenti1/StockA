package entity;

public class CommandeFourniture {

    private int id;
    private int valid;
    private String raison ;
    private int etat;
    private Utilisateur utilisateur;
    private Fournisseur fournisseur;

    public CommandeFourniture(int id, int valid, String raison, int etat, int ref_utilisateur, int ref_fournisseur) {
        this.id = id;
        this.valid = valid;
        this.raison = raison;
        this.etat = etat;
        this.utilisateur = utilisateur;
        this.fournisseur = fournisseur;
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

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
}
