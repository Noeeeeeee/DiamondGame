package view;


import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.converter.NumberStringConverter;
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
    private javafx.scene.control.ListView<String> listeJoueursIn=new ListView<>();
    @FXML
    private javafx.scene.control.ListView<String> listeJoueursOut=new ListView<>();

    @FXML
    private ListView<Joueur> joueurs;

    @FXML
    private Label nombreTotal;

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
                if (listeJoueursIn.getItems().contains(joueur)) {
                    return;
                }
                listeJoueursIn.getItems().add(joueur.getPseudo());
            }else{
                if (listeJoueursOut.getItems().contains(joueur)) {
                    return;
                }
                listeJoueursOut.getItems().add(joueur.getPseudo());
                listeJoueursIn.getItems().remove(joueur.getPseudo());
            }
        }
    }

    public void initialize() throws Exception {
        for (Carte c : GameManager.getInstance().getCartes()) {
            updateCarte(c);
        }
        Bindings.bindBidirectional(nombreTotal.textProperty(),GameManager.getInstance().getP().getNombreTotalDeDiamant(),new NumberStringConverter());

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

    @FXML
    public void LancerButtonAction(ActionEvent actionEvent) throws Exception {
        GameManager.getInstance().lancerTour();
        joueurPosition();
    }

    public void joueurSuivant(ActionEvent actionEvent) {
        GameManager.getInstance().changerJoueurCourant();
    }

    public void updateCarte(Carte c)
    {
        imageCarte.setUserData(imageCarte);
        imageCarte.setImage(new Image(getClass().getResource(c.getImage()).toExternalForm()));
        imageCarte.layoutXProperty().bind(c.xProperty());
        imageCarte.layoutYProperty().bind(c.yProperty());
    }

  
}
