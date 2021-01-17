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

import java.awt.*;
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

    @FXML
    private Label nombreTotal;

    @FXML
    private Label nbDiamantCarte;



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
        Bindings.bindBidirectional(nombreTotal.textProperty(),GameManager.getInstance().getP().getNombreTotalDeDiamant(),new NumberStringConverter());
        Bindings.bindBidirectional(nbDiamantCarte.textProperty(),GameManager.getInstance().getP().getNombreDiamantCourant(),new NumberStringConverter());

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

    /**
     * Méthode permettant de créer une image view et de set l'image reçu
     * @param c
     */
    public void updateCarte(Carte c)
    {
        ImageView imageCarte = new ImageView();
        imageCarte.setUserData(c);
        imageCarte.setImage(new Image(getClass().getResource(c.getImage()).toExternalForm()));
        imageCarte.setFitHeight(c.getMaxHeight());
        imageCarte.setFitWidth(c.getMaxWidth());
        imageCarte.layoutXProperty().bind(c.xProperty());
        imageCarte.layoutYProperty().bind(c.yProperty());
        MonPane.getChildren().add((imageCarte));
    }

    /**
     * Action lorsque l'utilisateur clique sur sortir
     * @param actionEvent
     * @throws Exception
     */
    public void buttonSortir(ActionEvent actionEvent) throws Exception {
        Joueur j=joueurs.getSelectionModel().getSelectedItem();
        if(j!=null){
            GameManager.getInstance().faireSortirJoueur(j);
            j.setNbdiamantsjoueur(GameManager.getInstance().getP().getNombreTotalDeDiamant().getValue());
        }
        joueurPosition();
    }

  
}
