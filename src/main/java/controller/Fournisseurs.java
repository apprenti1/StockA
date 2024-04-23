package controller;

        import entity.Fournisseur;
        import entity.Fourniture;
        import entity.LinkFournitureFournisseur;
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
        import javafx.scene.text.Text;
        import javafx.util.Pair;
        import javafx.util.StringConverter;
        import repo.FournitureRepository;

        import java.util.ArrayList;

public class Fournisseurs extends Default {

    @FXML private TextField email;
    @FXML private Button modif;
    @FXML private TextField nom;
    @FXML private TextField prenom;
    @FXML private ComboBox<Fourniture> select;
    @FXML private TableView<?> table;
    @FXML private TextField price;
    @FXML private Text erreur;
    private ArrayList<Pair<Fourniture, Double>> fournitures;
    private ArrayList<Pair<Fourniture, Double>> sellFournitures;

    public Fournisseurs(Utilisateur utilisateur) {this(utilisateur, null, null);}
    public Fournisseurs(Utilisateur utilisateur, ArrayList<Pair<Fourniture, Double>> sellFournitures, Fournisseur fournisseurAModifier) {
        super(utilisateur);
    }

    public void initialize() {
        super.initialize();
        FournitureRepository fournitureRepository = new FournitureRepository();
        ObservableList<Fourniture> fournitures = FXCollections.observableArrayList(fournitureRepository.findAll());
        select.setItems(fournitures);
        select.setConverter(new StringConverter<Fourniture>() {
            @Override public String toString(Fourniture fourniture) {return fourniture != null ? fourniture.getLibelle() : "";}
            @Override public Fourniture fromString(String string) {
                return null;
            }
        });
        if (!fournitures.isEmpty()) {select.getSelectionModel().select(fournitures.get(0));}

        // initialisation du tableau avec repo LinkFournitureFournisseur
    }

    @FXML void add(ActionEvent event) {
        try {
            this.fournitures.add(
                    new Pair<Fourniture, Double>(
                        select.getSelectionModel().getSelectedItem(),
                        Double.parseDouble(price.getText())
                    )
            );

            // refresh le tableau avec les données ajouté
        } catch (NumberFormatException e) {
            erreur.setText("Le prix ne peut être q'un décimal !!!");
        }
    }
    @FXML void modification(ActionEvent event) {
        // /!\ si this.fournitures n'est pas vide
        //si c'est une modification update fournisseur
        //sinon créer fournisseur
        //comparer les produits entre la version this.fournitures et une version avant modif this.oldFournitures
        //pour chaque fourniture différentes, ajouter un link fourniture fournisseur
        //pour chaque fourniture semblable, comparer les prix et effectuer un update sur tout les prix non semblables en se basant sur les old id
        //redirrection vers le crud fournisseur
    }
    @FXML void viewTache(MouseEvent event) {
        //lors du double clic si item selectionné != null retirer la fourniture en se basant sur l'id de la fourniture de this.fournitures
        //refresh le tableau avec les données mis a jour.
    }

}
