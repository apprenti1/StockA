package entity;

import java.util.Date;

public class DossierInscription {
    private int id;
    private Date date;
    private String filiere;
    private String motivation;
    private Utilisateur utilisateur;
    private Etudiant etudiant;

    public DossierInscription(int id, Date date, String filiere, String motivation, Utilisateur utilisateur, Etudiant etudiant) {
        this.id = id;
        this.date = date;
        this.filiere = filiere;
        this.motivation = motivation;
        this.utilisateur = utilisateur;
        this.etudiant = etudiant;
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
        return filiere;
    }

    public void setFilliere(String filliere) {
        this.filiere = filliere;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setetudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}
