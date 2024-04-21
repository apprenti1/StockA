package controller;

import application.Main;
import entity.Utilisateur;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import repo.UtilisateurRepository;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;


public class Connexion extends Default{

    @FXML private TextField email;
    @FXML private Text erreur;
    @FXML private MFXPasswordField mdp;

    public Connexion() {
        super((Utilisateur) null);
    }

    public void initialize() {
        super.initialize();
    }

    @FXML void backswitch(ActionEvent event) {
        Main.changeScene("Accueil", new Accueil(null), "Bienvenue sur StockA !!");
    }

    @FXML void connexion(ActionEvent event) {
        if (!(mdp.getText().isBlank() || mdp.getText().isEmpty())) {
            UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
            Utilisateur utilisateur = utilisateurRepository.connect(this.email.getText(), this.mdp.getText());
            if (utilisateur == null) {
                this.erreur.setText("Erreur: l'email et le mot de passe sont incorrect !!");
            } else {
                Main.changeScene("Accueil", new Accueil(utilisateur), "Bienvenue sur StockA !!");
            }
        }
        else {
            this.erreur.setText("Erreur: le mot de passe ne peut être vide !!");
        }
    }

    @FXML void mdpOubli(MouseEvent event) {
        if (!email.getText().isBlank()) {Main.changeScene("MdpOublie", new MdpOublie(email.getText()),"mot de passe oublié");}
        else {erreur.setText("Indiquez un email d'abbord!!!");}
    }

    @FXML void switchAccueil(MouseEvent event) {
        Main.changeScene("Accueil", new Accueil(null), "Bienvenue sur StockA !!");
    }

    @FXML void switchInscription(ActionEvent event) {
        Main.changeScene("Accueil", new Accueil(null), "Bienvenue sur StockA !!");
    }

}
