package controller;

import application.Main;
import controller.Default;
import entity.CommandeFourniture;
import entity.DemandeFourniture;
import entity.Fournisseur;
import entity.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Menu extends Default {
    @FXML private Button menu1;
    @FXML private Button menu2;
    private String menu;

    public Menu(Utilisateur utilisateur, String menu) {
        super(utilisateur);
        this.menu = menu;
    }
    public void initialize() {
        super.initialize();
        if (menu.equals("commandes")) {
            menu1.setText("gestion de fournisseurs");
            menu2.setText("gestion de commandes");
        }
        else if (menu.equals("demandes")) {
            menu1.setText("Mes demandes");
            menu2.setText("gestion de demandes");
        }
    }
    @FXML void menu1(ActionEvent event) {
        if (menu.equals("commandes")) {Main.changeScene("CRUD", new CRUD( Fournisseur.class, super.getUtilisateur()), "CRUD | fournisseurs");}
        else if (menu.equals("demandes")) {Main.changeScene("CRUD", new CRUD( DemandeFourniture.class, true, super.getUtilisateur()), "CRUD | mes demandes");}
    }
    @FXML void menu2(ActionEvent event) {
        if (menu.equals("commandes")) {Main.changeScene("CRUD", new CRUD( CommandeFourniture.class, super.getUtilisateur()), "CRUD | commandes");}
        else if (menu.equals("demandes")) {Main.changeScene("CRUD", new CRUD( DemandeFourniture.class, super.getUtilisateur()), "CRUD | demandes");}
    }
}
