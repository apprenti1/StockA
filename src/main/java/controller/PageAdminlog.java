package controller;
import entity.UtilisateurConnecte;
import application.Main;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;


import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PageAdminlog implements Initializable {

    private UtilisateurConnecte utilisateur;

    public PageAdminlog(){
        this.utilisateur=UtilisateurConnecte.getUniqueInstance();
    }

    @FXML
    private Button btnachat;

    @FXML
    private Button btndemande;

    @FXML
    private Button btndossierInscription;

    @FXML
    private Button btnficheEtudiant;

    @FXML
    private Button btnfourniture;

    @FXML
    private Button btngestionUtilisateurs;

    @FXML
    private Button btnrendezVous;

    @FXML
    void achat(ActionEvent event) {
        Main.changeScene("/application/ListeAchat",new ListeAchat());
    }

    @FXML
    void demande(ActionEvent event) {
        Main.changeScene("/application/ListeDemande",new ListeDemande());
    }

    @FXML
    void dossierInscription(ActionEvent event) throws SQLException {
        Main.changeScene("/application/ListeDossier",new ListeDossier());
    }
    @FXML
    void switchAccueil(MouseEvent event) {
        Main.changeScene("/application/Admin/PageAdminlog", new PageAdminlog());

    }

    @FXML
    void ficheEtudiant(ActionEvent event) {
        Main.changeScene("/application/ListeFicheetudiant", new ListeFicheetudiant());
    }

    @FXML
    void fourniture(ActionEvent event) {
        Main.changeScene("/application/ListeFourniture", new ListeFourniture());
    }

    @FXML
    void gestionUtilisateurs(ActionEvent event) {
        Main.changeScene("/application/ListeUtilisateur", new ListeUtilisateur());
    }

    @FXML
    void rendezVous(ActionEvent event) {
        Main.changeScene("/application/ListeRdv", new ListeRdv());
    }
    @FXML
    void Deconnexion(MouseEvent event) {

        UtilisateurConnecte.setUniqueInstance();
        Main.changeScene("/application/Accueil");
    }

    @FXML
    void MonProfil(MouseEvent event) {
        Main.changeScene("/application/MonProfil");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (this.utilisateur.getRole().equals("Admin")){
            btnachat.setVisible(true);
            btndemande.setVisible(true);
            btndossierInscription.setVisible(true);
            btnfourniture.setVisible(true);
            btnficheEtudiant.setVisible(true);
            btngestionUtilisateurs.setVisible(true);
            btnrendezVous.setVisible(true);
        } else if (this.utilisateur.getRole().equals("Secretaire")) {
            btnficheEtudiant.setVisible(true);
            btndossierInscription.setVisible(true);
            btndemande.setVisible(true);
            btnfourniture.setVisible(false);
            btnachat.setVisible(false);
            btngestionUtilisateurs.setVisible(false);
            btnrendezVous.setVisible(false);
        } else if (this.utilisateur.getRole().equals("Professeur")) {
            btndossierInscription.setVisible(true);
            btnrendezVous.setVisible(true);
            btndemande.setVisible(true);
            btngestionUtilisateurs.setVisible(false);
            btnachat.setVisible(false);
            btnficheEtudiant.setVisible(false);
            btnfourniture.setVisible(false);
        }
        else if (this.utilisateur.getRole().equals("Gestionnaire")){
            btnachat.setVisible(true);
            btnfourniture.setVisible(true);
            btndemande.setVisible(true);
            btndossierInscription.setVisible(false);
            btnficheEtudiant.setVisible(false);
            btngestionUtilisateurs.setVisible(false);
            btnrendezVous.setVisible(false);
        }
        else {
            btnachat.setVisible(false);
            btndemande.setVisible(false);
            btndossierInscription.setVisible(false);
            btnfourniture.setVisible(false);
            btnficheEtudiant.setVisible(false);
            btngestionUtilisateurs.setVisible(false);
            btnrendezVous.setVisible(false);
        }
    }


}
