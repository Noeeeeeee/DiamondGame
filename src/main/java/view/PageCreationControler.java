package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import manager.GameManager;
import model.Joueur;

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
        if(nouveauPseudo.getText().isEmpty())
        {
            VBox dialogVbox = new VBox(5);
            dialogVbox.setAlignment(Pos.CENTER);
            dialogVbox.getChildren().add(new Text("Problème le pseudo est vide"));
            Scene dialogScene = new Scene(dialogVbox, 250, 20);
            Stage popUp=new Stage();
            popUp.setTitle("Pseudo vide");
            popUp.setScene(dialogScene);
            popUp.show();
            return;
        }
        for (Joueur j:listeJoueurs.getItems()) {
            if (nouveauPseudo.getText().equals(j.getPseudo())){
                VBox dialogVbox = new VBox(5);
                dialogVbox.setAlignment(Pos.CENTER);
                dialogVbox.getChildren().add(new Text("pseudo déjà existant"));
                Scene dialogScene = new Scene(dialogVbox, 250, 20);
                Stage popUp=new Stage();
                popUp.setTitle("Déjà pris");
                popUp.setScene(dialogScene);
                popUp.show();
                return;
            }
        }
        Joueur nouveauJoueur = new Joueur(nouveauPseudo.getText());
        listeJoueurs.getItems().add(nouveauJoueur);
        listeJoueurs.setCellFactory(__-> new CelluleJoueur());
        nouveauPseudo.clear();
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
    public void CreationPartieBouton(javafx.event.ActionEvent event) throws Exception {
        if(listeJoueurs.getItems().isEmpty()){

            VBox dialogVbox = new VBox(5);
            dialogVbox.setAlignment(Pos.CENTER);
            dialogVbox.getChildren().add(new Text("Vous devez ajouter des joueurs avant de lancer la partie"));
            Scene dialogScene = new Scene(dialogVbox, 370, 20);
            Stage popUp=new Stage();
            popUp.setTitle("Erreur nombre de joueurs");
            popUp.setScene(dialogScene);
            popUp.show();
        }
        else {
            GameManager.getInstance().ajouterJoueurs(listeJoueurs);
            GameManager.getInstance().lancerJeu(event);
        }
    }
}
