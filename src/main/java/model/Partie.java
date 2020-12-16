package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Partie {
    private final int nbTours;
    public static Tours tour;
    private final int nbJoueur;
    private ObservableList<Joueur> joueurs;

    public Partie(int nbTours, int nbJoueur, ObservableList<Joueur> j) throws Exception{
        this.nbTours = nbTours;
        this.tour= new Tours(nbJoueur,j);
        this.nbJoueur=nbJoueur;
        this.joueurs = FXCollections.observableArrayList();
        j.forEach(this.joueurs::add);
    }

    public void changerTour(){
        this.tour = new Tours(nbJoueur,this.joueurs);
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

    @Override
    public String toString(){
        return "tours : " + nbTours + " en cours " + tour + " nb joueurs : " + nbJoueur + " joueurs : " + joueurs.toString();
    }
}
