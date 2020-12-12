package launch;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import manager.GameManager;
import model.Joueur;
import model.Partie;
import model.Tours;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Launch extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/VuePageCreationPartie.fxml"));
        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    }



    public static void main(String[] args) {
        launch(args);
        /*
        Joueur jean=new Joueur("jean",0);
        ObservableList<Joueur> j = FXCollections.observableArrayList(jean,new Joueur("oui",0));
        Partie p=new Partie(5, 2,j);
        System.out.println(p.toString());
        try {
            p.tour.sortieJoueur(jean);
        }catch (Exception e){
            e.getMessage();
        }
        System.out.println(p.tour.toString());
        */
    }

    GameManager manager = new GameManager();
    //manager.getInstance();
}
