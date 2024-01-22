package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ConnexionController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button LoginButton;

    @FXML
    private void initialize() {
        // Initialisation du contrôleur, si nécessaire
    }

    @FXML
    private void handleConnectButton(ActionEvent event) {
        // Code à exécuter lors du clic sur le bouton de connexion
        String email = emailField.getText();
        String password = passwordField.getText();

        // Ajoutez ici le code pour traiter la connexion en utilisant les informations email et mot de passe
        // Par exemple, vous pouvez vérifier les informations dans une base de données ou un service d'authentification

        // Après la connexion réussie, vous pouvez rediriger l'utilisateur vers une autre vue
        // Vous pouvez utiliser la classe Main pour gérer les changements de scène, par exemple:
        // Main.switchToAccueil(); // Supposons que vous avez une méthode switchToAccueil dans votre classe Main
    }
}
