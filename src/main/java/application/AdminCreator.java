package application;

import entity.Utilisateur;
import repo.UtilisateurRepository;

public class AdminCreator {
    public static void main(String[] args) {
        String nom = "admin";
        String prenom = "admin";
        String email = "a";
        String mdp = "a";
        System.out.println(Security.hash(mdp));
        Utilisateur utilisateur = new Utilisateur(0, nom, prenom, email, mdp, 4);
        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        utilisateurRepository.upload(utilisateur);
    }
}
