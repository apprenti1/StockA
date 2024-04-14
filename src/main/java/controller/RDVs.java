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
    private ComboBox<?> creneau;

    public RDVs(RDV rdv) {
        super(rdv);
    }

    @FXML
    void Deconnexion(MouseEvent event) {

    }

    @FXML
    void switchAccueil(MouseEvent event) {

    }

    @FXML
    void valider(MouseEvent event) {
        RDVRepository rdvRepository = new RDVRepository();

        Main.changeScene("CRUD", new CRUD(RDV.class, getUtilisateur()), "CRUD | RDV");
    }
}
