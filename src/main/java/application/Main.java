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
    private static Stage stage;

    @Override
    public void start(Stage firstStage) throws IOException {
        stage = firstStage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/application/Accueil.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("stocka");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void changeScene(String fichierFxml, Object controller){
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fichierFxml+".fxml"));
        System.out.println(controller.getClass().getName());
        try {
            fxmlLoader.setController(controller);
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("stocka");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void changeScene(String fichierFxml){
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fichierFxml+".fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Stocka");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void newStage(String fxml) {
        Stage window = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml+".fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }        window.setTitle("test!");
        window.setScene(scene);
        window.show();
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