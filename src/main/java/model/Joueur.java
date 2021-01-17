package model;

import javafx.event.EventType;
import KeyboardController.ControllerK;

import java.awt.event.KeyEvent;

public class Joueur {
    /**
     * pseudo du Joueur
     */
    private String pseudo;
    /**
     * nombre de diamant du Joueur
     */
    private int nbDiamantsJoueur;
    /**
     * permet de savoir si le joueur est dans la pyramide ou non (true/false)
     */
    private boolean inside;


    /**
     * Constructeur d'un joueur avec son pseudo et son nombre de diamant ainsi que sa position initialisée à true donc dans la pyramide
     * @param pseudo
     * @param nbDiamantsJoueur
     */
    public Joueur (String pseudo, int nbDiamantsJoueur)
    {
        this.pseudo=pseudo;
        this.nbDiamantsJoueur=nbDiamantsJoueur;
        this.inside=true;
    }

    /**
     * retourne la position du joueur
     * @return
     */
    public boolean isInside() {
        return inside;
    }

    public void sortir() throws Exception {
        if(inside){
            inside=false;
            return;
        }
        throw new Exception("Déjà sortie");
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPseudo(){
        return pseudo;
    }

    public void setNbdiamantsjoueur(int nbdiamantsjoueur) {
        this.nbDiamantsJoueur+=nbdiamantsjoueur;
    }

    public int getNbdiamantsjoueur(){
        return nbDiamantsJoueur;
    }

    @Override
    public String toString(){
        return  pseudo + "\nDiamants : "  + nbDiamantsJoueur;
    }

    /**
     * méthode equals qui compare entre deux objets, et ensuite entre deux instances de joueur.
     * @param v
     * @return
     */
    @Override
    public boolean equals(Object v) {
        if (this == v)
            return true;
        if (v == null)
            return false;
        if(getClass() != v.getClass())
            return false;
        //comparaison
        Joueur p = (Joueur)v;
        if(!getPseudo().equals(p.getPseudo()))
            return false;
        if(getNbdiamantsjoueur() != p.getNbdiamantsjoueur()) {
            return false;
        }
        return isInside() == p.isInside();
    }
}
