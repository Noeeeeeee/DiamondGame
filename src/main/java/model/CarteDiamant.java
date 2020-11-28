package model;

public class CarteDiamant extends Carte{
    public int nbDiamant;

    public void setNbDiamant(int nbDiamant) {this.nbDiamant = nbDiamant;}

    public int getNbDiamant() {return nbDiamant;}

    @Override
    public int getDiamants() {
        //Random rand=new Random(15);
        //return rand;
        return 0;
    }
}
