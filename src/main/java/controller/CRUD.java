package controller;

import application.Main;
import entity.*;
import javafx.beans.property.SimpleIntegerProperty;
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
import repo.*;

import java.util.ArrayList;

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
    private boolean owned;

    public CRUD (Class<?> type, boolean owned, Utilisateur utilisateur) {
        super(utilisateur);
        this.type = type;
        this.owned = owned;
    }
    public CRUD (Class<?> type, Utilisateur utilisateur) {
        this(type, false, utilisateur);

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
            case "entity.Fourniture" -> {
                FournitureRepository fournitureRepository = new FournitureRepository();
                ObservableList<Fourniture> fournituresData = FXCollections.observableArrayList();
                fournituresData.addAll(fournitureRepository.findAll());
                TableColumn<Fourniture, Integer> colonneQte = new TableColumn<>("Qte");
                colonneQte.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getQteStock()).asObject());
                TableColumn<Fourniture, String> colonneLibelle = new TableColumn<>("Nom");
                colonneLibelle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLibelle()));
                TableColumn<Fourniture, String> colonneDescription = new TableColumn<>("description");
                colonneDescription.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescription()));
                table.getColumns().addAll(colonneQte, colonneLibelle, colonneDescription);
                table.setItems(fournituresData);
            }
            case "entity.Fournisseur" -> {
                /*
                * codé avec les pieds
                *      /!\
                * fonctionnel, doit etre rendu au + vite
                * */
                FournisseurRepository fournisseurRepository = new FournisseurRepository();
                LinkFournitureFournisseurRepository linkFournitureFournisseurRepository = new LinkFournitureFournisseurRepository();
                FournitureRepository fournitureRepository = new FournitureRepository();

                ArrayList<Fournisseur> fournisseurs = fournisseurRepository.findAll();
                for (Fournisseur fournisseur : fournisseurs ) {
                    ArrayList<Fourniture> fournitures = new ArrayList<Fourniture>();
                    for (LinkFournitureFournisseur link : linkFournitureFournisseurRepository.findBy("ref_fournisseur = "+fournisseur.getId())) {
                        fournitures.add(link.getFourniture());
                    }
                    fournisseur.setFournitures(fournitures);
                }
                ObservableList<Fournisseur> fournituresData = FXCollections.observableArrayList(fournisseurs);
                fournituresData.addAll();
                TableColumn<Fournisseur, String> colonneLibelle = new TableColumn<>("Nom");
                colonneLibelle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLibelle()));
                TableColumn<Fournisseur, String> colonneTel = new TableColumn<>("Tel");
                colonneTel.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTel()));
                TableColumn<Fournisseur, String> colonneEmail = new TableColumn<>("Email");
                colonneEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
                table.getColumns().addAll(colonneLibelle, colonneTel, colonneEmail);
                table.setItems(fournituresData);
            }
        }

    }

    @FXML void delete(ActionEvent event) {
        switch (this.type.getTypeName()) {
            case "entity.Utilisateur" -> {
                if (table.getSelectionModel().getSelectedItem() != null) {
                    UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
                    utilisateurRepository.delete((Utilisateur) table.getSelectionModel().getSelectedItem());
                    Main.changeScene("CRUD", new CRUD(Utilisateur.class, super.getUtilisateur()), "CRUD | utilisateur");
                }
            }
            case "entity.Salle" -> {
                if (table.getSelectionModel().getSelectedItem() != null) {
                    SalleRepository salleRepository = new SalleRepository();
                    salleRepository.delete((Salle) table.getSelectionModel().getSelectedItem());
                    Main.changeScene("CRUD", new CRUD(Salles.class, super.getUtilisateur()), "CRUD | salle");
                }
            }
            case "entity.Fourniture" -> {
                FournitureRepository fournitureRepository = new FournitureRepository();
                fournitureRepository.delete((Fourniture) table.getSelectionModel().getSelectedItem());
                Main.changeScene("CRUD", new CRUD(Fourniture.class, super.getUtilisateur()), "CRUD | fourniture");
            }
            case "entity.Fournisseur" -> {
                FournisseurRepository fournisseurRepository = new FournisseurRepository();
                fournisseurRepository.delete((Fournisseur) table.getSelectionModel().getSelectedItem());
                Main.changeScene("CRUD", new CRUD( Fournisseur.class, super.getUtilisateur()), "CRUD | fournisseurs");
            }
        }
    }
    @FXML void switchAddTache(ActionEvent event) {
        switch (this.type.getTypeName()){
            case "entity.Utilisateur" -> {Main.changeScene("Profil", new Profil(super.getUtilisateur(), true), "Inscription");}
            case "entity.Salle" -> {Main.changeScene("Salles", (new Salles(super.getUtilisateur())), "Salle");}
            case "entity.Fourniture" -> {Main.changeScene("Fourniture", (new Fournitures(super.getUtilisateur())), "Fourniture");}
            case "entity.Fournisseur" -> {Main.changeScene("Fournisseur", (new Fournisseurs(super.getUtilisateur())), "Fourniture");}
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
                    case "entity.Fourniture" -> {
                        this.titre.setText(((Fourniture) this.table.getSelectionModel().getSelectedItem()).getQteStock()+((Fourniture) this.table.getSelectionModel().getSelectedItem()).getLibelle());
                        this.description.setText(((Fourniture) this.table.getSelectionModel().getSelectedItem()).getDescription());
                    }
                }
            } else {
                switch (this.type.getTypeName()) {
                    case "entity.Utilisateur" -> {Main.changeScene("Profil", new Profil(super.getUtilisateur(), ((Utilisateur) this.table.getSelectionModel().getSelectedItem())), "EditProfil");}
                    case "entity.Salle" -> {Main.changeScene("Salles", new Salles(super.getUtilisateur(), ((Salle) this.table.getSelectionModel().getSelectedItem())), "EditSalle");}
                    case "entity.Fourniture" -> {Main.changeScene("Fourniture", new Fournitures(super.getUtilisateur(), ((Fourniture) this.table.getSelectionModel().getSelectedItem())), "EditFourniture");}
                }
            }
        }
    }
    @FXML void searsh(ActionEvent event) { }
}
