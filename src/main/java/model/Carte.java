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
     *instancie la doubleProperty x
     */
    protected DoubleProperty x = new SimpleDoubleProperty();

    /**
     * Retourne la position x
     * @return
     */
    public double getX()
        {
            return getX();
        }

    /**
     * permet de récupérer la position x pour le binding
     * @return la position x
     */
    public DoubleProperty xProperty()
    {
        return x;
    }

    /**
     * Setter de la position x
     * @param x
     */
    public void setX(double x)
    {
        this.x.set(x);
    }

    /**
     *instancie la position y
     */
    protected DoubleProperty y = new SimpleDoubleProperty();

    /**
     * Recupere la position y
     * @return la position y
     */
    public double getY()
        {
            return y.get();
        }

    /**
     * Recupere la position y pour le binding
     * @return la position y
     */
    public DoubleProperty yProperty()
        {
            return y;
        }

    /**
     * Setter de la position y
     * @param y
     */
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
     * @return le chemin image
     */
    public String getImage() {
        return image;
    }

    /**
     * retourne la hauteur
     * @return la taille max
     */
    public int getMaxHeight() {
        return maxHeight;
    }

    /**
     * retourne la largeur
     * @return la largeur max
     */
    public int getMaxWidth() {
        return maxWidth;
    }
}
