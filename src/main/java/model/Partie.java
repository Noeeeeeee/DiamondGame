package model;

import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Partie {
    public static Tour tour;
    private final int nbJoueur;
    private ObservableList<Joueur> joueurs;
    private ObservableList<Carte> lesCartesObs = FXCollections.observableArrayList();
    private ListProperty<Carte> lesCartesProp = new SimpleListProperty<>(lesCartesObs);

    public Partie(int nbJoueur, ObservableList<Joueur> j) throws Exception{
        this.tour= new Tour(nbJoueur,j);
        this.nbJoueur=nbJoueur;
        this.joueurs = j;
    }



    public ListProperty<Carte> lesCartesProperty(){return lesCartesProp;}

    public ObservableList<Carte> getLesCartes() {return lesCartesObs;}

    public void ajouterCarteView(Carte c){ lesCartesObs.add(c);}

    public void changerTour(){
        this.tour = new Tour(nbJoueur,this.joueurs);
    }

    public static void faireSortirJoueur(Joueur j,Tour t) throws Exception {
        t.sortieJoueur(j);
    }

    public int getNbJoueur() {
        return nbJoueur;
    }

    public Tour getTour() {
        return tour;
    }

    @Override
    public String toString(){
        return "tours : "  + " en cours " + tour + " nb joueurs : " + nbJoueur + " joueurs : " + joueurs.toString();
    }

    public void ajouterCarte(Carte carte) {
        lesCartesObs.add(carte);
    }

    public void supprimerCarte(Carte carte) {
        lesCartesObs.remove(carte);
    }
}
