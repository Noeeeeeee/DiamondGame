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

public class GameManager implements InvalidationListener {
    private ObservableList<Joueur> joueurs = FXCollections.observableArrayList();
    private Partie p;
    private int nbJoueurs;
    private CreateurCarte leCreateur = new CreateurCarteSimple();
    private Boucleur leBoucleur  = new BoucleurDeJeu();
    private ControllerK controllerKeyboard = new ControllerK();
    private Stage primaryStage;
    int cpt = 0;


    private StringProperty message = new SimpleStringProperty();


    private GameManager(){

    }


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

    public String getMessage() {
        return message.get();
    }

    public StringProperty messageProperty() {
        return message;
    }

    public void setMessage(String message) {
        this.message.set(message);
    }

    public void creerPartie(javafx.event.ActionEvent event) throws Exception {
        this.p=new Partie(joueurs.size(),joueurs);
        this.chargerFenetre(FXMLLoader.load(getClass().getResource("/fxml/VuePageJeu.fxml")));
        leBoucleur.addListener(this);
        leBoucleur.setActive(true);
        new Thread(leBoucleur).start();
        //controllerKeyboard.initializeInputControls(pageCreationScene);

    }


    public void ajouterJoueurs(ListView<Joueur> listView){
        for (Joueur j:listView.getItems()) {
            joueurs.add(j);
        }
    }


    public void lancerJeu(javafx.event.ActionEvent event) throws Exception {
        creerPartie(event);
    }

    public void faireSortirJoueur(Joueur j) throws Exception {
        if (j!=null){
            p.faireSortirJoueur(j);
        }
    }


    public void supprimerJoueurs(Joueur j){
        this.joueurs.remove(j);
    }

    public ObservableList<Carte> getCartes(){
        return p.getLesCartes();
    }

    public void sortirCarte() throws IOException {

        Random rand=new Random();
        int r = rand.nextInt(99);
        if (!JoueurRestant()) {
            leBoucleur.setActive(false);
            this.chargerFenetre(FXMLLoader.load(getClass().getResource("/fxml/VuePageAccueil.fxml")));
            return;

        }
        else {
            if (r > 80) {
                leCreateur.CreateurCartePiege(p);
                leBoucleur.setActive(false);
                this.chargerFenetre(FXMLLoader.load(getClass().getResource("/fxml/VuePageAccueil.fxml")));
                return;
            }

            if (r <= 80) {
                leCreateur.CreateurCarteDiamant(p);
                for (Carte c : p.getLesCartes())
                    p.compteurDiamant((CarteDiamant) c);
            }
        }


    }

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

    @Override
    public void invalidated(Observable observable) {
        try {
            this.supp();
            sortirCarte();
            } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void supp(){
        p.getLesCartes().removeAll(p.getLesCartes());
    }

    public ObservableList<Joueur> getJoueurs(){
        return joueurs;
    }

    public Partie getP(){
        return p;
    }

    public void stopBoucleur() {
        leBoucleur.setActive(false);
    }

    public void chargerFenetre(Parent root)
    {
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }


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
            message.setValue("1 seul gagnant :" + listeInsideJoueurs.get(0).getPseudo());
        if (message.getValue()=="")
            message.setValue("Il n'y a aucun gagnant");
        return message;
    }

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
