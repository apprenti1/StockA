package controller;

import application.Main;
import application.Security;
import email.Email;
import entity.Utilisateur;
import jakarta.mail.MessagingException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import repo.UtilisateurRepository;

import java.io.UnsupportedEncodingException;

public class MdpOublie extends Default{
    @FXML private TextField code;
    @FXML private Button connexion;
    @FXML private Button navElement1;
    @FXML private Button navElement2;
    @FXML private Button navElement3;
    @FXML private ChoiceBox<?> roles;
    @FXML private Button valid;
    private String email;
    private String codeRef;
    private UtilisateurRepository utilisateurRepository;

    public MdpOublie(String email) {
        super((Utilisateur) null);
        this.email = email;
        this.utilisateurRepository = new UtilisateurRepository();
    }
    public void initialize() {
        super.initialize();
        if (utilisateurRepository.emailExist(this.email)) {
            this.codeRef = Security.getRandomString(48, 122, 8);
            try {
                Email.send(email, "Tentative de connexion StockA !!", ("Avez vous essayé de vous connecter ?\ncode: "+this.codeRef));
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML void valid(ActionEvent event) {
        if (this.codeRef.equals(this.code.getText())) {
            Main.changeScene("Profil", new Profil(this.utilisateurRepository.findByEmail(email), false), "modification de profil");
        }
    }

}
