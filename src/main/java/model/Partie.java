package model;

import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class Partie {
    private final int nbJoueur;
    private int nbDiamant;
    private int nbPiege;
    private ObservableList<Joueur> lesJoueurs;
    private ObservableList<Carte> lesCartesObs = FXCollections.observableArrayList();
    private ListProperty<Carte> lesCartesProp = new SimpleListProperty<>(lesCartesObs);

    public Partie(int nbJoueur, ObservableList<Joueur> j) throws Exception{
        this.nbJoueur=nbJoueur;
        lesJoueurs=new SimpleListProperty<>(j);
        this.nbDiamant=0;
        this.nbPiege=0;
    }

    public void faireSortirJoueur(Joueur j) throws Exception {
        try {
            if(j.isInside()){
                j.sortir();
            }
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void sortirCartes()
    {
        Random rand=new Random();
        int r= rand.nextInt(99);
        if (r< 95){
            CarteDiamant c=new CarteDiamant(10,10,"");
            compteurDiamants(c);
            lesCartesObs.add(c);
        }
        if (r>=95){
            CartePiege c=new CartePiege(10, 10, "");
            this.nbPiege=1;
            lesCartesObs.add(c);
        }
    }

    public ListProperty<Carte> lesCartesProperty(){return lesCartesProp;}

    public ObservableList<Carte> getLesCartes() {return lesCartesObs;}

    public void ajouterCarteView(Carte c){ lesCartesObs.add(c);}

    public int getNbJoueur() {
        return this.nbJoueur;
    }

    public void compteurDiamants(CarteDiamant C) {this.nbDiamant+=C.getDiamants();}

    public int getNbDiamant() {return nbDiamant;}

    public void setNbDiamant(int nbDiamant) {this.nbDiamant = nbDiamant;}


    public void ajouterCarte(Carte carte) {
        lesCartesObs.add(carte);
    }

    @Override
    public String toString() {
        return  "nb diamants: "+ nbDiamant + " nb joueurs : " + nbJoueur + " joueurs : " + lesJoueurs + " cartes :" +lesCartesObs ;
    }


}
