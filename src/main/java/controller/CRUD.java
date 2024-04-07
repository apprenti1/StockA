package controller;

import application.Main;
import entity.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
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
import repo.CommandeFournitureRepository;
import repo.DossierRepository;
import repo.SalleRepository;
import repo.UtilisateurRepository;
import repo.RDVRepository;
import repo.FournisseurRepository;
import repo.FournitureRepository;
import repo.EtudiantRepository;
import repo.DemandeFournitureRepository;

import java.text.SimpleDateFormat;
import java.time.LocalTime;


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
            case "entity.Dossier":
                DossierRepository dossierRepository = new DossierRepository();
                ObservableList<Dossier> dossiersData = FXCollections.observableArrayList();
                dossiersData.addAll(dossierRepository.findAll());
                System.out.println(dossierRepository.findAll().get(0).getDate());

                TableColumn<Dossier, String> colonneDate = new TableColumn<>("Date");
                colonneDate.setCellValueFactory(cellData -> new SimpleStringProperty(new SimpleDateFormat("yyyy-MM-dd").format(cellData.getValue().getDate())));
                TableColumn<Dossier, String> colonneFiliere = new TableColumn<>("Filiere");
                colonneFiliere.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFiliere()));
                TableColumn<Dossier, String> colonneMotivation = new TableColumn<>("Motivation");
                colonneMotivation.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMotivation()));
                TableColumn<Dossier, String> colonneUtilisateur = new TableColumn<>("Utilisateur");
                colonneUtilisateur.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUtilisateur().getNom()));
                TableColumn<Dossier, String> colonneEtudiant = new TableColumn<>("Etudiant");
                colonneEtudiant.setCellValueFactory(cellData ->  {
                    Etudiant etudiant = cellData.getValue().getEtudiant();
                    if (etudiant != null) {
                        return new SimpleStringProperty(etudiant.getNom());
                    } else {
                        return new SimpleStringProperty("");
                    }
                });
                table.getColumns().addAll(colonneDate, colonneFiliere, colonneMotivation, colonneUtilisateur, colonneEtudiant);
                table.setItems(dossiersData);
                break;
            case "entity.RDV":
                RDVRepository rdvRepository = new RDVRepository();
                ObservableList<RDV> rdvsData = FXCollections.observableArrayList();
                rdvsData.addAll(rdvRepository.findAll());
                System.out.println(rdvRepository.findAll().get(0).getDate());

                TableColumn<RDV, String> colonneDates = new TableColumn<>("Date");
                colonneDates.setCellValueFactory(cellData -> new SimpleStringProperty(new SimpleDateFormat("yyyy-MM-dd").format(cellData.getValue().getDate())));
                TableColumn<RDV, String> colonneUtilisateures = new TableColumn<>("Utilisateures");
                colonneUtilisateures.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUtilisateur().toString()));
                TableColumn<RDV, LocalTime> colonneHeure = new TableColumn<>("Heure");
                colonneHeure.setCellValueFactory(cellData -> {
                    LocalTime heure = cellData.getValue().getHeure();
                    return new SimpleObjectProperty<>(LocalTime.of(3, 0));
                });
                colonneHeure.setCellFactory(column -> new TableCell<RDV, LocalTime>() {
                    @Override
                    protected void updateItem(LocalTime time, boolean empty) {
                        super.updateItem(time, empty);
                        if (empty || time == null) {
                            setText(null);
                        } else {
                            setText(time.toString());
                        }
                    }
                });

                TableColumn<RDV, String> colonneSalle = new TableColumn<>("Salle");
                colonneSalle.setCellValueFactory(cellData -> {
                    Salle salle = cellData.getValue().getSalle();
                    String salleString = salle != null ? salle.toString() : "";
                    return new SimpleStringProperty(salleString);
                });
                TableColumn<RDV, String> colonneDossier = new TableColumn<>("Dossier");
                colonneDossier.setCellValueFactory(cellData -> {
                    Dossier dossier = cellData.getValue().getDossier();
                    String dossierString = dossier != null ? dossier.toString() : "";
                    return new SimpleStringProperty(dossierString);
                });


                table.getColumns().addAll(colonneDates, colonneHeure, colonneUtilisateures, colonneSalle, colonneDossier);
                table.setItems(rdvsData);
                break;

            case "entity.Salle":
                SalleRepository salleRepository = new SalleRepository();
                ObservableList<Salle> sallesData = FXCollections.observableArrayList();
                sallesData.addAll(salleRepository.findAll());
                System.out.println(salleRepository.findAll().get(0).getLibelle());

                TableColumn<Salle, String> colonneLibelle = new TableColumn<>("Libelle");
                colonneLibelle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLibelle()));
                table.getColumns().addAll(colonneLibelle);
                table.setItems(sallesData);
                break;
            case "entity.CommandeFourniture":
                CommandeFournitureRepository commandeFournitureRepository = new CommandeFournitureRepository();
                ObservableList<CommandeFourniture> commandeFournituresData = FXCollections.observableArrayList();
                commandeFournituresData.addAll(commandeFournitureRepository.findAll());
                System.out.println(commandeFournitureRepository.findAll().get(0).getFournisseur().getLibelle());

                TableColumn<CommandeFourniture, Boolean> colonneValid = new TableColumn<>("Valid");
                colonneValid.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isValid()));
                TableColumn<CommandeFourniture, String> colonneRaison = new TableColumn<>("Raison");
                colonneRaison.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRaison()));
                TableColumn<CommandeFourniture, Integer> colonneEtat = new TableColumn<>("Etat");
                colonneEtat.setCellValueFactory(cellData -> {
                    int etat = cellData.getValue().getEtat();
                    return Bindings.createObjectBinding(() -> etat);
                });

                TableColumn<CommandeFourniture, String> colonneUtilisateurs = new TableColumn<>("Utilisateurs");
                colonneUtilisateurs.setCellValueFactory(cellData -> {
                    Utilisateur utilisateur = cellData.getValue().getUtilisateur();
                    String utilisateurString = utilisateur != null ? utilisateur.toString() : "";
                    return new SimpleStringProperty(utilisateurString);
                });

                TableColumn<CommandeFourniture, String> colonneFournisseur = new TableColumn<>("Fournisseur");
                colonneFournisseur.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFournisseur().toString()));
                table.getColumns().addAll(colonneValid, colonneRaison, colonneEtat, colonneUtilisateurs, colonneFournisseur);
                table.setItems(commandeFournituresData);
                break;

        }

    }

    @FXML void delete(ActionEvent event) {
        switch (this.type.getTypeName()) {
            case "entity.Utilisateur":
        Utilisateur utilisateurASupprimer = (Utilisateur) table.getSelectionModel().getSelectedItem();

        // Vérifier si un utilisateur est sélectionné
        if (utilisateurASupprimer != null) {
            // Appeler la méthode delete de UtilisateurRepository pour supprimer l'utilisateur
            UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
            utilisateurRepository.delete(utilisateurASupprimer);

            // Rafraîchir la liste des utilisateurs dans le TableView après la suppression
            refreshUserList();
        }
        break;
            case "entity.Salle":
                Salle salleASupprimer = (Salle) table.getSelectionModel().getSelectedItem();

                // Vérifier si une salle est sélectionnée
                if (salleASupprimer != null) {
                    // Appeler la méthode delete de SalleRepository pour supprimer la salle
                   SalleRepository salleRepository = new SalleRepository();
                    salleRepository.delete(salleASupprimer);

                    // Rafraîchir la liste des salles TableView après la suppression

                }
                break;

                case "entity.Dossier":
                Dossier dossierASupprimer = (Dossier) table.getSelectionModel().getSelectedItem();

                // Vérifier si un utilisateur est sélectionné
                if (dossierASupprimer != null) {
                    // Appeler la méthode delete de UtilisateurRepository pour supprimer l'utilisateur
                   DossierRepository dossierRepository = new DossierRepository();
                    dossierRepository.delete(dossierASupprimer);

                    // Rafraîchir la liste des utilisateurs dans le TableView après la suppression
                    refreshUserList();
                }
                break;
                case "entity.CommandeFourniture":
                CommandeFourniture commandeFournitureASupprimer = (CommandeFourniture) table.getSelectionModel().getSelectedItem();

                // Vérifier si un utilisateur est sélectionné
                if (commandeFournitureASupprimer != null) {
                    // Appeler la méthode delete de UtilisateurRepository pour supprimer l'utilisateur
                   CommandeFournitureRepository commandeFournitureRepository = new CommandeFournitureRepository();
                    commandeFournitureRepository.delete(commandeFournitureASupprimer);

                    // Rafraîchir la liste des utilisateurs dans le TableView après la suppression
                    refreshUserList();
                }
                break;
                case "entity.Fournisseur":
                Fournisseur fournisseurASupprimer = (Fournisseur) table.getSelectionModel().getSelectedItem();

                // Vérifier si un utilisateur est sélectionné
                if (fournisseurASupprimer != null) {
                    // Appeler la méthode delete de UtilisateurRepository pour supprimer l'utilisateur
                   FournisseurRepository fournisseurRepository = new FournisseurRepository();
                    fournisseurRepository.delete(fournisseurASupprimer);

                    // Rafraîchir la liste des utilisateurs dans le TableView après la suppression
                    refreshUserList();
                }
                break;
                case "entity.Fourniture":
                Fourniture fournitureASupprimer = (Fourniture) table.getSelectionModel().getSelectedItem();

                // Vérifier si un utilisateur est sélectionné
                if (fournitureASupprimer != null) {
                    // Appeler la méthode delete de UtilisateurRepository pour supprimer l'utilisateur
                   FournitureRepository fournitureRepository = new FournitureRepository();
                    fournitureRepository.delete(fournitureASupprimer);

                    // Rafraîchir la liste des utilisateurs dans le TableView après la suppression
                    refreshUserList();
                }
                break;
                case "entity.Etudiant":
                Etudiant etudiantASupprimer = (Etudiant) table.getSelectionModel().getSelectedItem();

                // Vérifier si un utilisateur est sélectionné
                if (etudiantASupprimer != null) {
                    // Appeler la méthode delete de UtilisateurRepository pour supprimer l'utilisateur
                   EtudiantRepository etudiantRepository = new EtudiantRepository();
                    etudiantRepository.delete(etudiantASupprimer);

                    // Rafraîchir la liste des utilisateurs dans le TableView après la suppression
                    refreshUserList();
                }
                break;
                case "entity.DemandeFourniture":
                    DemandeFourniture demandeFournitureASupprimer = (DemandeFourniture) table.getSelectionModel().getSelectedItem();

                // Vérifier si un utilisateur est sélectionné
                if (demandeFournitureASupprimer != null) {
                    // Appeler la méthode delete de UtilisateurRepository pour supprimer l'utilisateur
                    DemandeFournitureRepository demandeFournitureRepository = new DemandeFournitureRepository();
                    demandeFournitureRepository.delete(demandeFournitureASupprimer);

                    // Rafraîchir la liste des utilisateurs dans le TableView après la suppression
                    refreshUserList();
                }
                break;
                case "entity.RDV":
                   RDV rdvASupprimer = (RDV) table.getSelectionModel().getSelectedItem();

                // Vérifier si un utilisateur est sélectionné
                if (rdvASupprimer != null) {
                    // Appeler la méthode delete de UtilisateurRepository pour supprimer l'utilisateur
                    RDVRepository rdvRepository = new RDVRepository();
                    rdvRepository.delete(rdvASupprimer);

                    // Rafraîchir la liste des utilisateurs dans le TableView après la suppression
                    refreshUserList();
                }
                break;


    }
    }
    @FXML void edit(ActionEvent event) {

            // Créer une nouvelle instance d'Utilisateur avec des valeurs par défaut ou vides
            Utilisateur nouvelUtilisateur = new Utilisateur(0, "", "", "", "", 0);

            // Modifier les valeurs de l'utilisateur si nécessaire
            nouvelUtilisateur.setNom("Nouveau Nom");
            nouvelUtilisateur.setPrenom("Nouveau Prénom");
            nouvelUtilisateur.setEmail("nouveau@example.com");
            nouvelUtilisateur.setMdp("nouveauMotDePasse");
            nouvelUtilisateur.setRoles(1); // Assurez-vous de définir le rôle correctement

            // Instanciez UtilisateurRepository et appelez la méthode upload pour ajouter le nouvel utilisateur
            UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
            utilisateurRepository.upload(nouvelUtilisateur);

            // Rafraîchissez la liste des utilisateurs dans le TableView après l'ajout
            refreshUserList();
        }

    @FXML void searsh(ActionEvent event) { }
    private void refreshUserList() {
        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        ObservableList<Utilisateur> utilisateursData = FXCollections.observableArrayList();
        utilisateursData.addAll(utilisateurRepository.findAll());
        table.setItems(utilisateursData);
    }

    @FXML void switchAddTache(ActionEvent event) {
        switch (this.type.getTypeName()){
            case "entity.Utilisateur" :
        Main.changeScene("Inscription", new Inscription(getUtilisateur(), true),"Inscription");
        break;
            case "entity.Salle" :
                Main.changeScene("Salle", new Salles(),"Salle" );
                break;
    }}
    @FXML void switchConnexion(ActionEvent event) { }
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
