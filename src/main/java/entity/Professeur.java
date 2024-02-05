package entity;

public class Professeur extends Utilisateur {
    private int id_professeur;
    public Professeur(int id_professeur, String nom, String prenom, String email, String mdp, int role){
        super(id_professeur, nom, prenom, email, mdp, role);
        this.id_professeur = id_professeur;
    }
}
