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
    private Tour t;
    private ObservableList<Joueur> lesJoueurs = FXCollections.observableArrayList();;
    private ObservableList<Carte> lesCartesObs = FXCollections.observableArrayList();
    private ListProperty<Carte> lesCartesProp = new SimpleListProperty<>(lesCartesObs);
    private SimpleIntegerProperty nombreTotalDeDiamant = new SimpleIntegerProperty();


    private SimpleIntegerProperty nombreDiamantCourant = new SimpleIntegerProperty();

    public Partie(int nbJoueur, ObservableList<Joueur> j) throws Exception{
        this.nbJoueur=nbJoueur;
        for (Joueur joueur:j) {
            lesJoueurs.add(joueur);
        }
        this.nbPiege=0;
    }

    public void lancerTour() throws Exception {
        t=new Tour(nbJoueur,lesJoueurs);
    }

    public ListProperty<Carte> lesCartesProperty(){return lesCartesProp;}

    public ObservableList<Carte> getLesCartes() {return lesCartesObs;}

    public void ajouterCarteView(Carte c){ lesCartesObs.add(c);}

    public int getNbJoueur() {
        return this.nbJoueur;
    }

    public SimpleIntegerProperty getNombreDiamantCourant() { return nombreDiamantCourant; }


    public void ajouterCarte(Carte carte) {
        lesCartesObs.add(carte);
    }

    @Override
    public String toString(){
        return   " nb joueurs : " + nbJoueur + " joueurs : " + lesJoueurs + " cartes :" +lesCartesObs ;
    }

    public void supprimerCarte(Carte carte) {
        lesCartesObs.remove(carte);
    }

    public Tour getT() {
        return t;
    }

    public void setT(Tour t) {
        this.t = t;
    }

    public SimpleIntegerProperty getNombreTotalDeDiamant() { return nombreTotalDeDiamant; }

    public void compteurDiamant(CarteDiamant c)
    {
        nombreDiamantCourant.setValue(c.getDiamants());
        nombreTotalDeDiamant.set(this.nombreTotalDeDiamant.get() + nombreDiamantCourant.get());
    }



}