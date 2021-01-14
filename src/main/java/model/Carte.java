package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;

public abstract class Carte {

    protected String image;

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


    @Override
    public boolean equals(Object v) {
        if (this == v)
            return true;
        if (v == null)
            return false;
        if(getClass() != v.getClass())
            return false;
        //comparaison
       Carte c = (Carte)v;
        if(!c.getImage().equals(this.getImage()))
            return false;
        else
            return true;
    }

}
