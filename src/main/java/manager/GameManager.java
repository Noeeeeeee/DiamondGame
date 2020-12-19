package manager;

import javafx.collections.ObservableList;
import model.Joueur;
import model.Partie;

import java.util.List;

public class GameManager {
    private ObservableList<Joueur> joueurs;
    private Partie p;
    private int nbJoueurs;
    private int nbTours;

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



    public void creerPartie(){
        //this.p=new Partie(this.nbTours,this.nbJoueurs,this.joueurs);
    }

    public void ajouterJoueurs(List<Joueur> joueurs){
        joueurs.forEach(joueur -> {
            this.joueurs.add(joueur);
        });
    }


    public void supprimerJoueurs(Joueur j){
        this.joueurs.remove(j);
    }
}
