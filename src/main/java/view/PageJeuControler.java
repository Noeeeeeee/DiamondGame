package view;


import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import manager.GameManager;
import model.Carte;
import model.Partie;

import java.net.URI;
import java.util.Iterator;

public class PageJeuControler {
    ObservableList list = FXCollections.observableArrayList();

    @FXML
    private Pane MonPane;

    @FXML
        private ImageView imageCarte;

    @FXML
    private ListView<String> listeJoueurs;

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


    public void initialize() throws Exception {
        for (Carte c : GameManager.getInstance().getCartes()) {
            updateCarte(c);
        }


        GameManager.getInstance().getCartes().addListener((ListChangeListener.Change<? extends Carte> change) -> {
                    change.next();
                    for (Carte c : change.getAddedSubList())
                        updateCarte(c);


                    for (Carte c : change.getRemoved()) {
                        Iterator<Node> iterator = MonPane.getChildren().iterator();
                        while (iterator.hasNext()) {
                            Node leNode = iterator.next();
                            if (leNode.getUserData() == c) {
                                iterator.remove();
                            }
                        }

                    }

                }
        );
    }

    public void updateCarte(Carte c)
    {
        imageCarte.setUserData(imageCarte);
        imageCarte.setImage(new Image(getClass().getResource(c.getImage()).toExternalForm()));
        imageCarte.layoutXProperty().bind(c.xProperty());
        imageCarte.layoutYProperty().bind(c.yProperty());
    }



}

