package entity;

import java.util.Date;

public class RDV {

    private int id;
    private Date date;
    private int ref_utilisateur;
    private int ref_salle;
    private int ref_dossier;

    public RDV(int id, Date date, int ref_utilisateur, int ref_salle, int ref_dossier) {
        this.id = id;
        this.date = date;
        this.ref_utilisateur = ref_utilisateur;
        this.ref_salle = ref_salle;
        this.ref_dossier = ref_dossier;
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

    public int getRef_utilisateur() {
        return ref_utilisateur;
    }

    public void setRef_utilisateur(int ref_utilisateur) {
        this.ref_utilisateur = ref_utilisateur;
    }

    public int getRef_salle() {
        return ref_salle;
    }

    public void setRef_salle(int ref_salle) {
        this.ref_salle = ref_salle;
    }

    public int getRef_dossier() {
        return ref_dossier;
    }

    public void setRef_dossier(int ref_dossier) {
        this.ref_dossier = ref_dossier;
    }
}
