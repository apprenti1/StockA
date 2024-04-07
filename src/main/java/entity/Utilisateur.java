package entity;

public class Utilisateur {
    
    // attribute déclaration
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private int roles;

    
    // constructor
    public Utilisateur(int id, String nom, String prenom, String email, String mdp, int roles) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.roles = roles;
    }


    // getters
    public int getId() {return id;}
    public String getNom() {return nom;}
    public String getPrenom() {return prenom;}
    public String getEmail() {return email;}
    public String getMdp() {return mdp;}
    public int getRoles() {return roles;}


    // setters
    public void setId(int id) {this.id = id;}
    public void setNom(String nom) {this.nom = nom;}
    public void setPrenom(String prenom) {this.prenom = prenom;}
    public void setEmail(String email) {this.email = email;}
    public void setMdp(String mdp) {this.mdp = mdp;}
    public void setRoles(int roles) {this.roles = roles;}
}


