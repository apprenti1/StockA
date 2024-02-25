package controller;
import entity.UtilisateurConnecte;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class MonProfil implements Initializable {

    private UtilisateurConnecte utilisateur;

    public MonProfil(){ this.utilisateur=UtilisateurConnecte.getUniqueInstance();}
    @FXML
    private Label nom;

    @FXML
    private Label prenom;

    @FXML
    private Label role;

    @FXML
    void Deconnexion(MouseEvent event) {
        UtilisateurConnecte.setUniqueInstance();
        Main.changeScene("/application/Accueil");

    }

    @FXML
    void switchAccueil(MouseEvent event) {
        Main.changeScene("/application/Admin/PageAdminlog", new PageAdminlog());

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.nom.setText(this.utilisateur.getNom());
        this.prenom.setText((this.utilisateur.getPrenom()));
        this.role.setText(this.utilisateur.getRole());
    }

}
