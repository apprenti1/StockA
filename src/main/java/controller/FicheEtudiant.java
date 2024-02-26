package controller;


import entity.Etudiant;
import entity.Utilisateur;
import application.Main;
import entity.UtilisateurConnecte;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
public class FicheEtudiant {

    private Utilisateur utilisateur;

    public FicheEtudiant() {this.utilisateur= UtilisateurConnecte.getUniqueInstance();}
    @FXML
    private MFXTextField cp;

    @FXML
    private MFXTextField diplome;

    @FXML
    private MFXTextField email;

    @FXML
    private MFXTextField nom;

    @FXML
    private MFXTextField prenom;

    @FXML
    private MFXTextField rue;

    @FXML
    private MFXTextField telephone;

    @FXML
    private MFXTextField ville;

    @FXML
    void Deconnexion(MouseEvent event) {
        UtilisateurConnecte.setUniqueInstance();
        Main.changeScene("/application/Accueil");
    }

    @FXML
    void Enregistrer(MouseEvent event)throws SQLException {
        Etudiant etu = new Etudiant(this.nom.getText(),this.prenom.getText(),this.email.getText(),this.diplome.getText(),this.telephone.getText(),this.rue.getText(),Integer.parseInt(this.cp.getText()),this.ville.getText());
        etu.enregistrer();
      Main.changeScene("/application/ListeFicheetudiant", new ListeFicheetudiant());
    }


    @FXML
    void switchAccueil(MouseEvent event) {
        Main.changeScene("/application/Admin/PageAdminlog",new PageAdminlog());
    }

    }

