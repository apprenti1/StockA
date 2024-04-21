package controller;

import application.Main;
import entity.Fourniture;
import entity.Salle;
import entity.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import repo.FournitureRepository;
import repo.SalleRepository;

public class Fournitures extends Default {

    @FXML private TextField nom;
    @FXML private TextField description;
    @FXML private Button modif;
    private Fourniture fournitureAModifier;


    public Fournitures(Utilisateur utilisateur, Fourniture fournitureAModifier) {
        super(utilisateur);
        this.fournitureAModifier = fournitureAModifier;
    }
    public Fournitures(Utilisateur utilisateur) {
        super(utilisateur);
    }

    public void initialize() {
        super.initialize();
        if (fournitureAModifier == null) {modif.setText("Ajouter");}
        else {
            nom.setText(fournitureAModifier.getLibelle());
            description.setText(fournitureAModifier.getDescription());
        }
    }

    @FXML void modification(ActionEvent event) {
        FournitureRepository fournitureRepository = new FournitureRepository();
        if (fournitureAModifier == null) {
            fournitureRepository.upload(new Fourniture(0, nom.getText(), description.getText(), 0));
        }
        else {
            fournitureAModifier.setLibelle(nom.getText());
            fournitureAModifier.setDescription(description.getText());
            fournitureRepository.update(fournitureAModifier);
        }
        Main.changeScene("CRUD", new CRUD( Fourniture.class, super.getUtilisateur()), "CRUD | fourniture");
    }

}
