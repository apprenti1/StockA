package entity;

import java.util.Date;

public class RDV {

    private int id;
    private Date date;

    private DemandeFournitureProfesseur demandeFourniture;

    private Professeur professeur;

    private Etudiant etudiant;

    private Salle salle;


    public RDV(int id, Date date, DemandeFournitureProfesseur demandeFourniture, Professeur professeur, Etudiant etudiant, Salle salle) {
        this.id = id;
        this.date = date;
        this.demandeFourniture = demandeFourniture;
        this.professeur = professeur;
        this.etudiant = etudiant;
        this.salle = salle;
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

    public DemandeFournitureProfesseur getDemandeFourniture() {
        return demandeFourniture;
    }

    public void setDemandeFourniture(DemandeFournitureProfesseur demandeFourniture) {
        this.demandeFourniture = demandeFourniture;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    @Override
    public String toString() {
        return "RDV{" +
                "id=" + id +
                ", date=" + date +
                ", demandeFourniture=" + demandeFourniture +
                ", professeur=" + professeur +
                ", etudiant=" + etudiant +
                ", salle=" + salle +
                '}';
    }
}

