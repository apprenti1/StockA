package controller;

        import entity.Fourniture;
        import entity.Utilisateur;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.ComboBox;
        import javafx.scene.control.TableView;
        import javafx.scene.control.TextField;
        import javafx.scene.input.MouseEvent;
        import javafx.util.StringConverter;
        import repo.FournitureRepository;

public class Fournisseurs extends Default {

    @FXML private TextField email;
    @FXML private Button modif;
    @FXML private TextField nom;
    @FXML private TextField prenom;
    @FXML private ComboBox<Fourniture> select;
    @FXML private TableView<?> table;
    private FournitureRepository fournitureRepository;

    public Fournisseurs(Utilisateur utilisateur) {
        super(utilisateur);
    }

    public void initialize() {
        super.initialize();
        fournitureRepository = new FournitureRepository();

        ObservableList<Fourniture> fournitures = FXCollections.observableArrayList(fournitureRepository.findAll());

        select.setItems(fournitures);
        select.setConverter(new StringConverter<Fourniture>() {
            @Override
            public String toString(Fourniture fourniture) {
                return fourniture != null ? fourniture.getLibelle() : "";
            }

            @Override
            public Fourniture fromString(String string) {
                return null;
            }
        });
    }

    @FXML void add(ActionEvent event) {}
    @FXML void modification(ActionEvent event) {}
    @FXML void viewTache(MouseEvent event) {}

}
