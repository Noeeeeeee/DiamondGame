package model;

import java.util.List;

public class Partie {
    private final int nbTours;
    private Tours tour;
    private final int nbJoueur;
    private List<Joueur> joueurs;

    public Partie(int nbTours, int nbJoueur, List<Joueur> j) {
        this.nbTours = nbTours;
        this.tour= new Tours(j);
        this.nbJoueur=nbJoueur;
        joueurs.forEach(joueur -> {
            this.joueurs.add(joueur);
        });
    }

    public void changerTour(){
        this.tour = new Tours(this.joueurs);
    }

    public void faireSortirJoueur(Joueur j,Tours t) throws Exception {
        t.sortieJoueur(j);
    }

    public int getNbTours() {
        return nbTours;
    }

    public int getNbJoueur() {
        return nbJoueur;
    }

    public Tours getTour() {
        return tour;
    }
}
