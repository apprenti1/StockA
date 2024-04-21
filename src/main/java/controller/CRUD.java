package controller;

import application.Main;
import entity.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import repo.SalleRepository;
import repo.UtilisateurRepository;
public class CRUD extends Default {

    @FXML private Button add;
    @FXML private Pane colorType;
    @FXML private Button connexion;
    @FXML private Text description;
    @FXML private Text descriptionType;
    @FXML private TextField recherche;
    @FXML private HBox searsh;
    @FXML private TableView table;
    @FXML private Label titre;
    @FXML private VBox right;
    private Class<?> type;

    public CRUD (Class<?> type, Utilisateur utilisateur) {
        super(utilisateur);
        this.type = type;
    }


    public void initialize() {
        super.initialize();
        System.out.println(this.type.getTypeName());
        switch (this.type.getTypeName()) {
            case "entity.Utilisateur" -> {
                UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
                ObservableList<Utilisateur> utilisateursData = FXCollections.observableArrayList();
                utilisateursData.addAll(utilisateurRepository.findAll());
                TableColumn<Utilisateur, String> colonneNom = new TableColumn<>("Nom");
                colonneNom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
                TableColumn<Utilisateur, String> colonnePrenom = new TableColumn<>("Prenom");
                colonnePrenom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenom()));
                TableColumn<Utilisateur, String> colonneRole = new TableColumn<>("Role");
                colonneRole.setCellValueFactory(cellData -> new SimpleStringProperty((cellData.getValue().getRoles() == 1) ? "Professeur" : (cellData.getValue().getRoles() == 2) ? "Secrétaire" : (cellData.getValue().getRoles() == 3) ? "Gestionnaire de stock" : "Admin"));
                TableColumn<Utilisateur, String> colonneEmail = new TableColumn<>("Email");
                colonneEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
                table.getColumns().addAll(colonneNom, colonnePrenom, colonneRole, colonneEmail);
                table.setItems(utilisateursData);
            }
            case "entity.Salle" -> {
                SalleRepository salleRepository = new SalleRepository();
                ObservableList<Salle> sallesData = FXCollections.observableArrayList();
                sallesData.addAll(salleRepository.findAll());
                TableColumn<Salle, String> colonneNom = new TableColumn<>("Nom");
                colonneNom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLibelle()));
                table.getColumns().addAll(colonneNom);
                table.setItems(sallesData);
            }
        }

    }

    @FXML void delete(ActionEvent event) {
        switch (this.type.getTypeName()) {
            case "entity.Utilisateur" -> {
                if (table.getSelectionModel().getSelectedItem() != null) {
                    UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
                    utilisateurRepository.delete((Utilisateur) table.getSelectionModel().getSelectedItem());
                    Main.changeScene("CRUD", new CRUD(Salles.class, super.getUtilisateur()), "CRUD | salles");
                }
            }
            case "entity.Salle" -> {
                if (table.getSelectionModel().getSelectedItem() != null) {
                    SalleRepository salleRepository = new SalleRepository();
                    salleRepository.delete((Salle) table.getSelectionModel().getSelectedItem());
                    Main.changeScene("CRUD", new CRUD(Salles.class, super.getUtilisateur()), "CRUD | salles");
                }
            }
        }
    }
    @FXML void switchAddTache(ActionEvent event) {
        switch (this.type.getTypeName()){
            case "entity.Utilisateur" -> {Main.changeScene("Profil", new Profil(super.getUtilisateur(), true), "Inscription");}
            case "entity.Salle" -> {Main.changeScene("Salles", (new Salles(super.getUtilisateur())), "Salle");}
    }}
    @FXML void viewTache(MouseEvent event) {

        if ((this.table.getSelectionModel().getSelectedItem()) != null) {
            if (event.getClickCount() == 1) {
                switch (this.type.getTypeName()) {
                    case "entity.Utilisateur" -> {
                        this.titre.setText(((Utilisateur) this.table.getSelectionModel().getSelectedItem()).getNom() + " | " + ((Utilisateur) this.table.getSelectionModel().getSelectedItem()).getPrenom());
                        this.description.setText(((Utilisateur) this.table.getSelectionModel().getSelectedItem()).getEmail());
                    }
                    case "entity.Salle" -> {this.titre.setText(((Salle) this.table.getSelectionModel().getSelectedItem()).getLibelle());}
                }
            } else {
                switch (this.type.getTypeName()) {
                    case "entity.Utilisateur" -> {Main.changeScene("Profil", new Profil(super.getUtilisateur(), ((Utilisateur) this.table.getSelectionModel().getSelectedItem())), "EditProfil");}
                    case "entity.Salle" -> {Main.changeScene("Salles", new Salles(super.getUtilisateur(), ((Salle) this.table.getSelectionModel().getSelectedItem())), "EditSalle");}
                }
            }
        }
    }
    @FXML void searsh(ActionEvent event) { }
}
