package model;

public class Joueur {
    private String pseudo;
    private int nbDiamantsJoueur;
    private boolean inside;


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
        this.nbDiamantsJoueur = nbdiamantsjoueur;
    }

    public int getNbdiamantsjoueur(){
        return nbDiamantsJoueur;
    }

    @Override
    public String toString(){
        return  pseudo + "\nDiamants : "  + nbDiamantsJoueur;
    }
}
