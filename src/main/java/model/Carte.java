package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class Carte {

    protected String image; //propriété héritée pour les classes filles
    protected int maxHeight = 300;
    protected int maxWidth = 375;


    protected DoubleProperty x = new SimpleDoubleProperty();
        public double getX()
        {
            return getX();
        }

    public DoubleProperty xProperty()
    {
        return x;
    }
    public void setX(double x)
    {
        this.x.set(x);
    }

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

    public Carte(double x, double y, String image) {

        this.x.set(x);
        this.y.set(y);
        this.image =image;

    }

    public String getImage() {
        return image;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getMaxWidth() {
        return maxWidth;
    }
}
