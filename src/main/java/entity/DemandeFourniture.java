package entity;

public class DemandeFourniture {

    // attribute déclaration
    private int id;
    private boolean valid;
    private String raison;
    private int etat;
    private Utilisateur utilisateur;

    public DemandeFourniture(int id, boolean valid, String raison, int etat, Utilisateur utilisateur) {
        this.id = id;
        this.valid = valid;
        this.raison = raison;
        this.etat = etat;
        this.utilisateur = utilisateur;
    }


    public int getId() {
        return id;
    }

    public boolean isValid() {
        return valid;
    }

    public String getRaison() {
        return raison;
    }

    public int getEtat() {
        return etat;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }


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
}
