package javamailer;
import application.Main;
import controller.Accueil;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class CodeMailer implements Initializable  {
    private String email;
    public CodeMailer(String email){
        this.email=email;
        this.mailerLost =  new MailerLost(this.email);
    }
    MailerLost mailerLost;

    @FXML
    private MFXTextField Code;

    @FXML
    private Label Erreur;

    @FXML
    void Suivant(ActionEvent event) {
        if(this.Code.getText().equals("") || Integer.parseInt(this.Code.getText())!= mailerLost.getValue()){
            this.Erreur.setVisible(true);
        }else{
           Main.changeScene("javamailer/Modification", new Modification(this.email),"modification");
        }
    }
    @FXML
    void switchAccueil(MouseEvent event) {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.mailerLost.main();
    }
}
