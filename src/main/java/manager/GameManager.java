package manager;

import boucleur.Boucleur;
import boucleur.BoucleurDeJeu;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import model.*;
import model.createurs.CreateurCarte;
import model.createurs.CreateurCarteSimple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager implements InvalidationListener {
    private ObservableList<Joueur> joueurs = FXCollections.observableArrayList();
    private Partie p;
    private int nbJoueurs;
    private CreateurCarte leCreateur = new CreateurCarteSimple();
    private Boucleur leBoucleur = new BoucleurDeJeu();


    private GameManager() {

    }


    private static GameManager instance = null;

    /**
     * Méthode qui vérifie qu'il n'y ai pas d'instance de GameManager déja créée, si non alors elle l'instancie
     *
     * @return GameManager déja créé
     */
    public static GameManager getInstance() {
        if (instance == null)
            instance = new GameManager();
        return instance;
    }


    public void creerPartie() throws Exception {
        p = new Partie(1, joueurs);
        leCreateur.CreateurCarteDiamant(p);
//        leBoucleur.addListener(this);
//        leBoucleur.setActive(true);
//        new Thread(leBoucleur).start();
    }

    public void ajouterJoueurs(ListView<Joueur> listView) {
        for (Joueur j : listView.getItems()) {
            joueurs.add(j);
        }
    }


    public void supprimerJoueurs(Joueur j) {
        this.joueurs.remove(j);
    }

    public ObservableList<Carte> getCartes() {
        return p.getLesCartes();
    }


    public void SortirCarte() {
        ObservableList<Carte> listeCarte = p.getLesCartes();
        listeCarte.removeAll(listeCarte);

        Random rand = new Random();
        int r = rand.nextInt(99);
        if (r < 95)
            leCreateur.CreateurCartePiege(p);
        if (r >= 95) {
            leCreateur.CreateurCarteDiamant(p);
        }
    }


    @Override
    public void invalidated(Observable observable) {
        SortirCarte();
    }

    public ObservableList<Joueur> getJoueurs() {
        return joueurs;
    }

    //    public String Gagnant(ObservableList<Joueur> joueurs) {
//        String message;
//        Joueur joueurAux = new Joueur("joueurAux", 0);
//        for (Joueur j : joueurs) {
//            if (j.getNbdiamantsjoueur() > joueurAux.getNbdiamantsjoueur()) {
//                joueurAux = j;
//                message = "Le gagnant est" + joueurAux.getPseudo();
//            }
//            if (j.getNbdiamantsjoueur() == joueurAux.getNbdiamantsjoueur()) {
//                message = "Pas de gagnant, tous les joueurs sont à égalités";
//            }
//
//            if (j.getNbdiamantsjoueur() < joueurAux.getNbdiamantsjoueur()) {
//                joueurAux = j;
//                message = "Le gagnant est" + joueurAux.getPseudo();
//            }
//            return message;
//        }
    public String Gagnant(ObservableList<Joueur> joueurs) {
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

}
