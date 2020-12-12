package model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Tours {

    private int nbDiamant;
    private int nbPiege;
    private int nbJoueurs;
    private ObservableList<Joueur> joueurs;

    public Tours(int nbJoueurs,ObservableList<Joueur> joueurs)
    {
        this.joueurs = FXCollections.observableArrayList();
        this.nbDiamant=0;
        this.nbPiege=0;
        this.nbJoueurs=nbJoueurs;
        joueurs.forEach(this.joueurs::add);
    }

    public void compteurDiamants(Carte C)
    {
        this.nbDiamant+=C.getDiamants();
    }

    public void sortirCartes()
    {
        Carte c= new Carte();
    }

    public void compteurPiege(Carte C)
    {
        if(C.getClass()==CartePiege.class)
        {
            this.nbPiege += 1;
        }
    }
    public void sortieJoueur(Joueur j) throws Exception {
        try {
            j.sortir();
            this.joueurs.remove(j);
            nbJoueurs-=1;
        }
        catch (Exception e) {
            throw new Exception("Erreur sortie");
        }

    }

    public int getNbDiamant() {return nbDiamant;}

    public int getNbPiege() {return nbPiege;}

    public void setNbDiamant(int nbDiamant) {this.nbDiamant = nbDiamant;}

    public void setNbPiege(int nbPiege) {this.nbPiege = nbPiege;}

    @Override
    public String toString(){
        return "Il y a " + nbDiamant + " Diamants à récupérer et " + nbPiege + " Pièges ainsi que " + nbJoueurs + " joueurs restants" ;
    }
}
