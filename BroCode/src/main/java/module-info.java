module application.brocode {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens application.brocode to javafx.fxml;
    exports application.brocode;
}