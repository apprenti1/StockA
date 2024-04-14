package controller;

import application.Main;

import entity.CommandeFourniture;
import entity.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import repo.*;

import java.sql.SQLException;

public class CommandeFournitures extends Default {
    private CommandeFournitureRepository commandeFournitureRepository;
    public CommandeFournitures(CommandeFourniture commandeFourniture) throws SQLException {
        super(commandeFourniture);
    }


    private DemandeFournitureRepository demandeFournitureRepository;
    private UtilisateurRepository utilisateurRepository;
    private LinkDemandeFournitureFournitureRepository linkDemandeFournitureFournitureRepository;



    private Utilisateur utilisateur;
    @FXML
    private Text erreur;

    @FXML
    private TextField libelle;

    @FXML
    private TextField quantite;

    @FXML
    private TextField raison;

    @FXML
    void Deconnexion(MouseEvent event) {
        Main.changeScene("Accueil", new Accueil(null), "Bienvenue sur StockA !!!");

    }

    @FXML
    void switchAccueil(MouseEvent event) {
        Main.changeScene("Accueil", new Accueil(super.getUtilisateur()), "Bienvenue sur StockA !!!");

    }

    @FXML
    void valider(MouseEvent event) {

    }

}
