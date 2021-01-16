package model;

import javafx.event.EventType;
import KeyboardController.ControllerK;

import java.awt.event.KeyEvent;

public class Joueur {
    private String pseudo;
    private int nbDiamantsJoueur;
    private boolean inside;
    private boolean aJoue;


    public Joueur (String pseudo, int nbDiamantsJoueur)
    {
        this.pseudo=pseudo;
        this.nbDiamantsJoueur=nbDiamantsJoueur;
        this.inside=true;
    }

    public boolean isInside() {
        return inside;
    }

    public void rentrer() throws Exception {
        if (!inside){
            inside=true;
        }
        throw new Exception("Déjà dedans");
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
