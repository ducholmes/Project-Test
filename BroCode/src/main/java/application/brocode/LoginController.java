package application.brocode;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class LoginController {
    @FXML
    TextField myTextField;

    private Parent root;
    private Scene scene;
    private Stage stage;

    public void login (ActionEvent event) throws IOException {
        String username = myTextField.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Hello.fxml"));
        root = loader.load();

        HelloController helloController = loader.getController();
        helloController.displayName(username);

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
