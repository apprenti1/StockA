module lasuperteam.stocka {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires javax.mail;
    requires org.apache.commons.lang3;
    requires MaterialFX;

    requires activation;

    opens application to javafx.fxml;
    exports application;
    opens controller to javafx.fxml;
    exports controller;
    exports bdd;
    opens bdd to javafx.fxml;
    exports security;
    opens security to javafx.fxml;
}