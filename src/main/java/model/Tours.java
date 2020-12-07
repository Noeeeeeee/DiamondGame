package model;

import java.util.List;

public class Tours {

    private int nbDiamant;
    private int nbPiege;
    private static int nbJoueurs;
    private List<Joueur> joueurs;

    public Tours(List<Joueur> joueurs)
    {
        this.nbDiamant=0;
        this.nbPiege=0;
        joueurs.forEach(joueur -> {
            this.joueurs.add(joueur);
        });
    }

    public void compteurDiamants(Carte C)
    {
        this.nbDiamant+=C.getDiamants();
    }

    public void sortirCartes()
    {
        Carte c= new Carte();
    }

    public void compteurPiege(Carte C)
    {
        if(C.getClass()==CartePiege.class)
        {
            this.nbPiege += 1;
        }
    }
    public static void sortieJoueur(Joueur j) throws Exception {
        j.sortir();
        nbJoueurs-=1;
    }

    public int getNbDiamant() {return nbDiamant;}

    public int getNbPiege() {return nbPiege;}

    public void setNbDiamant(int nbDiamant) {this.nbDiamant = nbDiamant;}

    public void setNbPiege(int nbPiege) {this.nbPiege = nbPiege;}

    public String ToString(){
        return "Il y a " + nbDiamant + " Diamants à récupérer et " + nbPiege + " Pièges.";
    }
}
