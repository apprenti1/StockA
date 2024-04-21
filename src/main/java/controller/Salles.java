package controller;

import application.Main;
import entity.Salle;
import entity.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import repo.SalleRepository;
import repo.UtilisateurRepository;

public class Salles extends Default {

    @FXML private TextField nom;
    @FXML private Button modif;
    private Salle salleAModifier;


    public Salles(Utilisateur utilisateur, Salle saleAModifier) {
        super(utilisateur);
        this.salleAModifier = saleAModifier;
    }
    public Salles(Utilisateur utilisateur) {
        super(utilisateur);
    }

    public void initialize() {
        super.initialize();
        if (salleAModifier == null) {modif.setText("Ajouter");}
        else {nom.setText(salleAModifier.getLibelle());}
    }

    @FXML void modification(ActionEvent event) {
        SalleRepository salleRepository = new SalleRepository();
        if (salleAModifier == null) {
            salleRepository.upload(new Salle(nom.getText()));
        }
        else {
            salleAModifier.setLibelle(nom.getText());
            salleRepository.update(salleAModifier);
        }
        Main.changeScene("CRUD", new CRUD( Salle.class, super.getUtilisateur()), "CRUD | salle");
    }

}
