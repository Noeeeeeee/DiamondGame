package view;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.net.URI;

public class PageJeuControler {
    ObservableList list= FXCollections.observableArrayList();

    @FXML
    private ListView<String> listeJoueurs;


    @FXML
    private void chargeDonnéesListView(){
        list.removeAll();
        String j1 = "joueur1";
        String j2 = "joueur2";
        String j3 = "joueur3";
        String j4 = "joueur4";
        list.addAll(j1, j2, j3, j4);
        listeJoueurs.getItems().addAll(list);
    }

    @FXML
    public void initialize() {
        this.chargeDonnéesListView();
    }

}
