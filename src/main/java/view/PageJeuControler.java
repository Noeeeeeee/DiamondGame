package view;


import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import manager.GameManager;
import model.Carte;
import model.Joueur;

import java.net.URI;
import java.util.Iterator;

public class PageJeuControler {
    ObservableList<Joueur> list = FXCollections.observableArrayList();

    @FXML
    private Pane MonPane;

    @FXML
    private ImageView imageCarte;

    @FXML
    private ListView<String> listeJoueursIn;
    @FXML
    private ListView<String> listeJoueursOut;

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


    /**
     * change la position du joueur suivant si il est ou non dans la pyramide
     */
    public void joueurPosition(){
        list=GameManager.getInstance().getJoueurs();
        for (Joueur joueur: list ) {
            if(joueur.isInside()){
                if (!listeJoueursIn.getItems().contains(joueur.getPseudo())){
                    listeJoueursIn.getItems().add(joueur.getPseudo());
                    listeJoueursOut.getItems().remove(joueur.getPseudo());
                }
            }else{
                if (!listeJoueursOut.getItems().contains(joueur.getPseudo())){
                    listeJoueursOut.getItems().add(joueur.getPseudo());
                    listeJoueursIn.getItems().remove(joueur.getPseudo());
                }
            }
        }
    }

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
        for (Joueur j : GameManager.getInstance().getJoueurs()) {
            joueurs.getItems().add(j);
        }
        joueurPosition();
    }

    public void updateCarte(Carte c)
    {
        imageCarte.setUserData(imageCarte);
        imageCarte.setImage(new Image(getClass().getResource(c.getImage()).toExternalForm()));
        imageCarte.layoutXProperty().bind(c.xProperty());
        imageCarte.layoutYProperty().bind(c.yProperty());
    }

    public void buttonSortir(ActionEvent actionEvent) throws Exception {
        Joueur j=joueurs.getSelectionModel().getSelectedItem();
        if(j!=null){
            GameManager.getInstance().faireSortirJoueur(j);
        }
        joueurPosition();
    }

  
}
