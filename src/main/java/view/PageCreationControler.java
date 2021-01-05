package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import manager.GameManager;
import model.Joueur;

import javax.swing.*;
import java.awt.event.ActionEvent;
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
    private void CreationPartieBouton(ActionEvent event)
    {
        GameManager.getInstance().creerPartie();
        //GameManager.getInstance().ajouterJoueurs(listeJoueurs); PROBLEME car il attend une list et pas une listView
    }

    @FXML
    private void RetourBouton(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) retour.getScene().getWindow();
        stage.close();
    }
}
