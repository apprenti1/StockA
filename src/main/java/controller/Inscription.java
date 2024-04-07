package controller;
import application.Main;
import application.Env;
import javafx.scene.control.Label;

import controller.CRUD;
import entity.Utilisateur;
import repo.UtilisateurRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Map;
import java.util.HashMap;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Inscription implements Initializable {

    @FXML
    private PasswordField conf;

    @FXML
    private TextField email;
    @FXML
    private Label error;
    @FXML
    private PasswordField mdp;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private MenuButton roles;

    private String[] choix = {"Professeur", "Secretaire", "Gestionnaire"};
    private Map<String, Integer> rolesMapping = new HashMap<>();



    private UtilisateurRepository utilisateurRepository;

    @FXML
    void connexion(MouseEvent event) throws SQLException, NoSuchAlgorithmException {

        // check si info vide et mdp ok
        if (this.mdp.getText().equals(this.conf.getText()) && (!this.email.getText().equals("") && !this.nom.getText().equals("") && !this.prenom.getText().equals(""))) {
            //vérifier la conformité du mdp
            // -> 10 char
            // -> 1 MAJ
            // -> 1 min
            // -> 1 spé
            String mdp = this.mdp.getText();
            boolean aSpe = false,aMin=false,aMaj=false;
            String min ="azertyuiopqsdfghjklmwxcvbn";
            String max ="AZERTYUIOPQSDFGHJKLMWXCVBN";
            String spe ="?!%&$*.";
            if (mdp.length()>10){
                for (char c : mdp.toCharArray()) {
                    if (max.contains(c+""))
                        aMaj = true;
                    if (min.contains(c+""))
                        aMin = true;
                    if (spe.contains(c+""))
                        aSpe = true;
                }
            }
            if(aSpe && aMaj && aMin){
                MessageDigest md = MessageDigest.getInstance("SHA1");
                md.update(this.mdp.getText().getBytes());
                byte byteData[] = md.digest();
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < byteData.length; i++) {
                    sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
                }

                String selectedRole = roles.getText();
                int selectedRoleId = rolesMapping.get(selectedRole);
                // Créer un nouvel utilisateur
                Utilisateur utilisateur = new Utilisateur(0, nom.getText(), prenom.getText(), email.getText(), sb.toString(), selectedRoleId);

                int userId = utilisateurRepository.upload(utilisateur);
                // Changer de scène vers la page de connexion

            Main.changeScene("CRUD", new CRUD( Utilisateur.class, utilisateur), "crud");
            } else {
                this.error.setVisible(true);
            }
        }else{
            this.error.setVisible(true);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (String role : choix) {
            MenuItem item = new MenuItem(role);
            item.setOnAction(e -> {
                roles.setText(role);
                // Lorsque l'utilisateur sélectionne un rôle, récupérez l'ID correspondant
                int selectedRole = rolesMapping.get(role);
            });
            roles.getItems().add(item);
        }
        rolesMapping.put("Professeur", 1);
        rolesMapping.put("Secretaire", 2);
        rolesMapping.put("Gestionnaire", 3);

        utilisateurRepository = new UtilisateurRepository();
    }

    @FXML
    void switchAccueil(MouseEvent event) {

    }

}
