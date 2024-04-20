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
import repo.LinkDemandeFournitureFournitureRepository;
import repo.LinkFournitureCommandeFournitureRepository;
import repo.LinkFournitureFournisseurRepository;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.List;


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

                List<Salle> allSalles = salleRepository.findAll();
                if (!allSalles.isEmpty()) {
                    sallesData.addAll(allSalles);

                    TableColumn<Salle, String> colonneLibelle = new TableColumn<>("Libelle");
                    colonneLibelle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLibelle()));
                    table.getColumns().addAll(colonneLibelle);
                    table.setItems(sallesData);
                } else {
                    System.out.println("Aucune salle trouvée.");
                }
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
            case "entity.Etudiant":
                EtudiantRepository etudiantRepository = new EtudiantRepository();
                ObservableList<Etudiant> etudiantsData = FXCollections.observableArrayList();
                etudiantsData.addAll(etudiantRepository.findAll());
                System.out.println(etudiantRepository.findAll().get(0).getNom());

                TableColumn<Etudiant, String> colonnedernierDiplome = new TableColumn<>("dernierDiplome");
                colonnedernierDiplome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDernierDiplome()));;
                TableColumn<Etudiant, String> colonneTel = new TableColumn<>("Telephone");
                colonneTel.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTel()));
                TableColumn<Etudiant, String> colonneRue = new TableColumn<>("Rue");
                colonneRue.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRue()));
                TableColumn<Etudiant, String> colonneCp = new TableColumn<>("Cp");
                colonneCp.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCp()));
                TableColumn<Etudiant, String> colonneVille = new TableColumn<>("Ville");
                colonneVille.setCellValueFactory(cellData ->  new SimpleStringProperty(cellData.getValue().getVille()));
                TableColumn<Etudiant, String> colonneUtilisateure = new TableColumn<>("Utilisateur");
                colonneUtilisateure.setCellValueFactory(cellData -> {
                    Utilisateur utilisateur = cellData.getValue().getUtilisateur();
                    String utilisateurString = utilisateur != null ? utilisateur.toString() : "";
                    return new SimpleStringProperty(utilisateurString);
                });
                table.getColumns().addAll(colonnedernierDiplome, colonneTel, colonneRue, colonneCp, colonneVille, colonneUtilisateure);
                table.setItems(etudiantsData);
                break;

            case "entity.DemandeFourniture":
                DemandeFournitureRepository demandeFournitureRepository = new DemandeFournitureRepository();
                ObservableList<DemandeFourniture> demandeFournituresData = FXCollections.observableArrayList();
                demandeFournituresData.addAll(demandeFournitureRepository.findAll());
                System.out.println(demandeFournitureRepository.findAll().get(0).getId());

                TableColumn<DemandeFourniture, Boolean> colonneValide = new TableColumn<>("Valid");
                colonneValide.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isValid()));
                TableColumn<DemandeFourniture, String> colonneRaisons = new TableColumn<>("Raison");
                colonneRaisons.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRaison()));
                TableColumn<DemandeFourniture, Integer> colonneEtats = new TableColumn<>("Etat");
                colonneEtats.setCellValueFactory(cellData -> {
                    int etat = cellData.getValue().getEtat();
                    return Bindings.createObjectBinding(() -> etat);
                });

                TableColumn<DemandeFourniture, String> colonneUtilisateurss= new TableColumn<>("Utilisateurs");
                colonneUtilisateurss.setCellValueFactory(cellData -> {
                    Utilisateur utilisateur = cellData.getValue().getUtilisateur();
                    String utilisateurString = utilisateur != null ? utilisateur.toString() : "";
                    return new SimpleStringProperty(utilisateurString);
                });


                table.getColumns().addAll(colonneValide, colonneRaisons, colonneEtats, colonneUtilisateurss);
                table.setItems(demandeFournituresData);
                break;

            case "entity.Fournisseur":
                FournisseurRepository fournisseurRepository = new FournisseurRepository();
                ObservableList<Fournisseur> fournisseursData = FXCollections.observableArrayList();
                fournisseursData.addAll(fournisseurRepository.findAll());
                System.out.println(fournisseurRepository.findAll().get(0).getLibelle());

                TableColumn<Fournisseur, String> colonneLibelles = new TableColumn<>("Libelle");
                colonneLibelles.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLibelle()));;
                TableColumn<Fournisseur, String> colonneTelephone = new TableColumn<>("Telephone");
                colonneTelephone.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTel()));
                TableColumn<Fournisseur, String> colonneMail = new TableColumn<>("Email");
                colonneMail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));


                table.getColumns().addAll(colonneLibelles, colonneTelephone, colonneMail);
                table.setItems(fournisseursData);
                break;

            case "entity.Fourniture":
                FournitureRepository fournitureRepository = new FournitureRepository();
                ObservableList<Fourniture> fournituresData = FXCollections.observableArrayList();
                fournituresData.addAll(fournitureRepository.findAll());
                System.out.println(fournitureRepository.findAll().get(0).getLibelle());

                TableColumn<Fourniture, String> colonneDescriptions = new TableColumn<>("Description");
                colonneDescriptions.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescription()));;
                TableColumn<Fourniture, String> colonneLibelle = new TableColumn<>("Libelle");
                colonneLibelle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLibelle()));
                TableColumn<Fourniture, Integer> colonneQteStock = new TableColumn<>("Quantité de stock");
                colonneQteStock.setCellValueFactory(cellData ->
                {
                    int qteStock = cellData.getValue().getQteStock();
                    return Bindings.createObjectBinding(() -> qteStock);
                });

                table.getColumns().addAll(colonneLibelle, colonneDescriptions, colonneQteStock);
                table.setItems(fournituresData);
                break;
            case "entity.LinkDemandeFournitureFourniture":
                LinkDemandeFournitureFournitureRepository linkDemandeFournitureFournitureRepository = new LinkDemandeFournitureFournitureRepository();
                ObservableList<LinkDemandeFournitureFourniture> linkDemandeFournitureFournituresData = FXCollections.observableArrayList();
                linkDemandeFournitureFournituresData.addAll(linkDemandeFournitureFournitureRepository.findAll());
                System.out.println(linkDemandeFournitureFournitureRepository.findAll().get(0).getId());

                TableColumn<DemandeFourniture, Integer> colonneQuantite = new TableColumn<>("Quantite");
                colonneQuantite.setCellValueFactory(cellData -> {
                    int quantite = cellData.getValue().getEtat();
                    return Bindings.createObjectBinding(() -> quantite);
                });

                TableColumn<LinkDemandeFournitureFourniture, String> colonneDemandeFourniture= new TableColumn<>("Demande Fourniture");
                colonneDemandeFourniture.setCellValueFactory(cellData -> {
                    DemandeFourniture demandeFourniture = cellData.getValue().getDemandeFourniture();
                    String demandeFournitureString = demandeFourniture != null ? demandeFourniture.toString() : "";
                    return new SimpleStringProperty(demandeFournitureString);
                });
                TableColumn<LinkDemandeFournitureFourniture, String> colonneFourniture= new TableColumn<>(" Fourniture");
                colonneFourniture.setCellValueFactory(cellData -> {
                    Fourniture fourniture = cellData.getValue().getFourniture();
                    String fournitureString = fourniture != null ? fourniture.toString() : "";
                    return new SimpleStringProperty(fournitureString);
                });


                table.getColumns().addAll(colonneDemandeFourniture, colonneFourniture, colonneQuantite);
                table.setItems(linkDemandeFournitureFournituresData);
                break;

            case "entity.LinkFournitureCommandeFourniture":
                LinkFournitureCommandeFournitureRepository linkFournitureCommandeFournitureRepository = new LinkFournitureCommandeFournitureRepository();
                ObservableList<LinkFournitureCommandeFourniture> linkFournitureCommandeFournituresData = FXCollections.observableArrayList();
                linkFournitureCommandeFournituresData.addAll(linkFournitureCommandeFournitureRepository.findAll());
                System.out.println(linkFournitureCommandeFournitureRepository.findAll().get(0).getId());

                TableColumn<LinkFournitureCommandeFourniture, Integer> colonneQuantites = new TableColumn<>("Quantite");
                colonneQuantites.setCellValueFactory(cellData -> {
                    int quantite = cellData.getValue().getQuantite();
                    return Bindings.createObjectBinding(() -> quantite);
                });

                TableColumn<LinkFournitureCommandeFourniture, String> colonneFournitures= new TableColumn<>("Fourniture");
                colonneFournitures.setCellValueFactory(cellData -> {
                    Fourniture fourniture = cellData.getValue().getFourniture();
                    String fournitureString = fourniture != null ? fourniture.toString() : "";
                    return new SimpleStringProperty(fournitureString);
                });
                TableColumn<LinkFournitureCommandeFourniture, String> colonneCommandeFourniture= new TableColumn<>(" Commande Fourniture");
                colonneCommandeFourniture.setCellValueFactory(cellData -> {
                    CommandeFourniture commandeFourniture = cellData.getValue().getCommandeFourniture();
                    String commandeFournitureString = commandeFourniture != null ? commandeFourniture.toString() : "";
                    return new SimpleStringProperty(commandeFournitureString);
                });


                table.getColumns().addAll(colonneFournitures, colonneCommandeFourniture, colonneQuantites);
                table.setItems(linkFournitureCommandeFournituresData);
                break;

            case "entity.LinkFournitureFournisseur":
                LinkFournitureFournisseurRepository linkFournitureFournisseurRepository = new LinkFournitureFournisseurRepository();
                ObservableList<LinkFournitureFournisseur> linkFournitureFournisseursData = FXCollections.observableArrayList();
                linkFournitureFournisseursData.addAll(linkFournitureFournisseurRepository.findAll());
                System.out.println(linkFournitureFournisseurRepository.findAll().get(0).getId());

                TableColumn<LinkFournitureFournisseur, Double> colonnePrix = new TableColumn<>("Prix");
                colonnePrix.setCellValueFactory(cellData -> {
                    double prix = cellData.getValue().getPrix();
                    return Bindings.createObjectBinding(() -> prix);
                });

                TableColumn<LinkFournitureFournisseur, String> colonneFournituress= new TableColumn<>("Fourniture");
                colonneFournituress.setCellValueFactory(cellData -> {
                    Fourniture fourniture = cellData.getValue().getFourniture();
                    String fournitureString = fourniture != null ? fourniture.toString() : "";
                    return new SimpleStringProperty(fournitureString);
                });
                TableColumn<LinkFournitureFournisseur, String> colonneFournisseurs= new TableColumn<>(" Fournisseur");
                colonneFournisseurs.setCellValueFactory(cellData -> {
                    Fournisseur fournisseur = cellData.getValue().getFournisseur();
                    String fournisseurString = fournisseur != null ? fournisseur.toString() : "";
                    return new SimpleStringProperty(fournisseurString);
                });


                table.getColumns().addAll(colonneFournisseurs, colonneFournituress, colonnePrix);
                table.setItems(linkFournitureFournisseursData);
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
                    refreshSalleList();


                }
                break;

                case "entity.Dossier":
                Dossier dossierASupprimer = (Dossier) table.getSelectionModel().getSelectedItem();

                // Vérifier si un dossier est sélectionné
                if (dossierASupprimer != null) {
                    // Appeler la méthode delete de DossierRepository pour supprimer l'utilisateur
                   DossierRepository dossierRepository = new DossierRepository();
                    dossierRepository.delete(dossierASupprimer);
                    refreshDossierList();


                }
                break;
                case "entity.CommandeFourniture":
                CommandeFourniture commandeFournitureASupprimer = (CommandeFourniture) table.getSelectionModel().getSelectedItem();

                // Vérifier si un commandefourniture  est sélectionné
                if (commandeFournitureASupprimer != null) {
                    // Appeler la méthode delete de CommandeFournitureRepository pour supprimer l'utilisateur
                   CommandeFournitureRepository commandeFournitureRepository = new CommandeFournitureRepository();
                    commandeFournitureRepository.delete(commandeFournitureASupprimer);
                    refreshCommandeFournitureList();


                }
                break;
                case "entity.Fournisseur":
                Fournisseur fournisseurASupprimer = (Fournisseur) table.getSelectionModel().getSelectedItem();

                // Vérifier si un fournisseur est sélectionné
                if (fournisseurASupprimer != null) {
                    // Appeler la méthode delete de FournisseurRepository pour supprimer l'utilisateur
                   FournisseurRepository fournisseurRepository = new FournisseurRepository();
                    fournisseurRepository.delete(fournisseurASupprimer);

                    refreshFournisseurList();

                }
                break;
                case "entity.Fourniture":
                Fourniture fournitureASupprimer = (Fourniture) table.getSelectionModel().getSelectedItem();

                // Vérifier si un Fourniture est sélectionné
                if (fournitureASupprimer != null) {
                    // Appeler la méthode delete de FournitureRepository pour supprimer l'utilisateur
                   FournitureRepository fournitureRepository = new FournitureRepository();
                    fournitureRepository.delete(fournitureASupprimer);

                    refreshFournitureList();

                }
                break;
                case "entity.Etudiant":
                Etudiant etudiantASupprimer = (Etudiant) table.getSelectionModel().getSelectedItem();

                // Vérifier si un utilisateur est sélectionné
                if (etudiantASupprimer != null) {
                    // Appeler la méthode delete de UtilisateurRepository pour supprimer l'utilisateur
                   EtudiantRepository etudiantRepository = new EtudiantRepository();
                    etudiantRepository.delete(etudiantASupprimer);
                    refreshEtudiantList();
                }
                break;
                case "entity.DemandeFourniture":
                    DemandeFourniture demandeFournitureASupprimer = (DemandeFourniture) table.getSelectionModel().getSelectedItem();

                // Vérifier si un utilisateur est sélectionné
                if (demandeFournitureASupprimer != null) {
                    // Appeler la méthode delete de UtilisateurRepository pour supprimer l'utilisateur
                    DemandeFournitureRepository demandeFournitureRepository = new DemandeFournitureRepository();
                    demandeFournitureRepository.delete(demandeFournitureASupprimer);
                    refreshDemandeFournitureList();


                }
                break;
                case "entity.RDV":
                   RDV rdvASupprimer = (RDV) table.getSelectionModel().getSelectedItem();

                // Vérifier si un utilisateur est sélectionné
                if (rdvASupprimer != null) {
                    // Appeler la méthode delete de UtilisateurRepository pour supprimer l'utilisateur
                    RDVRepository rdvRepository = new RDVRepository();
                    rdvRepository.delete(rdvASupprimer);
                    refreshRDVList();


                }
                break;
 case "entity.LinkDemandeFournitureFourniture":
     LinkDemandeFournitureFourniture linkDemandeFournitureFournitureASupprimer = (LinkDemandeFournitureFourniture) table.getSelectionModel().getSelectedItem();

                // Vérifier si un utilisateur est sélectionné
                if (linkDemandeFournitureFournitureASupprimer != null) {
                    // Appeler la méthode delete de UtilisateurRepository pour supprimer l'utilisateur
                    LinkDemandeFournitureFournitureRepository linkDemandeFournitureFournitureRepository = new LinkDemandeFournitureFournitureRepository();
                    linkDemandeFournitureFournitureRepository.delete(linkDemandeFournitureFournitureASupprimer);

                    refreshLinkDemandeFournitureFournitureList();

                }
                break;
            case "entity.LinkFournitureCommandeFourniture":
                LinkFournitureCommandeFourniture linkFournitureCommandeFournitureASupprimer = (LinkFournitureCommandeFourniture) table.getSelectionModel().getSelectedItem();

                // Vérifier si un utilisateur est sélectionné
                if (linkFournitureCommandeFournitureASupprimer != null) {
                    // Appeler la méthode delete de UtilisateurRepository pour supprimer l'utilisateur
                    LinkFournitureCommandeFournitureRepository linkFournitureCommandeFournitureRepository = new LinkFournitureCommandeFournitureRepository();
                    linkFournitureCommandeFournitureRepository.delete(linkFournitureCommandeFournitureASupprimer);

                    refreshLinkFournitureCommandeFournitureList();

                }
                break;
            case "entity.LinkFournitureFournisseur":
                LinkFournitureFournisseur linkFournitureFournisseurASupprimer = (LinkFournitureFournisseur) table.getSelectionModel().getSelectedItem();

                // Vérifier si un utilisateur est sélectionné
                if (linkFournitureFournisseurASupprimer != null) {
                    // Appeler la méthode delete de UtilisateurRepository pour supprimer l'utilisateur
                    LinkFournitureFournisseurRepository linkFournitureFournisseurRepository = new LinkFournitureFournisseurRepository();
                    linkFournitureFournisseurRepository.delete(linkFournitureFournisseurASupprimer);

                    refreshLinkFournitureFournisseurList();

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
    } private void refreshSalleList() {
        SalleRepository salleRepository = new SalleRepository();
        ObservableList<Salle> sallesData = FXCollections.observableArrayList();
        sallesData.addAll(salleRepository.findAll());
        table.setItems(sallesData);
    } private void refreshRDVList() {
        RDVRepository rdvRepository = new RDVRepository();
        ObservableList<RDV> rdvsData = FXCollections.observableArrayList();
        rdvsData.addAll(rdvRepository.findAll());
        table.setItems(rdvsData);
    } private void refreshLinkFournitureFournisseurList() {
        LinkFournitureFournisseurRepository  linkFournitureFournisseurRepository = new  LinkFournitureFournisseurRepository();
        ObservableList< LinkFournitureFournisseur>  linkFournitureFournisseursData = FXCollections.observableArrayList();
        linkFournitureFournisseursData.addAll( linkFournitureFournisseurRepository.findAll());
        table.setItems( linkFournitureFournisseursData);
    } private void refreshLinkFournitureCommandeFournitureList() {
        LinkFournitureCommandeFournitureRepository linkFournitureCommandeFournitureRepository = new LinkFournitureCommandeFournitureRepository();
        ObservableList<LinkFournitureCommandeFourniture> linkFournitureCommandeFournituresData = FXCollections.observableArrayList();
        linkFournitureCommandeFournituresData.addAll(linkFournitureCommandeFournitureRepository.findAll());
        table.setItems(linkFournitureCommandeFournituresData);
    } private void refreshLinkDemandeFournitureFournitureList() {
        LinkDemandeFournitureFournitureRepository linkDemandeFournitureFournitureRepository = new LinkDemandeFournitureFournitureRepository();
        ObservableList<LinkDemandeFournitureFourniture> linkDemandeFournitureFournituresData = FXCollections.observableArrayList();
        linkDemandeFournitureFournituresData.addAll(linkDemandeFournitureFournitureRepository.findAll());
        table.setItems(linkDemandeFournitureFournituresData);
    } private void refreshFournitureList() {
        FournitureRepository fournitureRepository = new FournitureRepository();
        ObservableList<Fourniture>fournituresData = FXCollections.observableArrayList();
        fournituresData.addAll(fournitureRepository.findAll());
        table.setItems(fournituresData);
    } private void refreshFournisseurList() {
        FournisseurRepository fournisseurRepository = new FournisseurRepository();
        ObservableList<Fournisseur> fournisseursData = FXCollections.observableArrayList();
        fournisseursData.addAll(fournisseurRepository.findAll());
        table.setItems(fournisseursData);
    } private void refreshEtudiantList() {
        EtudiantRepository etudiantRepository = new EtudiantRepository();
        ObservableList<Etudiant> etudiantsData = FXCollections.observableArrayList();
        etudiantsData.addAll(etudiantRepository.findAll());
        table.setItems(etudiantsData);
    } private void refreshDossierList() {
        DossierRepository  dossierRepository = new  DossierRepository();
        ObservableList<  Dossier>   dossiersData = FXCollections.observableArrayList();
        dossiersData.addAll(  dossierRepository.findAll());
        table.setItems( dossiersData);
    } private void refreshDemandeFournitureList() {
        DemandeFournitureRepository demandeFournitureRepository = new DemandeFournitureRepository();
        ObservableList<DemandeFourniture> demandeFournituresData = FXCollections.observableArrayList();
        demandeFournituresData.addAll(demandeFournitureRepository.findAll());
        table.setItems(demandeFournituresData);
    } private void refreshCommandeFournitureList() {
        CommandeFournitureRepository commandeFournitureRepository = new CommandeFournitureRepository();
        ObservableList<CommandeFourniture> commandeFournituresData = FXCollections.observableArrayList();
        commandeFournituresData.addAll(commandeFournitureRepository.findAll());
        table.setItems(commandeFournituresData);
    }


    @FXML void switchAddTache(ActionEvent event) throws SQLException {
        switch (this.type.getTypeName()){
            case "entity.Utilisateur" :
                Main.changeScene("Inscription", new Inscription(getUtilisateur()),"Inscription");
        break;
            case "entity.Salle" :
                Main.changeScene("Salles", new Salles(getSalle()), "Salle");
                break;
            case "entity.RDV":
                Main.changeScene("RDV", new RDVs(getRdv()),"RDV");
                 case "entity.Dossier" :
                Main.changeScene("Dossiers", new Dossiers(getDossier()), "Dossier");
                break;
            case "entity.Fourniture":
                Main.changeScene("Fournitures", new Fournitures(getFourniture()),"Fourniture");
                 break;
            case "entity.Fournisseur":
                Main.changeScene("Fournisseurs", new Fournisseurs(getFournisseur()),"Fournisseur");

 break;
            case "entity.CommandeFourniture":
                Main.changeScene("CommandeFourniture", new CommandeFournitures(getCommandeFourniture()),"CommandeFourniture");


    }}

    @FXML
    void switchAccueil(MouseEvent event) { Main.changeScene("Accueil", new Accueil(super.getUtilisateur()), "Bienvenue sur StockA !!!");


    }
    @FXML void switchConnexion(ActionEvent event) {        Main.changeScene("Accueil", new Accueil(null), "Bienvenue sur StockA !!!");
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
