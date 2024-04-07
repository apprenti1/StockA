package entity;

public class CommandeFourniture {

    // attribute déclaration
    private int id;
    private boolean valid;
    private String raison;
    private int etat;
    private Utilisateur utilisateur;
    private Fournisseur fournisseur;
    
    
    // constructor
    public CommandeFourniture(int id, boolean valid, String raison, int etat, Utilisateur utilisateur, Fournisseur fournisseur) {
        this.id = id;
        this.valid = valid;
        this.raison = raison;
        this.etat = etat;
        this.utilisateur = utilisateur;
        this.fournisseur = fournisseur;
    }
    
    
    // getters
    public int getId() { return id;}
    public boolean isValid() { return valid;}
    public String getRaison() { return raison;}
    public int getEtat() { return etat;}
    public Utilisateur getUtilisateur() { return utilisateur;}
    public Fournisseur getFournisseur() { return fournisseur;}


    // setters

    public void setId(int id) {
        this.id = id;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
}
