package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class Carte {

    /**
     * image héritée pour les classes filles
     */
    protected String image;
    /**
     * hauteur max de la carte
     */
    protected int maxHeight = 300;
    /**
     * largeur max de la carte
     */
    protected int maxWidth = 375;

    /**
     *
     */
    protected DoubleProperty x = new SimpleDoubleProperty();
        public double getX()
        {
            return getX();
        }

    /**
     * permet de récupérer la
     * @return
     */
    public DoubleProperty xProperty()
    {
        return x;
    }
    public void setX(double x)
    {
        this.x.set(x);
    }

    /**
     *
     */
    protected DoubleProperty y = new SimpleDoubleProperty();
        public double getY()
        {
            return y.get();
        }
        public DoubleProperty yProperty()
        {
            return y;
        }
        public void setY(double y){
            this.y.set(y);
        }

    /**
     * Constructeur de Carte comprenant l'image ainsi que sa position passé en paramètre
     * @param x
     * @param y
     * @param image
     */
    public Carte(double x, double y, String image) {

        this.x.set(x);
        this.y.set(y);
        this.image =image;

    }

    /**
     * retourne un string pour récupérer l'image
     * @return
     */
    public String getImage() {
        return image;
    }

    /**
     * retourne la hauteur
     * @return
     */
    public int getMaxHeight() {
        return maxHeight;
    }

    /**
     * retourne la largeur
     * @return
     */
    public int getMaxWidth() {
        return maxWidth;
    }
}
