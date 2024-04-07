package javamailer;

import application.Main;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class MdpOublier {
    public MdpOublier() {
    }



    @FXML
    private Label Erreur;

    @FXML
    private MFXTextField Email;

    @FXML
    void Suivant(ActionEvent event) throws SQLException, NoSuchAlgorithmException {
        if (this.Email.getText().equals("")) {
            this.Erreur.setVisible(true);
        } else {
            Main.changeScene("javamailer/CodeMailer", new CodeMailer(this.Email.getText()),"codemailer");
        }
    }

    @FXML
    void switchAccueil(MouseEvent event) {



    }
}

