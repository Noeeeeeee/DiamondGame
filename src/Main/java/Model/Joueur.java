package Model;

public class Joueur {
    private String pseudo;
    private int nbdiamantsjoueur;


    public Joueur (String pseudo, int nbdiamantsjoueur)
    {
        this.pseudo=pseudo;
         this.nbdiamantsjoueur=nbdiamantsjoueur;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPseudo(){
        return pseudo;
    }

    public void setNbdiamantsjoueur(int nbdiamantsjoueur) {
        this.nbdiamantsjoueur = nbdiamantsjoueur;
    }

    public int getNbdiamantsjoueur(){
        return nbdiamantsjoueur;
    }

    public String ToString(){
        return "Mon pseudo est" + pseudo + "et je possède" + nbdiamantsjoueur;
    }
}
