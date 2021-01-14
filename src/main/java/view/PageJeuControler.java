package view;


import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import manager.GameManager;
import model.Carte;
import model.Joueur;

import java.net.URI;

public class PageJeuControler {
    ObservableList<Joueur> list = FXCollections.observableArrayList();

    @FXML
    private Pane MonPane;

    @FXML
    private ImageView imageCarte;

    @FXML
    private javafx.scene.control.ListView<String> listeJoueursIn=new ListView<>();
    @FXML
    private javafx.scene.control.ListView<String> listeJoueursOut=new ListView<>();

    @FXML
    private ListView<Joueur> joueurs;

    /*@FXML
    private void chargeDonnéesListView(){
        list.removeAll();
        String j1 = "joueur1";
        String j2 = "joueur2";
        String j3 = "joueur3";
        String j4 = "joueur4";
        list.addAll(j1, j2, j3, j4);
        listeJoueurs.getItems().addAll(list);
    }*/

    public void joueurPosition(){
        list=GameManager.getInstance().getJoueurs();
        for (Joueur joueur: list ) {
            if(joueur.isInside()){
                listeJoueursIn.getItems().add(joueur.getPseudo());
            }else{
                listeJoueursOut.getItems().add(joueur.getPseudo());
            }
        }
    }

    public void initialize() throws Exception {
        joueurPosition();
        for (Joueur j:GameManager.getInstance().getJoueurs()) {
            joueurs.getItems().add(j);
        }
        GameManager.getInstance().getCartes().addListener((ListChangeListener.Change<? extends Carte> change) -> {
                    change.next();
                    for (Carte c : GameManager.getInstance().getCartes()) {
                        imageCarte.setImage(new Image(getClass().getResource(c.getImage()).toExternalForm()));
                        imageCarte.layoutXProperty().bind(c.xProperty());
                        imageCarte.layoutYProperty().bind(c.yProperty());

                    }

                }
        );


        //this.chargeDonnéesListView();
    }

}
