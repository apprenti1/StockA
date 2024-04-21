
module lasuperteam.stocka {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jakarta.mail;
    requires MaterialFX;

    opens application to javafx.fxml;
    exports application;
    opens controller to javafx.fxml;
    exports controller;
    opens security to javafx.fxml;
    exports security;
}