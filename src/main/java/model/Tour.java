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
    private int numTour;
    private Joueur j;
    private ObservableList<Joueur> joueursPresents;
    private ObservableList<Joueur> joueurs;
    private ObservableList<Joueur> joueursSortie;


    public Tour(int nbJoueurs,ObservableList<Joueur> joueursPresents) throws Exception {
        this.joueursPresents = FXCollections.observableArrayList();
        this.joueurs=FXCollections.observableArrayList();
        this.joueursSortie= FXCollections.observableArrayList();
        this.nbDiamant=0;
        this.nbPiege=0;
        this.nbJoueurs=nbJoueurs;
        numTour=0;
        joueursPresents.forEach(this.joueursPresents::add);
        joueursPresents.forEach(this.joueurs::add);
    }

    public void faireSortirJoueur(Joueur joueur) throws Exception {
        System.out.println(joueursPresents);
        if(joueur.isInside()){
            joueur.sortir();
            joueursSortie.add(joueur);
            joueursPresents.remove(joueur);
            this.j=joueur;
        }
    }

    public void numTourAdd(){
        for(Joueur joueur:joueursSortie){
            joueur.setNbdiamantsjoueur(nbDiamant/joueursSortie.size());
        }
        if(joueursSortie.size()>0){
            this.nbDiamant=0;
        }
        joueursSortie.removeAll();
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

    public int getNbDiamant() {return nbDiamant;}

    public int getNbPiege() {return nbPiege;}

    public void setNbDiamant(int nbDiamant) {this.nbDiamant = nbDiamant;}

    public void setNbPiege(int nbPiege) {this.nbPiege = nbPiege;}

    @Override
    public String toString(){
        return "Il y a " + nbDiamant + " Diamants à récupérer et " + nbPiege + " Pièges ainsi que " + nbJoueurs + " joueurs restants" ;
    }


}
