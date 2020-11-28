package launch;

import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Launch extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    primaryStage.setScene(new Scene(new Button("Coucou")));
    primaryStage.show();
    }
}
