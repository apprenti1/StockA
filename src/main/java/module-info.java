module lasuperteam.stocka {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;

    opens application to javafx.fxml;
    exports application;
    opens controller to javafx.fxml;
    exports controller;
}