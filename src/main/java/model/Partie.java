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

/**
 * Classe Partie qui représente notre partie
 */
public class Partie {
    /**
     * Nombre de joueurs dans la partie
     */
    private final int nbJoueur;
    /**
     * Liste Observable de nos joueurs dans la partie
     */
    private ObservableList<Joueur> lesJoueurs = FXCollections.observableArrayList();
    /**
     * Liste observable de notre liste de cartes
     */
    private ObservableList<Carte> lesCartesObs = FXCollections.observableArrayList();
    /**
     * Nombre total de Diamant dans la partie
     */
    private SimpleIntegerProperty nombreTotalDeDiamant = new SimpleIntegerProperty();

    private ListProperty<Carte> lesCartesProp = new SimpleListProperty<>(lesCartesObs);
    /**
     * Nombre de diamant d'une carte
     */
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
    }

    /**
     * Méthode permettant de faire sortir un joueur de la partie
     * @param j
     * @throws Exception
     */
    public void faireSortirJoueur(Joueur j) throws Exception {
        j.sortir();
    }

    /**
     * recupere la liste des cartes
     * @return la liste des cartes
     */
    public ObservableList<Carte> getLesCartes() {return lesCartesObs;}

    /**
     * Recupere nombreDeDiamant d'une carte
     * @return le nombre de diamant d'une carte
     */
    public SimpleIntegerProperty getNombreDiamantCourant() { return nombreDiamantCourant; }

    /**
     * Méthode permettant d'ajouter une carte dans la liste des cartes
     * @param carte
     */
    public void ajouterCarte(Carte carte) {
        lesCartesObs.add(carte);
    }

    @Override
    public String toString(){
        return   " nb joueurs : " + nbJoueur + " joueurs : " + lesJoueurs + " cartes :" +lesCartesObs ;
    }

    /**
     * Recupere le nombreTotalDeDiamant d'une partie
     * @return le nombre total de diamant d'une partie
     */
    public SimpleIntegerProperty getNombreTotalDeDiamant() { return nombreTotalDeDiamant; }

    /**
     * Méthode permettant de compter le nombre total de diamant dans une partie
     * @param c
     */
    public void compteurDiamant(CarteDiamant c)
    {
        nombreDiamantCourant.setValue(c.getDiamants());
        nombreTotalDeDiamant.set(this.nombreTotalDeDiamant.get() + nombreDiamantCourant.get());
    }
}