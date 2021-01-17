package model;

import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Partie {
    private final int nbJoueur;
    private int nbPiege;
    private ObservableList<Joueur> lesJoueurs = FXCollections.observableArrayList();;
    private ObservableList<Carte> lesCartesObs = FXCollections.observableArrayList();
    private ListProperty<Carte> lesCartesProp = new SimpleListProperty<>(lesCartesObs);
    private SimpleIntegerProperty nombreTotalDeDiamant = new SimpleIntegerProperty();


    private SimpleIntegerProperty nombreDiamantCourant = new SimpleIntegerProperty();

    /**
     * Creer une partie avec 0 piege et des joueurs en paramètre
     * @param nbJoueur
     * @param j
     * @throws Exception
     */
    public Partie(int nbJoueur, ObservableList<Joueur> j) throws Exception{
        this.nbJoueur=nbJoueur;
        for (Joueur joueur:j) {
            lesJoueurs.add(joueur);
        }
        this.nbPiege=0;
    }

    public void faireSortirJoueur(Joueur j) throws Exception {
        j.sortir();
    }

    public ListProperty<Carte> lesCartesProperty(){return lesCartesProp;}

    public ObservableList<Carte> getLesCartes() {return lesCartesObs;}

    public SimpleIntegerProperty getNombreDiamantCourant() { return nombreDiamantCourant; }


    public void ajouterCarte(Carte carte) {
        lesCartesObs.add(carte);
    }

    @Override
    public String toString(){
        return   " nb joueurs : " + nbJoueur + " joueurs : " + lesJoueurs + " cartes :" +lesCartesObs ;
    }

    public SimpleIntegerProperty getNombreTotalDeDiamant() { return nombreTotalDeDiamant; }

    public void compteurDiamant(CarteDiamant c)
    {
        nombreDiamantCourant.setValue(c.getDiamants());
        nombreTotalDeDiamant.set(this.nombreTotalDeDiamant.get() + nombreDiamantCourant.get());
    }
}