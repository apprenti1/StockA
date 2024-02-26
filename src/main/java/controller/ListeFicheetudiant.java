package controller;
import entity.Etudiant;
import entity.UtilisateurConnecte;
import application.Main;
import javafx.fxml.Initializable;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ListeFicheetudiant implements Initializable {
    private UtilisateurConnecte utilisateur;

    public ListeFicheetudiant() {
        this.utilisateur = UtilisateurConnecte.getUniqueInstance();
    }


    @FXML
    private TableView<Etudiant> arrayetudiant;

    @FXML
    private Label titre;

    @FXML
    void Create(ActionEvent event) {
        {
            Main.changeScene("/application/FicheEtudiant", new FicheEtudiant());
        }

    }

    @FXML
    void Deconnexion(MouseEvent event) {
        UtilisateurConnecte.setUniqueInstance();
        Main.changeScene("/application/Accueil");

    }

    @FXML
    void edit(ActionEvent event) {

    }

    @FXML
    void supprimer(ActionEvent event) {

    }

    @FXML
    void switchAccueil(MouseEvent event) {
        Main.changeScene("/application/Admin/PageAdminlog", new PageAdminlog());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[][] colonnes = {
                {"Nom", "nom"},
                {"Prenom", "prenom"},
                {"Email", "email"},
                {"Diplome", "diplome"},
                {"Telephone", "telephone"},
                {"Rue", "rue"},
                {"Cp", "cp"},
                {"Ville", "ville"},

        };
        for (int i = 0; i < colonnes.length; i++) {
            TableColumn<Etudiant, String> firstNameColumn = new TableColumn<>(colonnes[i][0]);
            firstNameColumn.setCellValueFactory(new PropertyValueFactory<>(colonnes[i][1]));
            arrayetudiant.getColumns().add(firstNameColumn);
        }
        Etudiant EtudiantRepository = new Etudiant();
        ResultSet rs = null;
        try{
            rs = EtudiantRepository.select();
            while (rs.next()){
                Etudiant rs2 = new Etudiant(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9));
                arrayetudiant.getItems().add(rs2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
