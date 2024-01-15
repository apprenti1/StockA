package entity;

public class DemandeFourniture {
    private int id;
    private boolean valid;
    private String raison;
    private int etat;
    private int ref_utilisateur;

    public DemandeFourniture(int id, boolean valid, String raison, int etat, int ref_utilisateur) {
        this.id = id;
        this.valid = valid;
        this.raison = raison;
        this.etat = etat;
        this.ref_utilisateur = ref_utilisateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
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
}
