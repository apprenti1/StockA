package application;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import controller.Accueil;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class Main extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        Main.stage = stage;
        changeScene("Accueil", new Accueil(), "Bienvenue dans StockA");
    }
    public static void changeScene(String fxml, Object controller, String title){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/application/"+ fxml + ".fxml"));
            fxmlLoader.setController(controller);
            fxmlLoader.setCharset(StandardCharsets.UTF_8);
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Stocka");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
   
    public static Optional<ButtonType> validationDialog(String titre, String texte){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"titre alert");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);
        alert.getDialogPane().setContentText(texte);
        alert.getDialogPane().setHeaderText(titre);
        return alert.showAndWait();
    }
}

