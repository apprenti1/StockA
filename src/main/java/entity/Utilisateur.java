package entity;

import bdd.Env;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private String role;

    // private boolean valid;
    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String email, String role) {

        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.role = role;
        // this.valid = valid;
    }
    public Utilisateur(String nom, String prenom, String email, String mdp, String role){
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.mdp=mdp;
        this.role=role;
    }
    private Utilisateur(int id,String nom, String prenom, String mail, String role){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.role=role;
    }
    public Utilisateur(String mail, String mdp){
        this.email=email;
        this.mdp=mdp;
    }


    public Utilisateur(int id_user, String nom, String prenom, String email, String mdp, String role) {
        this.id=id_user;
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.mdp=mdp;
        this.role=role;
    }

    public ResultSet all()throws SQLException{
        Env connexion = new Env();
        PreparedStatement requete = connexion.getBdd().prepareStatement("SELECT * FROM `utilisateur`");
        ResultSet em = requete.executeQuery();
        return em;
    }
    public void login()throws SQLException {
        Env connexion = new Env();
        PreparedStatement requete = connexion.getBdd().prepareStatement("SELECT * FROM `utilisateur` where mail=? and mdp=?");
        requete.setString(1, email);
        requete.setString(2, mdp);
        ResultSet rs = requete.executeQuery();
        if (rs.next()){
            this.id=rs.getInt("id_utilisateur");
            this.nom=rs.getString("nom");
            this.prenom=rs.getString("prenom");
            this.role=rs.getString("role");
        }
        else{
            this.id=0;
        }
    }

    public void insert()throws  SQLException{
        Env inscription = new Env();
        PreparedStatement requete = inscription.getBdd().prepareStatement("INSERT INTO `utilisateur` (`nom`, `prenom`, `mail`, `mdp`, `role`) VALUES (?,?,?,?,?)");
        requete.setString(1, this.nom);
        requete.setString(2, this.prenom);
        requete.setString(3, this.email);
        requete.setString(4, this.mdp);
        requete.setString(5, this.role);
        requete.executeUpdate();
    }

    public int update(String nom, String prenom, String mail, String mdp)throws  SQLException{
        Env connexion = new Env();
        PreparedStatement requete = connexion.getBdd().prepareStatement(" UPDATE `utilisateur` set `nom`=?, `prenom`=?, `mail`=?, `mdp`=?, `role`=?");
        requete.setString(1, nom);
        requete.setString(2, prenom);
        requete.setString(3, mail);
        requete.setString(4, mdp);
        requete.setString(5, this.role);
        return requete.executeUpdate();
    }

    public int updateMdp(String mdp, String mail)throws SQLException{
        Env connexion = new Env();
        PreparedStatement requete = connexion.getBdd().prepareStatement(" UPDATE `utilisateur` set `mdp`=? WHERE `mail`=?");
        requete.setString(2, this.mdp);
        requete.setString(1, this.email);
        System.out.println(requete);
        return requete.executeUpdate();
    }

    public void delete(Utilisateur user)throws  SQLException{
        Env connexion = new Env();
        PreparedStatement requete = connexion.getBdd().prepareStatement(" DELETE FROM `utilisateur` WHERE id_utilisateur=?");
        requete.setInt(1,user.getId());
        requete.executeUpdate();
    }
    public void deleteuser(Utilisateur user)throws  SQLException{
        Env connexion = new Env();
        PreparedStatement requete = connexion.getBdd().prepareStatement(" SELECT * FROM `utilisateur` WHERE mail=?");
        requete.setString(1,user.getEmail());
        ResultSet rs = requete.executeQuery();
        if (rs.next()){
            requete = connexion.getBdd().prepareStatement(" DELETE FROM `utilisateur` WHERE id_utilisateur=?");
            requete.setInt(1,rs.getInt(1));
            requete.executeUpdate();
        }else{
            return;
        }

    }

    public ResultSet lister(ResultSet resultat)throws SQLException {
        Env connexion = new Env();
        PreparedStatement requete = connexion.getBdd().prepareStatement("SELECT * FROM `utilisateur`");
        resultat = requete.executeQuery();
        while (resultat.next()){
            // a compléter :)
        }
        return resultat;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}



