package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import manager.GameManager;
import model.Joueur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.EventObject;
import java.util.List;

public class PageCreationControler {
    /**
     * Configure la listeView des personnes présentes dans la partie
     */
    @FXML
    private ListView<Joueur> listeJoueurs;
    @FXML
    private TextField nouveauPseudo;
    @FXML private Button retour;

    /**
     * Méthode permettant la création d'un nouveau joueur et son ajout dans la liste
     */
    @FXML
    private void AjoutJoueurBouton()
    {
        Joueur nouveauJoueur = new Joueur(nouveauPseudo.getText(), 0);
        if(nouveauPseudo.getText().isEmpty())
        {
            System.out.println("Problème le pseudo est vide");
        }
        listeJoueurs.getItems().add(nouveauJoueur);
    }

    /**
     * Méthode permettant la suppression d'un nouveauJoueur lorsque l'utilisateur clique sur le boutton suppression
     */
    @FXML
    private void SuppressionJoueurBouton()
    {
        ObservableList<Joueur> list;
        Joueur joueurSupprime;
        list = listeJoueurs.getItems();

        //Cette ligne nous donnes les lignes selectionnées par l'utilisateur
        joueurSupprime = listeJoueurs.getSelectionModel().getSelectedItem();

        list.remove(joueurSupprime);
    }




    @FXML
    private void RetourBouton(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) retour.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void CreationPartieBouton(javafx.event.ActionEvent event) throws IOException {
        //GameManager.getInstance().creerPartie();
        //GameManager.getInstance().ajouterJoueurs(listeJoueurs); PROBLEME car il attend une list et pas une listView
        Parent PageCreationParent = FXMLLoader.load(getClass().getResource("/fxml/VuePageJeu.fxml"));
        Scene PageCreationScene = new Scene(PageCreationParent);

        //Cette ligne retourne les informations de la scene
        Stage fenetre = (Stage) ((Node)event.getSource()).getScene().getWindow();
        fenetre.setScene(PageCreationScene);
        fenetre.show();
    }
}
