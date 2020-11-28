package model;

public class Joueur {
    private String pseudo;
    private int nbDiamantsJoueur;


    public Joueur (String pseudo, int nbDiamantsJoueur)
    {
        this.pseudo=pseudo;
         this.nbDiamantsJoueur=nbDiamantsJoueur;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPseudo(){
        return pseudo;
    }

    public void setNbdiamantsjoueur(int nbdiamantsjoueur) {
        this.nbDiamantsJoueur = nbdiamantsjoueur;
    }

    public int getNbdiamantsjoueur(){
        return nbDiamantsJoueur;
    }

    public String ToString(){
        return "Mon pseudo est" + pseudo + "et je possède" + nbDiamantsJoueur;
    }
}
