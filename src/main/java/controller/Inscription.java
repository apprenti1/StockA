package controller;
import io.github.palexdev.materialfx.controls.MFXPasswordField;

import application.Main;
import entity.Utilisateur;
import repo.UtilisateurRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.HashMap;
import java.util.Map;

public class Inscription extends Default implements Initializable {

    @FXML
    private MFXPasswordField conf;


    @FXML
    private TextField email;

    @FXML
    private Label error;

    @FXML
    private MFXPasswordField mdp;


    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private MenuButton roles;
    @FXML
    private Label lmdp;

    @FXML
    private Label lmdp1;

    @FXML
    private Label lmdp11;

    @FXML
    private Label lmdp2;

    @FXML
    private Label lmdp21;

    private UtilisateurRepository utilisateurRepository;

    public Inscription(Utilisateur utilisateur) {
        super(utilisateur);
    }

    @FXML
    void professeur(MouseEvent event) {
        roles.setText("Professeur");
    }

    @FXML
    void secretaire(MouseEvent event) {
        roles.setText("Secretaire");
    }

    @FXML
    void gestionnaire(MouseEvent event) {
        roles.setText("Gestionnaire");
    }

    @FXML
    void connexion(MouseEvent event) throws SQLException, NoSuchAlgorithmException {
        if (mdp.getText().equals(conf.getText()) && !email.getText().isEmpty() && !nom.getText().isEmpty() && !prenom.getText().isEmpty()) {
            String mdpString = mdp.getText();
            boolean aSpe = false, aMin = false, aMaj = false;
            String min = "azertyuiopqsdfghjklmwxcvbn";
            String max = "AZERTYUIOPQSDFGHJKLMWXCVBN";
            String spe = "!?%&$*.";
            if (mdpString.length() > 10) {
                for (char c : mdpString.toCharArray()) {
                    if (max.contains(String.valueOf(c)))
                        aMaj = true;
                    if (min.contains(String.valueOf(c)))
                        aMin = true;
                    if (spe.contains(String.valueOf(c)))
                        aSpe = true;
                }
            }
            if (aSpe && aMaj && aMin) {
                MessageDigest md = MessageDigest.getInstance("SHA1");
                md.update(mdp.getText().getBytes());
                byte[] byteData = md.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b : byteData) {
                    sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
                }

                String selectedRole = roles.getText();

                int roleValue;
                switch(selectedRole) {
                    case "Professeur":
                        roleValue = 1;
                        break;
                    case "Secretaire":
                        roleValue = 2;
                        break;
                    case "Gestionnaire":
                        roleValue = 3;
                        break;
                    default:
                        roleValue = 0;
                }

                Utilisateur utilisateur = new Utilisateur(0, nom.getText(), prenom.getText(), email.getText(), sb.toString(), roleValue);

                int userId = utilisateurRepository.upload(utilisateur);

                Main.changeScene("CRUD", new CRUD(Utilisateur.class, utilisateur), "crud");
            } else {
                error.setVisible(true);
            }
        } else {
            error.setVisible(true);
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        MenuItem professeurItem = new MenuItem("Professeur");
        professeurItem.setOnAction(e -> {roles.setText("Professeur");});

        MenuItem secretaireItem = new MenuItem("Secretaire");
        secretaireItem.setOnAction(e ->{ roles.setText("Secretaire");});

        MenuItem gestionnaireItem = new MenuItem("Gestionnaire");
        gestionnaireItem.setOnAction(e -> {roles.setText("Gestionnaire");});

        roles.getItems().addAll(professeurItem, secretaireItem, gestionnaireItem);

        utilisateurRepository = new UtilisateurRepository();
    }
}