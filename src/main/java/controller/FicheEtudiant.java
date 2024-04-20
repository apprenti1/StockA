package controller;
import entity.Dossier;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import application.Main;
import repo.UtilisateurRepository;
import entity.Utilisateur;
import entity.Etudiant;
import repo.EtudiantRepository;

import java.sql.SQLException;

public class FicheEtudiant extends Default {

    public FicheEtudiant(Etudiant etudiant) throws SQLException {
        super(etudiant);
    }
    private EtudiantRepository etudiantRepository;
    private UtilisateurRepository utilisateurRepository;
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
        Main.changeScene("Accueil", new Accueil(null), "Bienvenue sur StockA !!!");

    }

    @FXML
    void Enregistrer(MouseEvent event) {

    }

    @FXML
    void switchAccueil(MouseEvent event) {
        Main.changeScene("Accueil", new Accueil(super.getUtilisateur()), "Bienvenue sur StockA !!!");

    }

}
