package controller;

import application.Main;
import entity.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import repo.UtilisateurRepository;

public class Profil extends Default {

    @FXML private PasswordField conf;
    @FXML private TextField email;
    @FXML private Text erreur;
    @FXML private PasswordField mdp;
    @FXML private TextField nom;
    @FXML private TextField prenom;
    @FXML private ComboBox<?> role;
    @FXML private Label roleLabel;



    public Profil(Utilisateur utilisateur) {
        super(utilisateur);
    }

    public void initialize() {
        super.initialize();
        nom.setText(super.getUtilisateur().getNom());
        prenom.setText(super.getUtilisateur().getPrenom());
        email.setText(super.getUtilisateur().getEmail());
    }

    @FXML void modification(ActionEvent event) {
        if (!(mdp.getText().isBlank() || mdp.getText().isEmpty())) {
            if (mdp.getText().equals(conf.getText())) {
                super.getUtilisateur().setNom(nom.getText());
                super.getUtilisateur().setPrenom(prenom.getText());
                super.getUtilisateur().setEmail(email.getText());
                super.getUtilisateur().setMdp(mdp.getText());
                UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
                utilisateurRepository.update(super.getUtilisateur());
            }
            else {
                erreur.setText("Erreur: le mot de passe et la confirmation ne sont pas identiques !!");
            }
        }
        else {
            erreur.setText("Erreur: vous n'avez pas défini de mot de passe !!");
        }
    }

    @FXML void switchAccueil(MouseEvent event) {
        Main.changeScene("Accueil", new Accueil(super.getUtilisateur()), "Bienvenue sur StockA !!!");
    }

    @FXML void switchConnexion(ActionEvent event) {
        Main.changeScene("Accueil", new Accueil(null), "Bienvenue sur StockA !!!");

    }

    @FXML void roleSelected(ActionEvent event) {

    }

}
