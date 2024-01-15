package entity;

import java.util.Date;

public class Dossier {
    private int id;
    private Date date;
    private String filliere;
    private String motivation;
    private int ref_utilisateur;
    private int ref_etudiant;

    public Dossier(int id, Date date, String filliere, String motivation, int ref_utilisateur, int ref_etudiant) {
        this.id = id;
        this.date = date;
        this.filliere = filliere;
        this.motivation = motivation;
        this.ref_utilisateur = ref_utilisateur;
        this.ref_etudiant = ref_etudiant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFilliere() {
        return filliere;
    }

    public void setFilliere(String filliere) {
        this.filliere = filliere;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public int getRef_utilisateur() {
        return ref_utilisateur;
    }

    public void setRef_utilisateur(int ref_utilisateur) {
        this.ref_utilisateur = ref_utilisateur;
    }

    public int getRef_etudiant() {
        return ref_etudiant;
    }

    public void setRef_etudiant(int ref_etudiant) {
        this.ref_etudiant = ref_etudiant;
    }
}
