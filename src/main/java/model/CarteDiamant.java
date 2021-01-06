package model;

import java.util.Random;

public class CarteDiamant extends Carte{
    public int nbDiamant;

    public void setNbDiamant(int nbDiamant) {this.nbDiamant = nbDiamant;}

    public int getNbDiamant() {return nbDiamant;}

    public int getDiamants() {
        Random rand=new Random();
        int r= rand.nextInt(15)+1;
        return r;
    }
}
