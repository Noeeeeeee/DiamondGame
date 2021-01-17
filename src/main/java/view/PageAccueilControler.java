package view;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import manager.GameManager;

import java.awt.*;
import java.io.IOException;

public class PageAccueilControler {

    @FXML
    private Label gagnant;

    @FXML private Button exitBouton;
    /**
     * Méthode permettant de changer de scène vers PageCreationPartie lorsque l'utilisateur appuie sur ce boutton
     * @param event
     */
    @FXML
    private void clicBoutonLancer(ActionEvent event) throws IOException
    {
        GameManager.getInstance().chargerFenetre(FXMLLoader.load(getClass().getResource("/fxml/VuePageCreationPartie.fxml")));

    }

    /**
     * Méthode permettant de quitter l'application lorsque l'utilisateur appuie sur ce bouton
     * @param actionEvent
     */
    public void clicBoutonExit(ActionEvent actionEvent) {
        Stage stage = (Stage) exitBouton.getScene().getWindow();
        stage.close();
    }

    public void initialize() {
        if (GameManager.getInstance().getP() != null) {
            Bindings.bindBidirectional(gagnant.textProperty(), GameManager.getInstance().gagnant(GameManager.getInstance().ajoutListeInsideJoueurs(GameManager.getInstance().getJoueurs())));
            GameManager.getInstance().getJoueurs().removeAll(GameManager.getInstance().getJoueurs());
        }

    }

}
