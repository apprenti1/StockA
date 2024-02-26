package entity;

import bdd.Env;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Etudiant {
    private int id;

    private String nom;
    private String prenom;
    private String diplome;
    private String telephone;
    private String email;

    private String rue;

    private int cp;

    private String ville;

    public Etudiant(){}

    public Etudiant(String nom,String prenom,String email,String diplome,String telephone, String rue,int cp, String ville){
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.diplome=diplome;
        this.telephone=telephone;
        this.rue=rue;
        this.cp=cp;
        this.ville=ville;
    }

    public Etudiant(int id,String nom,String prenom,String email,String diplome,String telephone, String rue,int cp, String ville){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.diplome=diplome;
        this.telephone=telephone;
        this.rue=rue;
        this.cp=cp;
        this.ville=ville;
    }
    public Etudiant(int id){
        this.id=id;
    }

    public ResultSet lister(ResultSet resultat)throws SQLException {
        Env connexion = new Env();
        PreparedStatement requete = connexion.getBdd().prepareStatement("SELECT * FROM `etudiant`");
        resultat = requete.executeQuery();
        return resultat;
    }
    public ResultSet select()throws SQLException{
        Env connexion = new Env();
        PreparedStatement requete = connexion.getBdd().prepareStatement("SELECT * FROM `etudiant`");
        return requete.executeQuery();
    }
    public void enregistrer()throws SQLException{
        Env connexion = new Env();
        PreparedStatement requete = connexion.getBdd().prepareStatement("INSERT INTO etudiant (`nom`,`prenom`,`email`,`diplome`,`telephone`,`rue`,`cp`,`ville`) VALUES (?,?,?,?,?,?,?,?)");
        requete.setString(1,this.nom);
        requete.setString(2,this.prenom);
        requete.setString(3,this.email);
        requete.setString(4,this.diplome);
        requete.setString(5,this.telephone);
        requete.setString(6,this.rue);
        requete.setInt(7,this.cp);
        requete.setString(8,this.ville);
        requete.executeUpdate();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getdiplome() {
        return diplome;
    }

    public void setdiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String  telephone) {
        this.telephone = telephone;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}


