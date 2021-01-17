package launch;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import manager.GameManager;
import model.Joueur;
import model.Partie;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Launch extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        GameManager manager = GameManager.getInstance();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/VuePageAccueil.fxml"));
            Scene scene = new Scene(root, 700, 400);
            scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
            manager.setPrimaryStage(primaryStage);
        }
        catch (IOException e){
            System.out.println(e);
        }

    }

    @Override
    public void stop() throws Exception {
        GameManager.getInstance().stopBoucleur();
        super.stop();
    }

}


