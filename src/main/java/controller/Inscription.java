package controller;

import application.Main;
import controller.UtilisateurController;
import io.github.palexdev.materialfx.controls.MFXFilterComboBox;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entity.Utilisateur;
import bdd.Format;



public class Inscription implements Initializable {

    @FXML
    private MFXTextField Email;

    @FXML
    private Label Error;

    @FXML
    private MFXPasswordField Mdp;

    @FXML
    private MFXPasswordField Mdpconfirmer;

    @FXML
    private MFXTextField Nom;

    @FXML
    private MFXTextField Prenom;

    @FXML
    private MFXFilterComboBox<String> Role;



    private String[] choix = {"Professeur","Secretaire","Gestionnaire"};



    @FXML
    void switchAccueil(MouseEvent event){Main.changeScene("Accueil", new Accueil(), "Bienvenue dans Stocka");}


    @FXML
    void connexion(MouseEvent event) throws SQLException, NoSuchAlgorithmException {

        // check si info vide et mdp ok
        if (this.Mdp.getText().equals(this.Mdpconfirmer.getText()) && (!this.Email.getText().equals("") && !this.Nom.getText().equals("") && !this.Prenom.getText().equals(""))) {
            //vérifier la conformité du mdp
            // -> 10 char
            // -> 1 MAJ
            // -> 1 min
            // -> 1 spé
            String mdp = this.Mdp.getText();
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
                md.update(this.Mdp.getText().getBytes());
                byte byteData[] = md.digest();
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < byteData.length; i++) {
                    sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
                }
                Utilisateur moncompte = new Utilisateur(this.Nom.getText(), this.Prenom.getText(), this.Email.getText(), sb.toString(), this.Role.getText());
                moncompte.insert();
                Main.changeScene("Connexion", new  ConnexionController(), "Connexion");
            }else {
                this.Error.setVisible(true);
            }
        }else{
            this.Error.setVisible(true);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Role.getItems().addAll(choix);
    }
}