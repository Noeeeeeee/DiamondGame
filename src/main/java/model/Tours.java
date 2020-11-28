package model;

public class Tours {

    public int nbDiamant;
    public int nbPiege;

    public Tours()
    {
        this.nbDiamant=0;
        this.nbPiege=0;
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

    public int getNbDiamant() {return nbDiamant;}

    public int getNbPiege() {return nbPiege;}

    public void setNbDiamant(int nbDiamant) {this.nbDiamant = nbDiamant;}

    public void setNbPiege(int nbPiege) {this.nbPiege = nbPiege;}

    public String ToString(){
        return "Il y a " + nbDiamant + " Diamants à récupérer et " + nbPiege + " Pièges.";
    }
}
