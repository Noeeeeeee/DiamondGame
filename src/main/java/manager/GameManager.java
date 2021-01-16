package manager;

import KeyboardController.ControllerK;
import boucleur.Boucleur;
import boucleur.BoucleurDeJeu;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleListProperty;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager implements InvalidationListener {
    private ObservableList<Joueur> joueurs = FXCollections.observableArrayList();
    private Partie p;
    private int nbJoueurs;
    private CreateurCarte leCreateur = new CreateurCarteSimple();
    private Boucleur leBoucleur  = new BoucleurDeJeu();
    private ControllerK controllerKeybord = new ControllerK();
    public Carte carteCourante;
    private Stage stage;

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



    public void creerPartie(javafx.event.ActionEvent event) throws Exception {
        this.p=new Partie(joueurs.size(),joueurs);
        leCreateur.CreateurCarteDiamant(p);
        Parent pageCreationParent = FXMLLoader.load(getClass().getResource("/fxml/VuePageJeu.fxml"));
        Scene pageCreationScene = new Scene(pageCreationParent);
        //stage.setScene(pageCreationScene);
        Stage fenetre = (Stage) ((Node) event.getSource()).getScene().getWindow();
        fenetre.setScene(pageCreationScene);
        fenetre.show();
        controllerKeybord.initializeInputControls(pageCreationScene);
        leBoucleur.addListener(this);
        leBoucleur.setActive(true);
        new Thread(leBoucleur).start();
    }

    public void ajouterJoueurs(ListView<Joueur> listView){
        for (Joueur j:listView.getItems()) {
            joueurs.add(j);
        }
    }

    public Carte getCarteCourante() {
        return carteCourante;
    }

    public void lancerJeu(javafx.event.ActionEvent event) throws Exception {
        creerPartie(event);
    }

    public void faireSortirJoueur() throws Exception {
        p.getT().faireSortirJoueur();
    }


    public void supprimerJoueurs(Joueur j){
        this.joueurs.remove(j);
    }

    public ObservableList<Carte> getCartes(){
        return p.getLesCartes();
    }

    public void lancerTour() throws Exception {
        Thread.sleep(3000);
        p.lancerTour();
        System.out.println(getP().getT().getJcourant());
    }

    public void changerJoueurCourant(){
        p.getT().changerJoueurCourant();
    }

    public void SortirCarte()
    {
        ObservableList<Carte> listeCarte = p.getLesCartes();
        listeCarte.removeAll(listeCarte);

        Random rand=new Random();
        int r = rand.nextInt(99);
        if(r<95)
            leCreateur.CreateurCartePiege(p);
        if(r>=95){
            leCreateur.CreateurCarteDiamant(p);
        }
    }
    @Override
    public void invalidated(Observable observable) {
        SortirCarte();
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

    public ObservableList<Joueur> ajouterJoueurs(){
        joueurs.add(new Joueur("Meriem",0 ));
        return joueurs;
    }

    public void sortirCarte()
    {
        p.getLesCartes().removeAll(p.getLesCartes());
        Random rand=new Random();
        int r = rand.nextInt(99);
        if(r<95)
            leCreateur.CreateurCartePiege(p);
        if(r>=95){
            leCreateur.CreateurCarteDiamant(p);
        }
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


    public String gagnant(ObservableList<Joueur> joueurs) {
        String debut = "Le gagnant est";
        String message = "";
        for (Joueur j1 : joueurs){
            for (Joueur j2 : joueurs){
                if(!j1.equals(j2)){
                    if(j1.getNbdiamantsjoueur() > j2.getNbdiamantsjoueur()){
                        message = debut + j1.getPseudo();
                    }
                    else{
                        message = debut + j2.getPseudo();
                    }
                }

            }
        }
        if(message == ""){
            message = "Il n'y a aucun gagnant";
        }
        return message;

}
