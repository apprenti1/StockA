package controller;

import application.Main;

import entity.CommandeFourniture;
import entity.Fournisseur;
import entity.Salle;
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


    private FournisseurRepository fournisseurRepository;
    private UtilisateurRepository utilisateurRepository;



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
        String libelleValue = libelle.getText();
        int quantiteValue = Integer.parseInt(quantite.getText());
        String raisonValue = raison.getText();

        // Créer une nouvelle instance de CommandeFourniture avec les valeurs récupérées
        CommandeFourniture nouvelleCommande = new CommandeFourniture(0, true, raisonValue, quantiteValue, getUtilisateur(), getFournisseur());

        // Utiliser le CommandeFournitureRepository pour enregistrer la nouvelle commande
        CommandeFournitureRepository commandeFournitureRepo = new CommandeFournitureRepository();
        int idNouvelleCommande = commandeFournitureRepo.upload(nouvelleCommande);

        // Afficher un message de confirmation
        System.out.println("Commande de fourniture enregistrée avec succès, ID : " + idNouvelleCommande);
        Main.changeScene("CRUD", new CRUD( CommandeFourniture.class, getUtilisateur()), "CRUD | commande fourniture");


    }

}
