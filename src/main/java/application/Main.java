package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.Accueil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        Main.stage = stage;
        changeScene("Accueil", new Accueil(null), "Bienvenue dans StockA");
    }
    public static void changeScene(String fxml, Object controller, String title){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/application/"+ fxml + ".fxml"));
            fxmlLoader.setController(controller);
            fxmlLoader.setCharset(StandardCharsets.UTF_8);
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

