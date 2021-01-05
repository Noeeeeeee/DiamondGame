package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class PageAccueilControler {

    @FXML private Button exitBouton;
    /**
     * Méthode permettant de changer de scène vers PageCreationPartie lorsque l'utilisateur appuie sur ce boutton
     * @param event
     */
    @FXML
    private void clicBoutonLancer(ActionEvent event) throws IOException
    {
        Parent PageCreationParent = FXMLLoader.load(getClass().getResource("/fxml/VuePageCreationPartie.fxml"));
        Scene PageCreationScene = new Scene(PageCreationParent);

        //Cette ligne retourne les informations de la scene
        Stage fenetre = (Stage) ((Node)event.getSource()).getScene().getWindow();
        fenetre.setScene(PageCreationScene);
        fenetre.show();
    }

    /**
     * Méthode permettant de quitter l'application lorsque l'utilisateur appuie sur ce bouton
     * @param actionEvent
     */
    public void clicBoutonExit(ActionEvent actionEvent) {
        Stage stage = (Stage) exitBouton.getScene().getWindow();
        stage.close();
    }


}
