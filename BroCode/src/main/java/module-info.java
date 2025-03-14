module application.brocode {
    requires javafx.controls;
    requires javafx.fxml;


    opens application.brocode to javafx.fxml;
    exports application.brocode;
}