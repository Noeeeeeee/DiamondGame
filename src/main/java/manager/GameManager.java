package manager;

import KeyboardController.ControllerK;
import boucleur.Boucleur;
import boucleur.BoucleurDeJeu;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.*;
import model.createurs.CreateurCarte;
import model.createurs.CreateurCarteSimple;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe du manager de l'application
 */
public class GameManager implements InvalidationListener {
    /**
     * Liste observable des joueurs du jeu
     */
    private ObservableList<Joueur> joueurs = FXCollections.observableArrayList();
    /**
     * Attribut d'une partie
     */
    private Partie p;
    /**
     * Instanciation du CreateurCarteSimple
     */
    private CreateurCarte leCreateur = new CreateurCarteSimple();
    /**
     * Instanciation du BoucleurDeJeu
     */
    private Boucleur leBoucleur  = new BoucleurDeJeu();
    /**
     * Instanciation du KeyboardController
     */
    private ControllerK controllerKeyboard = new ControllerK();
    /**
     * Déclaration de la variable de type Stage primaryStage
     */
    private Stage primaryStage;


    private StringProperty message = new SimpleStringProperty();


    private static GameManager instance = null;

    /**
     * Méthode qui vérifie qu'il n'y ai pas d'instance de GameManager déja créée, si non alors elle l'instancie
     * @return GameManager déja créé
     */
    public static GameManager getInstance() {
        if (instance == null)
            instance = new GameManager();
        return instance;
    }

    /**
     * Recupere le message définit dans la méthode gagnant
     * @return le message
     */
    public String getMessage() {
        return message.get();
    }


    /**
     * Set message
     * @param message
     */
    public void setMessage(String message) {
        this.message.set(message);
    }

    /**
     * Méthode permettant de creer une partie
     * @param event
     * @throws Exception
     */
    public void creerPartie(javafx.event.ActionEvent event) throws Exception {
        this.p=new Partie(joueurs.size(),joueurs);
        this.chargerFenetre(FXMLLoader.load(getClass().getResource("/fxml/VuePageJeu.fxml")));
        leBoucleur.addListener(this);
        leBoucleur.setActive(true);
        new Thread(leBoucleur).start();
        controllerKeyboard.initializeInputControls(primaryStage.getScene());

    }

    /**
     * Méthode permettant d'ajouterJoueurs dans notre liste joueurs
     * @param listView
     */
    public void ajouterJoueurs(ListView<Joueur> listView){
        for (Joueur j:listView.getItems()) {
            joueurs.add(j);
        }
    }

    /**
     * Méthode permettant de lancer le jeu qui appelle creerPartie
     * @param event
     * @throws Exception
     */
    public void lancerJeu(javafx.event.ActionEvent event) throws Exception {
        creerPartie(event);
    }

    /**
     * Méthode permettant de faire sortir un joueur de la partie
     * @param j
     * @throws Exception
     */
    public void faireSortirJoueur(Joueur j) throws Exception {
        if (j!=null){
            p.faireSortirJoueur(j);
        }
    }

    /**
     * Méthode permettant de supprimer un joueur de la liste de joueurs
     * @param j
     */
    public void supprimerJoueurs(Joueur j){
        this.joueurs.remove(j);
    }

    /**
     * Recupere la liste de carte de la partie
     * @return la liste de cartes
     */
    public ObservableList<Carte> getCartes(){
        return p.getLesCartes();
    }

    /**
     * Méthode appelée par l'invalidated qui permet de sortir une carte dans le jeu et gère l'arrêt de la partie
     * @throws IOException
     */
    public void sortirCarte() throws IOException {

        Random rand=new Random();
        int r = rand.nextInt(99);
        if (!JoueurRestant()) {
            leBoucleur.setActive(false);
            this.chargerFenetre(FXMLLoader.load(getClass().getResource("/fxml/VuePageAccueil.fxml")));
            return;

        }
        else {
            if (r > 85) {
                leCreateur.CreateurCartePiege(p);
                leBoucleur.setActive(false);
                this.chargerFenetre(FXMLLoader.load(getClass().getResource("/fxml/VuePageAccueil.fxml")));
                return;
            }

            if (r <= 85) {
                leCreateur.CreateurCarteDiamant(p);
                for (Carte c : p.getLesCartes())
                    p.compteurDiamant((CarteDiamant) c);
            }
        }


    }

    /**
     * Méthode Boolean permettant de savoir si il y a des joueurs restant dans la partie
     * @return un booléen
     */
    public Boolean JoueurRestant()
    {
        Boolean a = false;

        for (Joueur j : joueurs)
        {
            if(j.isInside())
                a= true;
            else a = false;
        }

        return a;
    }

    /**
     * Méthode invalidated appelée par le boucleur
     * @param observable
     */
    @Override
    public void invalidated(Observable observable) {
        try {
            this.supp();
            sortirCarte();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * Méthode permettant du supprimer toutes les cartes de la liste de carte
     */
    public void supp(){
        p.getLesCartes().removeAll(p.getLesCartes());
    }

    /**
     * Récupère la liste de joueurs
     * @return la liste des joueurs
     */
    public ObservableList<Joueur> getJoueurs(){
        return joueurs;
    }

    /**
     * Récupère la partie
     * @return la partie p
     */
    public Partie getP(){
        return p;
    }

    /**
     * Méthode permettant de stopper le boucleur
     */
    public void stopBoucleur() {
        leBoucleur.setActive(false);
    }

    /**
     * Méthode permettant de chager une fenetre
     * @param root
     */
    public void chargerFenetre(Parent root)
    {
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Récupere le primaryStage
     * @return le primaryStage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Set la primaryStage
     * @param primaryStage
     */
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * Méthode permettant de définir un gagnant de la partie
     * @param listeInsideJoueurs
     * @return le message à afficher
     */
    public StringProperty gagnant(ObservableList<Joueur> listeInsideJoueurs) {
        String debut = "Le gagnant est ";
        message.setValue("");
        if (listeInsideJoueurs.size() > 1) {
            for (Joueur j1 : listeInsideJoueurs) {
                for (Joueur j2 : listeInsideJoueurs) {

                    if (!j1.equals(j2)) {
                        if (j1.getNbdiamantsjoueur() > j2.getNbdiamantsjoueur()) {
                            message.setValue(debut + j1.getPseudo() + " avec un nombre de : " + j1.getNbdiamantsjoueur() + "diamants");
                        } else {
                            message.setValue(debut + j2.getPseudo() + " avec un nombre de : " + j2.getNbdiamantsjoueur() + "diamants");
                        }
                    }

                }
            }

        }
        if (listeInsideJoueurs.size() ==1)
            message.setValue("Le gagnant est : " + listeInsideJoueurs.get(0).getPseudo());
        if (message.getValue()=="")
            message.setValue("Il n'y a aucun gagnant");
        return message;
    }

    /**
     * Méthode permettant d'ajouter les joueurs qui ne sont pas dans la partie (utile pour la méthode gagnant)
     * @param joueurs
     * @return la liste auxiliaire listeInsideJoueur
     */
    public ObservableList<Joueur> ajoutListeInsideJoueurs(ObservableList<Joueur> joueurs)
    {
        ObservableList<Joueur> listeInsideJoueurs = FXCollections.observableArrayList();
        for (Joueur j : joueurs) {
            if (!j.isInside())
                listeInsideJoueurs.add(j);
        }
        return listeInsideJoueurs;
    }
}

