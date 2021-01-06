package model;

public class CarteTresor extends Carte{
    public final int nbdiamant=15;

    public CarteTresor(double x, double y, String image) {
        super(x, y, image);
    }


    public int getDiamants() {
        return this.nbdiamant;
    }
}
