package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;


public class Accueil {

    @FXML
    private Button connexion;
    @FXML
    private Button editProfil;
    @FXML
    private Button inscription;
    @FXML
    private Button mineListes;
    @FXML
    private Button mineTypes;


    public Accueil() {
    }

    public void initialize() {
    }

    @FXML
    void switchAccueil(MouseEvent event) {
    }

    @FXML
    void switchConnexion(ActionEvent event) {
        Main.changeScene("Connexion", new Connexion(), "Connexion");
    }
    @FXML private Button admin;
    @FXML
    void switchToPageAdmin(ActionEvent event) {
        Main.changeScene("PageAdminSalle", new PageAdminSalle(), "PageAdminSalle");
    }

    @FXML
    void switchInscription(ActionEvent event) {
    }

    @FXML
    void switchEditProfil(ActionEvent event) {
    }

    @FXML
    void switchMineListes(ActionEvent event) {
    }

    @FXML
    void switchMineTypes(ActionEvent event) {
    }
}
