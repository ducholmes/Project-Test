module com.example.googlebookapi {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires java.net.http;
    requires json.simple;
    requires org.apache.httpcomponents.core5.httpcore5;

    opens com.example.googlebookapi to javafx.fxml;
    exports com.example.googlebookapi;
}