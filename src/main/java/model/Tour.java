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
    private ObservableList<Joueur> joueursPresents;





    public Tour(int nbJoueurs,ObservableList<Joueur> joueursPresents)
    {
        this.joueursPresents = FXCollections.observableArrayList();
        this.nbDiamant=0;
        this.nbPiege=0;
        this.nbJoueurs=nbJoueurs;
        joueursPresents.forEach(this.joueursPresents::add);
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
    public void sortieJoueur(Joueur j) throws Exception {
        try {
            j.sortir();
            this.joueursPresents.remove(j);
            nbJoueurs-=1;
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
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
