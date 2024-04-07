package controller;

import application.Main;
import entity.CommandeFourniture;
import entity.Dossier;
import entity.Salle;
import entity.Utilisateur;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import repo.CommandeFournitureRepository;
import repo.DossierRepository;
import repo.SalleRepository;
import repo.UtilisateurRepository;

public class CRUD extends Default {

    @FXML private Button add;
    @FXML private Pane colorType;
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
            case "entity.Utilisateur":
                UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
                ObservableList<Utilisateur> utilisateursData = FXCollections.observableArrayList();
                utilisateursData.addAll(utilisateurRepository.findAll());
                System.out.println(utilisateurRepository.findAll().get(0).getEmail());

                TableColumn<Utilisateur, String> colonneNom = new TableColumn<>("Nom");
                colonneNom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
                TableColumn<Utilisateur, String> colonnePrenom = new TableColumn<>("Prenom");
                colonnePrenom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenom()));
                TableColumn<Utilisateur, String> colonneEmail = new TableColumn<>("Email");
                colonneEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
                TableColumn<Utilisateur, String> colonneRole = new TableColumn<>("Role");
                colonneEmail.setCellValueFactory(cellData -> new SimpleStringProperty((cellData.getValue().getRoles() == 1)?"Professeur":(cellData.getValue().getRoles() == 2)?"Secrétaire":(cellData.getValue().getRoles() == 3)?"Gestionnaire de stock":"Admin"));
                table.getColumns().addAll(colonneNom, colonnePrenom, colonneEmail);
                table.setItems(utilisateursData);
                break;
            case "entity.Salle":
                SalleRepository salleRepository = new SalleRepository();
                ObservableList<Salle> sallesData = FXCollections.observableArrayList();
                sallesData.addAll(salleRepository.findAll());

                TableColumn<Salle, String> colonneLibelle = new TableColumn<>("Nom");
                colonneLibelle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLibelle()));
                table.getColumns().addAll(colonneLibelle);
                table.setItems(sallesData);
                break;
            case "entity.CommandeFourniture":
                CommandeFournitureRepository commandeFournitureRepository = new CommandeFournitureRepository();
                ObservableList<CommandeFourniture> commandeFournituresData = FXCollections.observableArrayList();
                commandeFournituresData.addAll(commandeFournitureRepository.findAll());
                System.out.println(commandeFournitureRepository.findAll().get(0).getFournisseur().getLibelle());

                TableColumn<Salle, String> colonneFournisseurLibelle = new TableColumn<>("Nom");
                colonneFournisseurLibelle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLibelle()));
                table.getColumns().addAll(colonneFournisseurLibelle);
                table.setItems(commandeFournituresData);
                break;
        }

    }

    @FXML void delete(ActionEvent event) {
        Utilisateur utilisateurASupprimer = (Utilisateur) table.getSelectionModel().getSelectedItem();
        if (utilisateurASupprimer != null) {
            UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
            utilisateurRepository.delete(utilisateurASupprimer);

        }
        Main.changeScene("CRUD", new CRUD( this.type, super.getUtilisateur()), "CRUD | "+this.type.getName());
    }
    @FXML void searsh(ActionEvent event) { }
    @FXML void switchAddTache(ActionEvent event) {
        Main.changeScene("Profil", new Profil(super.getUtilisateur(), true),"Inscription");
    }
    @FXML void viewTache(MouseEvent event) {
        switch (this.type.getTypeName()){
            case "entity.Utilisateur" :
                if (event.getClickCount()==1) {
                    this.titre.setText( ((Utilisateur)this.table.getSelectionModel().getSelectedItem()).getNom()+" | "+((Utilisateur)this.table.getSelectionModel().getSelectedItem()).getPrenom());
                    this.description.setText(((Utilisateur)this.table.getSelectionModel().getSelectedItem()).getEmail());
                }
                else {
                    Main.changeScene("Profil",new Profil(super.getUtilisateur(),((Utilisateur)this.table.getSelectionModel().getSelectedItem())),  "EditProfil");

                }
                break;
        }
    }

}
