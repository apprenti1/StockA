package controller;

import application.Main;
import entity.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Default {

    @FXML private Button connexion;
    @FXML private Button navElement1;
    @FXML private Button navElement2;
    @FXML private Button navElement3;
    private Utilisateur utilisateur;
    private Salle salle;

    private RDV rdv;
    private Dossier dossier;
    private Fournisseur fournisseur;
    private Fourniture fourniture;
    private CommandeFourniture commandeFourniture;
    private DemandeFourniture demandeFourniture;
    private Etudiant etudiant;
    private LinkDemandeFournitureFourniture linkDemandeFournitureFourniture;
    private LinkFournitureCommandeFourniture linkFournitureCommandeFourniture;
    private LinkFournitureFournisseur linkFournitureFournisseur;



    public Default(Utilisateur utilisateur){
        this.utilisateur = utilisateur;
    }
    public Default(Salle salle){this.salle = salle;}
    public Default(RDV rdv){this.rdv = rdv;}
    public Default(Fourniture fourniture){this.fourniture = fourniture;}
    public Default(CommandeFourniture commandeFourniture){this.commandeFourniture = commandeFourniture;}
    public Default(DemandeFourniture demandeFourniture){this.demandeFourniture = demandeFourniture;}
    public Default(Dossier dossier){this.dossier = dossier;}
    public Default(Fournisseur fournisseur){this.fournisseur = fournisseur;}
    public Default(Etudiant etudiant){this.etudiant = etudiant;}
    public Default(LinkDemandeFournitureFourniture linkDemandeFournitureFourniture){this.linkDemandeFournitureFourniture = linkDemandeFournitureFourniture;}
    public Default(LinkFournitureCommandeFourniture linkFournitureCommandeFourniture){this.linkFournitureCommandeFourniture = linkFournitureCommandeFourniture;}
    public Default(LinkFournitureFournisseur linkFournitureFournisseur){this.linkFournitureFournisseur = linkFournitureFournisseur;}


    public void initialize() {
        System.out.println("|--------------------Chargement interface--------------------|");
        if (connexion != null) {
            if (utilisateur != null) {
                switch (utilisateur.getRoles()) {
                    case 1: // Professeur
                        navElement1.setText("Dossier");
                        navElement1.setVisible(true);
                        navElement2.setText("Rendez vous");
                        navElement2.setVisible(true);
                        navElement3.setText("commander");
                        navElement3.setVisible(true);
                        break;
                    case 2: // Secrétaire
                        navElement1.setText("Dossier");
                        navElement1.setVisible(true);
                        navElement2.setText("Etudiant");
                        navElement2.setVisible(true);
                        navElement3.setText("commander");
                        navElement3.setVisible(true);
                        break;
                    case 3: // Gestionnaire de stock
                        navElement1.setText("Achat");
                        navElement1.setVisible(true);
                        navElement2.setText("Fourniture");
                        navElement2.setVisible(true);
                        navElement3.setText("commander");
                        navElement3.setVisible(true);
                        break;
                    case 4: // Admin
                        navElement2.setText("Gestion utilisateur");
                        navElement2.setVisible(true);
                        navElement3.setText("Gestion Salle");
                        navElement3.setVisible(true);
                        break;
                }
                connexion.setText("Profil");
       ;
            }
        }
    }
    @FXML void navElement1(ActionEvent event) {
        switch (utilisateur.getRoles()) {
            case 1: // Professeur
                Main.changeScene("CRUD", new CRUD( Dossier.class, utilisateur), "CRUD | dossiers");

                break;
            case 2: // Secrétaire
                Main.changeScene("CRUD", new CRUD( Dossier.class, utilisateur), "CRUD | dossiers");

                break;
            case 3: // Gestionnaire de stock
                Main.changeScene("CRUD", new CRUD( DemandeFourniture.class, utilisateur), "CRUD | Achat");

                break;
            case 4: // Admin

                break;
        }
    }
    @FXML void navElement2(ActionEvent event) {
        switch (utilisateur.getRoles()) {
            case 1: // Professeur
                Main.changeScene("CRUD", new CRUD( RDV.class, utilisateur), "CRUD | RDVs");

                break;
            case 2: // Secrétaire
                Main.changeScene("CRUD", new CRUD( Etudiant.class, utilisateur), "CRUD | etudiants");

                break;
            case 3: // Gestionnaire de stock
                Main.changeScene("CRUD", new CRUD( Fourniture.class, utilisateur), "CRUD | fourniture");

                break;
            case 4: // Admin
                Main.changeScene("CRUD", new CRUD( Utilisateur.class, utilisateur), "CRUD | Utilisateur");
                break;
        }
    }
    @FXML void navElement3(ActionEvent event) {
        switch (utilisateur.getRoles()) {
            case 1: // Professeur
                Main.changeScene("CRUD", new CRUD( CommandeFourniture.class, utilisateur), "CRUD | commander");

                break;
            case 2: // Secrétaire
                Main.changeScene("CRUD", new CRUD( CommandeFourniture.class, utilisateur), "CRUD | commander");

                break;
            case 3: // Gestionnaire de stock
                Main.changeScene("CRUD", new CRUD( CommandeFourniture.class, utilisateur), "CRUD | commander");

                break;
            case 4: // Admin
                Main.changeScene("CRUD", new CRUD( Salle.class, utilisateur), "CRUD | salles");

                break;
        }
    }

    @FXML void switchAccueil(MouseEvent event) {
        Main.changeScene("Accueil", new Accueil(utilisateur), "Accueil");
    }
    @FXML void switchConnexion(ActionEvent event) {
        if (this.getUtilisateur() == null){
            Main.changeScene("Connexion", new Connexion(), "Connexion");
        }
        else {
            Main.changeScene("Profil", new Profil(this.getUtilisateur(), false), ("Profil | " + this.getUtilisateur().getPrenom()));
        }
    }
public Salle getSalle() {return salle;}
    public void setSalle (Salle salle) {this.salle = salle;}
public Dossier getDossier() {return dossier;}
    public void setDossier (Dossier dossier) {this.dossier = dossier;}
    public Fourniture getFourniture() {return fourniture;}
    public void setFourniture (Fourniture fourniture) {this.fourniture = fourniture;}
    public CommandeFourniture getCommandeFourniture() {return commandeFourniture;}
    public void setCommandeFourniture (CommandeFourniture commandeFourniture) {this.commandeFourniture = commandeFourniture;}
    public DemandeFourniture getDemandeFourniture() {return demandeFourniture;}
    public void setDemandeFourniture (DemandeFourniture demandeFourniture) {this.demandeFourniture = demandeFourniture;}
     public Fournisseur getFournisseur() {return fournisseur;}
    public void setFournisseur (Fournisseur fournisseur) {this.fournisseur = fournisseur;}

    public RDV getRdv() {return rdv;}
    public void setRdv (RDV rdv) {this.rdv = rdv;}
    public Utilisateur getUtilisateur() {return utilisateur;}
    public void setUtilisateur(Utilisateur utilisateur) {this.utilisateur = utilisateur;}
    public Etudiant getEtudiant() {return etudiant;}
    public void setEtudiant(Etudiant etudiant) {this.etudiant = etudiant;}
    public LinkDemandeFournitureFourniture getLinkDemandeFournitureFourniture() {return linkDemandeFournitureFourniture;}
    public void setLinkDemandeFournitureFourniture(LinkDemandeFournitureFourniture linkDemandeFournitureFourniture) {this.linkDemandeFournitureFourniture = linkDemandeFournitureFourniture;}
    public LinkFournitureCommandeFourniture getLinkFournitureCommandeFourniture() {return linkFournitureCommandeFourniture;}
    public void setLinkFournitureCommandeFourniture(LinkFournitureCommandeFourniture linkFournitureCommandeFourniture) {this.linkFournitureCommandeFourniture = linkFournitureCommandeFourniture;}
    public LinkFournitureFournisseur getLinkFournitureFournisseur() {return linkFournitureFournisseur;}
    public void setLinkFournitureFournisseur(LinkFournitureFournisseur linkFournitureFournisseur) {this.linkFournitureFournisseur = linkFournitureFournisseur;}

}
