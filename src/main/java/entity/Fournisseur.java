package entity;

import javafx.util.Pair;

import java.util.ArrayList;

public class Fournisseur {

    // attribute déclaration
    private int id;
    private String libelle;
    private String tel;
    private String email;
    private ArrayList<Pair<Fourniture, Double>> fournitures;



    public Fournisseur(int id, String libelle, String tel, String email) {
        this.id = id;
        this.libelle = libelle;
        this.tel = tel;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Pair<Fourniture, Double>> getFournitures() {return fournitures;}


    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFournitures(ArrayList<Pair<Fourniture, Double>> fournitures) {this.fournitures = fournitures;}
}
