package controller;

import application.Main;
import entity.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import repo.UtilisateurRepository;

public class EditProfil extends Default {

    @FXML
    private PasswordField conf;

    @FXML
    private Button editProfil;

    @FXML
    private TextField email;

    @FXML
    private Text erreur;

    @FXML
    private PasswordField mdp;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private ComboBox<String> role;

    @FXML
    private Label roleLabel;
    private Utilisateur profil;
    private boolean verifCreate;

    public EditProfil(Utilisateur utilisateur, Utilisateur profil, boolean verifCreate) {
        super(utilisateur);
        this.profil = profil;
    }
    public void initialize() {
        super.initialize();
        nom.setText(super.getUtilisateur().getNom());
        prenom.setText(super.getUtilisateur().getPrenom());
        email.setText(super.getUtilisateur().getEmail());
        if( verifCreate == false && profil == null){
            role.setVisible(false);
            mdp.setVisible(true);
            conf.setVisible(true);

        }
        else {
            role.setVisible(true);
            mdp.setVisible(false);
            conf.setVisible(false);
            role.getItems().addAll("Professeur","Secrétaire","Gestionnaire de tâches");
        }
    }

    @FXML
    void modification(ActionEvent event) {
        if (!(mdp.getText().isBlank() || mdp.getText().isEmpty())) {
            if (mdp.getText().equals(conf.getText())) {
                super.getUtilisateur().setNom(nom.getText());
                super.getUtilisateur().setPrenom(prenom.getText());
                super.getUtilisateur().setEmail(email.getText());
                super.getUtilisateur().setMdp(mdp.getText());
                UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
                utilisateurRepository.update(super.getUtilisateur());
            }
            else {
                erreur.setText("Erreur: le mot de passe et la confirmation ne sont pas identiques !!");
            }
        }
        else {
            erreur.setText("Erreur: vous n'avez pas défini de mot de passe !!");
        }
    }

    @FXML
    void roleSelected(ActionEvent event) {

    }

    @FXML
    void switchConnexion(ActionEvent event) {
        Main.changeScene("Accueil", new Accueil(null), "Bienvenue sur StockA !!!");
    }

    @FXML void switchAccueil(MouseEvent event) {
        Main.changeScene("Accueil", new Accueil(super.getUtilisateur()), "Bienvenue sur StockA !!!");
    }

    @FXML
    void switchEditProfil(ActionEvent event) {

    }

    @FXML
    void switchMineListes(ActionEvent event) {

    }

    @FXML
    void switchMineTypes(ActionEvent event) {

    }

}
