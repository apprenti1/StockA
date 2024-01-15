module lasuperteam.stocka {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens lasuperteam.stocka to javafx.fxml;
    exports lasuperteam.stocka;
}