package entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class RDV {

    // attribute déclaration
    private int id;
    private LocalDate date;
    private LocalTime heure;
    private Utilisateur utilisateur;
    private Salle salle;
    private Dossier dossier;


    public RDV(int id, LocalDate date, LocalTime heure, Utilisateur utilisateur, Salle salle, Dossier dossier) {
        this.id = id;
        this.date = date;
        this.heure = heure;
        this.utilisateur = utilisateur;
        this.salle = salle;
        this.dossier = dossier;
    }

    public RDV(DayOfWeek jour, Salle.Creneau creneau) {
    }


    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getHeure() {
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

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHeure(LocalTime heure) {
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
