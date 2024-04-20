package controller;
import application.Main;
import entity.Salle;
import entity.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import repo.SalleRepository;
import repo.UtilisateurRepository;

public class Salles extends Default {

    private SalleRepository salleRepository;



    @FXML
    private Text erreur;

    @FXML
    private TextField salle;


    public Salles(Salle salle) {
        super(salle);
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
        String libelle = salle.getText(); // Récupérer le libellé depuis le champ de texte salle


        // Enregistrer la nouvelle salle dans le SalleRepository
        SalleRepository salleRepository = new SalleRepository();
       int idSalle =  salleRepository.upload(new Salle(libelle));
        System.out.println("Salle enregistrée avec succès, ID : " + idSalle);

        Main.changeScene("CRUD", new CRUD( Salle.class, getUtilisateur()), "CRUD | salles");
    }

    }


