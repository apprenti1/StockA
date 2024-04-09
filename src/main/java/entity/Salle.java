package entity;

import controller.Default;

public class Salle {

    // attribute déclaration
    private int id;
    private String libelle;


    public Salle( String libelle) {

        this.libelle = libelle;
    }

    public Salle(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }


    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
