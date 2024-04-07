package entity;

import java.util.Date;

public class Dossier {

    // attribute déclaration
    private int id;
    private Date date;
    private String filiere;
    private String motivation;
    private Utilisateur utilisateur;
    private Etudiant etudiant;


    public Dossier(int id, Date date, String filiere, String motivation, Utilisateur utilisateur, Etudiant etudiant) {
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

    public Date getDate() {
        return date;
    }

    public String getFiliere() {
        return filiere;
    }

    public String getMotivation() {
        return motivation;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}
