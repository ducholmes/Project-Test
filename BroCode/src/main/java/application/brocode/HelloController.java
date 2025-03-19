package application.brocode;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    Label nameLabel;

    public void displayName(String username) {
        nameLabel.setText("Hello " + username);
    }
}
