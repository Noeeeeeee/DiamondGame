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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Launch extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


//        Joueur jean=new Joueur("jean",0);
//        ObservableList<Joueur> j = FXCollections.observableArrayList(jean,new Joueur("oui",0));
//        try {
//            Partie p=new Partie(5,j);
//            p.sortirCartes();
//            System.out.println(p);
//            p.faireSortirJoueur(jean);
//            System.out.println(p);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }


        GameManager manager = GameManager.getInstance();
        manager.setStage(primaryStage);

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/VuePageAccueil.fxml"));
        Scene scene = new Scene(root, 700, 400);
        scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void stop() throws Exception {
        GameManager.getInstance().stopBoucleur();
        super.stop();
    }
}
