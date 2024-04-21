package controller;

import application.Main;
import entity.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import repo.UtilisateurRepository;

public class Profil extends Default {

    @FXML private PasswordField conf;
    @FXML private TextField email;
    @FXML private Text erreur;
    @FXML private PasswordField mdp;
    @FXML private TextField nom;
    @FXML private TextField prenom;
    @FXML private Label roleLabel;
    @FXML private Label lconf;
    @FXML private Label lmdp;
    @FXML private Button modif;
    @FXML private ChoiceBox<String> roles;
    private boolean isRegistration;
    private boolean isAdminModif;
    private Utilisateur utilisateurAModifier;



    /*
    * 3 cas possible
    * modification de compte utilisateur par l'utilisateur    --> isRegistration == false && isAdminModif == false
    * modification de compte utilisateur par l'administrateur --> isRegistration == false && isAdminModif == true
    * création     de compte utilisateur par l'administrateur --> isRegistration == true  && isAdminModif == false
    * */
    public Profil(Utilisateur utilisateur, boolean isRegistration) {
        super(utilisateur);
        this.isRegistration = isRegistration;
        if (this.utilisateurAModifier == null){
            this.utilisateurAModifier = utilisateur;
        }
    }
    public Profil(Utilisateur utilisateur, Utilisateur utilisateurAModifier) {
        this(utilisateur, false);
        this.isAdminModif = true;
        this.utilisateurAModifier = utilisateurAModifier;
    }

    public void initialize() {
        super.initialize();
        if (isAdminModif || isRegistration) {
            conf.setVisible(false);
            lconf.setVisible(false);
            mdp.setVisible(false);
            lmdp.setVisible(false);
            roles.setVisible(true);
            roles.getItems().addAll("Professeur", "Secrétaire", "Gestionnaire de stock", "Admin");

            roles.setValue((
                    this.utilisateurAModifier.getRoles() == 4 ? "Admin" :
                    this.utilisateurAModifier.getRoles() == 3 ? "Gestionnaire de stock" :
                    this.utilisateurAModifier.getRoles() == 2 ? "Secrétaire" : "professeur"));
        }
        if (!isRegistration) {
            nom.setText(this.utilisateurAModifier.getNom());
            prenom.setText(this.utilisateurAModifier.getPrenom());
            email.setText(this.utilisateurAModifier.getEmail());
        }
        else {
            modif.setText("Inscrire");
        }
    }

    @FXML void modification(ActionEvent event) {
        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        if (isAdminModif) {
            utilisateurAModifier.setEmail(email.getText());
            utilisateurAModifier.setNom(nom.getText());
            utilisateurAModifier.setPrenom(prenom.getText());
            utilisateurAModifier.setRoles((
                    this.roles.getValue().equals("Admin")?4:
                            this.roles.getValue().equals("Gestionnaire de stock")?3:
                                    this.roles.getValue().equals("Secrétaire")?2:1
            ));
            utilisateurRepository.update(utilisateurAModifier);
            Main.changeScene("CRUD", new CRUD( Utilisateur.class, super.getUtilisateur()), "CRUD | Utilisateur");
        }
        else if (isRegistration) {
            utilisateurRepository.upload(new Utilisateur(0, this.nom.getText(), this.prenom.getText(), this.email.getText(), "", (
                    this.roles.getValue().equals("Admin")?4:
                    this.roles.getValue().equals("Gestionnaire de stock")?3:
                    this.roles.getValue().equals("Secrétaire")?2:1
            )));
            Main.changeScene("CRUD", new CRUD( Utilisateur.class, super.getUtilisateur()), "CRUD | Utilisateur");
        }
        else {
            if (!(mdp.getText().isBlank() || mdp.getText().isEmpty())) {
                if (mdp.getText().equals(conf.getText())) {
                    super.getUtilisateur().setNom(nom.getText());
                    super.getUtilisateur().setPrenom(prenom.getText());
                    super.getUtilisateur().setEmail(email.getText());
                    super.getUtilisateur().setMdp(mdp.getText());
                    utilisateurRepository.update(super.getUtilisateur());
                    Main.changeScene("Accueil", new Accueil(utilisateurAModifier), "Accueil");
                }
                else {
                    erreur.setText("Erreur: le mot de passe et la confirmation ne sont pas identiques !!");
                }
            }
            else {
                erreur.setText("Erreur: vous n'avez pas défini de mot de passe !!");
            }
        }
    }


    @FXML void roleSelected(ActionEvent event) {
    }

}
