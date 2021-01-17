package model;

import java.util.Random;

public class CarteDiamant extends Carte{
    public CarteDiamant(double x, double y, String image) {
        super(x, y, image);
    }


    /**
     * methode qui génère un nombre de diamants aléatoire entre 1 et 15
     * @return
     */
    public int getDiamants() {
        Random rand=new Random();
        int r= rand.nextInt(15)+1;
        return r;
    }
}
