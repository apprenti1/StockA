package controller;
import application.Main;
import entity.Salle;
import entity.Dossier;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import repo.RDVRepository;
import repo.SalleRepository;
import repo.DossierRepository;
import entity.RDV;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
public class RDVs extends Default {
    private RDVRepository rdvRepository;
    private SalleRepository salleRepository;
    private DossierRepository dossierRepository;

    @FXML
    private DatePicker date;

    @FXML
    private ComboBox<?> fiche;

    @FXML
    private ComboBox<?> salle;
    @FXML
    private ComboBox<LocalTime> creneau;

    public RDVs(RDV rdv) {
        super(rdv);
    }

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
        LocalDate selectedDate = date.getValue();
        if (selectedDate != null) {
            populateCreneaux(selectedDate);
        }

        RDVRepository rdvRepository = new RDVRepository();

        Main.changeScene("CRUD", new CRUD(RDV.class, getUtilisateur()), "CRUD | RDV");
    }

    private void populateCreneaux(LocalDate date) {
        creneau.getItems().clear();
        // Génération des créneaux pour la date spécifiée
        LocalTime heureDebut = LocalTime.of(8, 0); // 8h
        LocalTime heureFin = LocalTime.of(16, 0); // 16h
        while (heureDebut.isBefore(heureFin)) {
            creneau.getItems().add(heureDebut); // Ajoute l'heure au format texte
            heureDebut = heureDebut.plusHours(1); // Ajoute une heure
        }
    }

    }
