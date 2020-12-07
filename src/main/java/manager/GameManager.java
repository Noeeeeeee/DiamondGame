package manager;

import model.Joueur;
import model.Partie;

import java.util.List;

public class GameManager {
    private List<Joueur> joueurs;
    private Partie p;
    private int nbJoueurs;
    private int nbTours;

    public void creerPartie(){
        this.p=new Partie(this.nbTours,this.nbJoueurs,this.joueurs);
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
