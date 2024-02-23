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
        Main.changeScene("ListeAchat",new ListeAchat(),"Liste achat");
    }

    @FXML
    void demande(ActionEvent event) {
        Main.changeScene("ListeDemande",new ListeDemande(),"Liste demande");
    }

    @FXML
    void dossierInscription(ActionEvent event) throws SQLException {
        Main.changeScene("ListeDossier",new ListeDossier(), "Liste dossier");
    }

    @FXML
    void ficheEtudiant(ActionEvent event) {
        Main.changeScene("ListeFicheetudiant", new ListeFicheetudiant(), "liste fiche etudiant");
    }

    @FXML
    void fourniture(ActionEvent event) {
        Main.changeScene("ListeFourniture", new ListeFourniture(), "Liste fourniture");
    }

    @FXML
    void gestionUtilisateurs(ActionEvent event) {
        Main.changeScene("ListeUtilisateur", new ListeUtilisateur(), "Liste utilisateur");
    }

    @FXML
    void rendezVous(ActionEvent event) {
        Main.changeScene("ListeRdv", new ListeRdv(), "Liste Rdv");
    }
    @FXML
    void Deconnexion(MouseEvent event) {

        UtilisateurConnecte.setUniqueInstance();
        Main.changeScene("Accueil",new  Accueil(),"Accueil");
    }

    @FXML
    void utilisateurShow(MouseEvent event) {
        Main.changeScene("MonProfil", new MonProfil(),"Mon profil");
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
