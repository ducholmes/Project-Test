module application.brocode {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens application.brocode to javafx.fxml;
    exports application.brocode;
}