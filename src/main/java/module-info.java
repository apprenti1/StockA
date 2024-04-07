module lasuperteam.stocka {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires MaterialFX;
    requires javax.mail;

    opens application to javafx.fxml;
    exports application;
    opens controller to javafx.fxml;
    exports controller;
    exports javamailer;
    opens javamailer to javafx.fxml;
    exports security;
    opens security to javafx.fxml;
}