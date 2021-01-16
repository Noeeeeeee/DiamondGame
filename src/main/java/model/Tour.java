package model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.*;

public class Tour {

    private int nbDiamant;
    private int nbPiege;
    private int nbJoueurs;
    private Joueur j;
    private ObservableList<Joueur> joueursPresents;
    private ObservableList<Joueur> joueurs;
    private ObservableList<Joueur> joueursSortie;
    private Joueur joueurCourant;


    public Tour(int nbJoueurs,ObservableList<Joueur> joueursPresents) throws Exception {
        this.joueursPresents = FXCollections.observableArrayList();
        this.joueurs=FXCollections.observableArrayList();
        this.joueursSortie= FXCollections.observableArrayList();
        this.nbDiamant=0;
        this.nbPiege=0;
        this.nbJoueurs=nbJoueurs;
        joueursPresents.forEach(this.joueursPresents::add);
        joueursPresents.forEach(this.joueurs::add);
        joueurCourant=joueursPresents.get(0);
    }

    public void changerJoueurCourant() {
        if (joueursPresents.isEmpty()){
            System.out.println("tour fini");
        }
        joueurCourant=joueursPresents.iterator().next();
        for (Joueur joueur: joueursSortie) {
            joueur.setNbdiamantsjoueur(nbDiamant/joueursSortie.size());
        }
        if (joueursSortie.size()>0) {
            this.nbDiamant = 0;
        }
        if (joueursSortie.contains(this.j)) {
            joueursSortie.remove(this.j);
        }
        System.out.println("Tout le monde est sortie");
    }

    public void faireSortirJoueur() throws Exception {
        System.out.println(joueursPresents);
        if(joueurCourant.isInside()){
            joueurCourant.sortir();
            joueursSortie.add(joueurCourant);
            joueursPresents.remove(joueurCourant);
            this.j=joueurCourant;
        }
    }


    public void compteurDiamants(CarteDiamant C)
    {
        this.nbDiamant+=C.getDiamants();
    }

    public void sortirCartes()
    {
        Random rand=new Random();
        int r= rand.nextInt(99);
        if (r< 70){
            CarteDiamant c=new CarteDiamant(10,10,"");
            compteurDiamants(c);
        }
        if (r>=70 && r<90){
            CartePiege c=new CartePiege(10, 10, "");
            compteurPiege(c);
        }
        /*if (r>=90){
            CarteTresor c=new CarteTresor(10, 10, "");
            compteurDiamants(c);
        }*/
    }

    public void compteurPiege(Carte C)
    {
        if(C.getClass()==CartePiege.class)
        {
            this.nbPiege += 1;
        }
    }

    public Joueur getJcourant(){
        return joueurCourant;
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
