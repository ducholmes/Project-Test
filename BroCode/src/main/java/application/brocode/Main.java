package application.brocode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        URL fxmlResource = getClass().getResource("Main.fxml");;
        if (fxmlResource == null) {
            System.out.println("File FXML không được tìm thấy");
        } else {
            Parent root = FXMLLoader.load(fxmlResource);
            Scene scene = new Scene(root, Color.rgb(62, 180, 137));
            stage.setScene(scene);
            stage.setTitle("First Program");
            stage.show();
        }
    }
}
