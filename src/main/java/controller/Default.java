package controller;

import application.Main;
import entity.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Default {

    @FXML private Button connexion;
    @FXML private Button navElement1;
    @FXML private Button navElement2;
    @FXML private Button navElement3;
    private Utilisateur utilisateur;

    public Default(Utilisateur utilisateur){
        this.utilisateur = utilisateur;
    }

    public void initialize() {
        System.out.println("|--------------------Chargement interface--------------------|");
        if (utilisateur != null) {
            switch (utilisateur.getRoles()) {
                case 1: // Professeur
                    navElement3.setText("commander");
                    navElement3.setVisible(true);
                    break;
                case 2: // Secrétaire
                    navElement1.setText("dossiers");
                    navElement1.setVisible(true);
                    navElement2.setText("etudiants");
                    navElement2.setVisible(true);
                    navElement3.setText("commander");
                    navElement3.setVisible(true);
                    break;
                case 3: // Gestionnaire de stock
                    navElement1.setText("stock");
                    navElement1.setVisible(true);
                    navElement2.setText("demandes");
                    navElement2.setVisible(true);
                    navElement3.setText("commander");
                    navElement3.setVisible(true);
                    break;
                case 4: // Admin
                    navElement2.setText("Gestion utilisateur");
                    navElement2.setVisible(true);
                    navElement3.setText("Gestion Salle");
                    navElement3.setVisible(true);
                    break;
            }
            connexion.setText("Profil");
        }
        else {
            connexion.setText("Connexion");
        }
    }

    @FXML void navElement1(ActionEvent event) {
        switch (utilisateur.getRoles()) {
            case 1: // Professeur

                break;
            case 2: // Secrétaire
                Main.changeScene("CRUD", new CRUD( Dossier.class, utilisateur), "CRUD | dossiers");

                break;
            case 3: // Gestionnaire de stock
                Main.changeScene("CRUD", new CRUD( CommandeFourniture.class, utilisateur), "CRUD | Sorties de stock");

                break;
            case 4: // Admin

                break;
        }
    }
    @FXML void navElement2(ActionEvent event) {
        switch (utilisateur.getRoles()) {
            case 1: // Professeur

                break;
            case 2: // Secrétaire
                Main.changeScene("CRUD", new CRUD( Etudiant.class, utilisateur), "CRUD | etudiants");

                break;
            case 3: // Gestionnaire de stock
                Main.changeScene("CRUD", new CRUD( DemandeFourniture.class, utilisateur), "CRUD | demandes");

                break;
            case 4: // Admin
                Main.changeScene("CRUD", new CRUD( Utilisateur.class, utilisateur), "CRUD | Utilisateur");
                break;
        }
    }
    @FXML void navElement3(ActionEvent event) {
        switch (utilisateur.getRoles()) {
            case 1: // Professeur
                Main.changeScene("CRUD", new CRUD( CommandeFourniture.class, utilisateur), "CRUD | commander");

                break;
            case 2: // Secrétaire
                Main.changeScene("CRUD", new CRUD( CommandeFourniture.class, utilisateur), "CRUD | commander");

                break;
            case 3: // Gestionnaire de stock
                Main.changeScene("CRUD", new CRUD( CommandeFourniture.class, utilisateur), "CRUD | commander");

                break;
            case 4: // Admin
                Main.changeScene("CRUD", new CRUD( Salle.class, utilisateur), "CRUD | salles");

                break;
        }
    }

    @FXML void switchAccueil(MouseEvent event) {
        Main.changeScene("Accueil", new Accueil(utilisateur), "Accueil");
    }
    @FXML void switchConnexion(ActionEvent event) {
        if (this.getUtilisateur() == null){
            Main.changeScene("Connexion", new Connexion(), "Connexion");
        }
        else {
            Main.changeScene("Profil", new Profil(this.getUtilisateur(), false), ("Profil | " + this.getUtilisateur().getPrenom()));
        }
    }

    public Utilisateur getUtilisateur() {return utilisateur;}
    public void setUtilisateur(Utilisateur utilisateur) {this.utilisateur = utilisateur;}
}
