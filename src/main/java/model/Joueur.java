package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.EventType;
import KeyboardController.ControllerK;

import java.awt.event.KeyEvent;

public class Joueur {
    /**
     * pseudo du Joueur
     */
    private StringProperty pseudo = new SimpleStringProperty();
    public StringProperty pseudoProperty()
    {
        return pseudo;
    }

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
     */
    public Joueur (String pseudo)
    {
        this.pseudo.setValue(pseudo);
        this.inside=true;
        nbDiamantsJoueur=0;
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

    /**
     * Set le pseudo d'un joueur
     * @param pseudo
     */
    public void setPseudo(String pseudo) {
        this.pseudo.setValue(pseudo);
    }

    /**
     * Recupere le pseudo d'un joueur
     * @return le pseudo du joueur
     */
    public String getPseudo() {
        return pseudo.get();
    }

    /**
     * Set le nombre de diamants par joueur
     * @param nbdiamantsjoueur
     */
    public void setNbdiamantsjoueur(int nbdiamantsjoueur) {
        this.nbDiamantsJoueur+=nbdiamantsjoueur;
    }

    /**
     * Recupere le nombreDeDiamant d'un joueur
     * @return le nombre de diamants du joueur
     */
    public int getNbdiamantsjoueur(){
        return nbDiamantsJoueur;
    }

    @Override
    public String toString(){
        return  getPseudo() + "\nDiamants : "  + nbDiamantsJoueur;
    }

    /**
     * méthode equals qui compare entre deux objets, et ensuite entre deux instances de joueur.
     * @param v
     * @return un booléen
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
