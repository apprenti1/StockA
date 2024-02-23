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
    private Button inscription;

    @FXML
    void Connexion(ActionEvent event) {
        Main.changeScene("Connexion", new ConnexionController(), "Connexion");

    }

    @FXML
    void Inscription(ActionEvent event) {
        Main.changeScene("Inscription", new Inscription(),"");

    }

    @FXML
    void switchAccueil(MouseEvent event) {
        Main.changeScene("Accueil", new Accueil(),"Accueil");


    }



}

  /*  @FXML
    void switchConnexion(ActionEvent event) {
        Main.changeScene("Connexion", new ConnexionController(), "Connexion");
    }
*/



