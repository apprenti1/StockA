package controller;

import application.Main;
import entity.UtilisateurConnecte;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javamailer.MdpOublier;
import javafx.scene.paint.Color;
import entity.Utilisateur;
import bdd.Format;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;


public class ConnexionController {


    @FXML
    private MFXPasswordField Mdp;

    @FXML
    private TextField email;

    @FXML
    private Text erreur;

    @FXML
    void connexion(ActionEvent event) throws SQLException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(this.Mdp.getText().getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        UtilisateurConnecte utilisateur = UtilisateurConnecte.connectUser(this.email.getText(), sb.toString());
        if (utilisateur.getId() != 0) {
            Main.changeScene("/application/Admin/PageAdminlog", new PageAdminlog());
        } else {
            this.erreur.setVisible(true);
            System.out.println(sb);
            UtilisateurConnecte.setUniqueInstance();
        }
    }


    @FXML
    void switchAccueil(MouseEvent event) {
        Main.changeScene("/application/Accueil");

    }


    @FXML
    void MdpOubli(MouseEvent event) {
        Main.changeScene("/application/javamailer/MdpOublier",new MdpOublier());
    }
}

