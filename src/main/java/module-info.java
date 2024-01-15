module lasuperteam.stocka2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens lasuperteam.stocka2 to javafx.fxml;
    exports lasuperteam.stocka2;
}