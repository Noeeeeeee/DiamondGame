package model;

public class Joueur {
    private String pseudo;
    private int nbDiamantsJoueur;
    private static boolean inside;


    public Joueur (String pseudo, int nbDiamantsJoueur)
    {
        this.pseudo=pseudo;
        this.nbDiamantsJoueur=nbDiamantsJoueur;
        this.inside=false;
    }

    public boolean isInside() {
        return inside;
    }
    public static void rentrer() throws Exception {
        if (inside){
            throw new Exception("Déjà dedans");
        }
        inside=true;
    }
    public static void sortir() throws Exception {
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

    public String ToString(){
        return "Mon pseudo est" + pseudo + "et je possède" + nbDiamantsJoueur;
    }
}
