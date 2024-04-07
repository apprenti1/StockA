package controller;

import application.Main;
import entity.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Accueil extends Default{

    @FXML private Button connexion;
    @FXML private Button inscription;
    @FXML private Label role;
    @FXML private Label title;

    public Accueil(Utilisateur utilisateur) {
        super(utilisateur);
    }

    public void initialize() {
        super.initialize();
        if (super.getUtilisateur() != null) {
            title.setText(super.getUtilisateur().getPrenom());
            connexion.setText("Profil");
            inscription.setText("Déconnexion");
            role.setText(
                    (super.getUtilisateur().getRoles() == 1)?"Professeur": (
                    (super.getUtilisateur().getRoles() == 2)?"Secrétaire":(
                    (super.getUtilisateur().getRoles() == 3)?"Gestionnaire de stock":"Admin"))
            );
        }
    }

    @FXML void switchAccueil(MouseEvent event) {
        Main.changeScene("Accueil", new Accueil(null), "Bienvenue dans StockA");
    }

    @FXML void switchConnexion(ActionEvent event) {
        if (super.getUtilisateur() == null){
            Main.changeScene("Connexion", new Connexion(), "Connexion");
        }
        else {
            Main.changeScene("Profil", new Profil(super.getUtilisateur()), ("Profil | " + super.getUtilisateur().getPrenom()));
        }
    }

    @FXML void switchInscription(ActionEvent event) {
        if (super.getUtilisateur() == null){
            Main.changeScene("Connexion", new Connexion(), "Connexion");
        }
        else {
            Main.changeScene("Accueil", new Accueil(null), "Bienvenue sur StockA !!!");
        }
    }

}
