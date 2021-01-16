package manager;

import boucleur.Boucleur;
import boucleur.BoucleurDeJeu;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;
import model.createurs.CreateurCarte;
import model.createurs.CreateurCarteSimple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager implements InvalidationListener {
    private ObservableList<Joueur> joueurs = FXCollections.observableArrayList();
    public Partie p;
    private int nbJoueurs;
    private CreateurCarte leCreateur = new CreateurCarteSimple();
    private Boucleur leBoucleur  = new BoucleurDeJeu();
    public Carte carteCourante;
    private Stage stage;



    private GameManager() {
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

    public Carte getCarteCourante() {
        return carteCourante;
    }

//    public void setCarteCourante()
//    {
//        Random rand=new Random();
//        int r = rand.nextInt(99);
//        if(r<95)
//            this.carteCourante = leCreateur.CreateurCartePiege(p);
//        if(r>=95)
//            this.carteCourante = leCreateur.CreateurCarteDiamant(p);
//    }
    public void stopBoucleur() {
        leBoucleur.setActive(false);
    }

    public void creerPartie() throws Exception {
        joueurs = ajouterJoueurs();
        p=new Partie(1, joueurs);
        leCreateur.CreateurCarteDiamant(p);
        Parent pageCreationParent = FXMLLoader.load(getClass().getResource("/fxml/VuePageJeu.fxml"));
        Scene pageCreationScene = new Scene(pageCreationParent);
        stage.setScene(pageCreationScene);

        leBoucleur.addListener(this);
        leBoucleur.setActive(true);
        new Thread(leBoucleur).start();
    }

    public ObservableList<Joueur> ajouterJoueurs(){
       joueurs.add(new Joueur("Meriem",0 ));
       return joueurs;
    }


    public void supprimerJoueurs(Joueur j){
        this.joueurs.remove(j);
    }

    public ObservableList<Carte> getCartes(){
        return p.getLesCartes();
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
    @Override
    public void invalidated(Observable observable) {
        this.sortirCarte();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}

