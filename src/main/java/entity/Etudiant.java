package entity;

import application.Env;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Etudiant {

    // attribute déclaration
    private int id;
    private String dernierDiplome;
    private String tel;
    private String rue;
    private String cp;
    private String ville;
    private Utilisateur utilisateur;


    public Etudiant(){}
    public ResultSet select()throws SQLException {
        Env connexion = new Env();
        PreparedStatement requete = connexion.getBdd().prepareStatement("SELECT * FROM `etudiant`");
        return requete.executeQuery();
    }
    public Etudiant(int id, String dernierDiplome, String tel, String rue, String cp, String ville, Utilisateur utilisateur) {
        this.id = id;
        this.dernierDiplome = dernierDiplome;
        this.tel = tel;
        this.rue = rue;
        this.cp = cp;
        this.ville = ville;
        this.utilisateur = utilisateur;
    }


    public int getId() {
        return id;
    }

    public String getDernierDiplome() {
        return dernierDiplome;
    }

    public String getTel() {
        return tel;
    }

    public String getRue() {
        return rue;
    }

    public String getCp() {
        return cp;
    }

    public String getVille() {
        return ville;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public String getNom() {
        if (utilisateur != null) {
            return utilisateur.getNom();
        } else {
            return null;
        }
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setDernierDiplome(String dernierDiplome) {
        this.dernierDiplome = dernierDiplome;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
