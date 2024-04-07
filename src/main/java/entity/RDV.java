package entity;

import java.util.Date;

public class RDV {

    // attribute déclaration
    private int id;
    private Date date;
    private int heure;
    private Utilisateur utilisateur;
    private Salle salle;
    private Dossier dossier;


    public RDV(int id, Date date, int heure, Utilisateur utilisateur, Salle salle, Dossier dossier) {
        this.id = id;
        this.date = date;
        this.heure = heure;
        this.utilisateur = utilisateur;
        this.salle = salle;
        this.dossier = dossier;
    }


    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getHeure() {
        return heure;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Salle getSalle() {
        return salle;
    }

    public Dossier getDossier() {
        return dossier;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }
}
