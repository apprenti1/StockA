package controller;

import entity.Etudiant;
import entity.Salle;
import entity.Utilisateur;
import entity.Dossier;
import repo.DossierRepository;
import repo.SalleRepository;
import repo.UtilisateurRepository;
import repo.EtudiantRepository;
import io.github.palexdev.materialfx.controls.MFXFilterComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import application.Main;


public class Dossiers extends Default {


        public Dossiers(Dossier dossier) throws SQLException {
                super(dossier);
        }


        private EtudiantRepository etudiantRepository;
        private UtilisateurRepository utilisateurRepository;
        private DossierRepository dossierRepository;

        private Utilisateur utilisateur;
        private Etudiant fiche = new Etudiant();
        private ResultSet choix = fiche.select();
        @FXML
        private MFXTextField Date;

        @FXML
        private MFXFilterComboBox<ResultSet> Fiche;

        @FXML
        private MFXTextField Filiere;

        @FXML
        private MFXTextField Heure;

        @FXML
        private MFXTextField Motivation;

        @FXML
        void Deconnexion(MouseEvent event) {

                Main.changeScene("Accueil", new Accueil(null), "Bienvenue sur StockA !!!");

        }

        @FXML
        void Enregistrer(MouseEvent event) {
                // Enregistrer le nouveau dossier dans le DossierRepository
                DossierRepository dossierRepository = new DossierRepository();
                int idDossier =  dossierRepository.upload(new Dossier());
                System.out.println("Dossier enregistré avec succès, ID : " + idDossier);

                Main.changeScene("CRUD", new CRUD( Dossier.class, getUtilisateur()), "CRUD | dossiers");

        }

        @FXML
        void Retour(MouseEvent event){Main.changeScene("Accueil", new Accueil(super.getUtilisateur()), "Bienvenue sur StockA !!!");


}

}
