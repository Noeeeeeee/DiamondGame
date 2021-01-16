package boucleur;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.ArrayList;
import java.util.List;

public abstract class Boucleur implements Runnable, Observable {

    private List<InvalidationListener> lesObservateurs = new ArrayList<>();
    protected boolean active = false;

    @Override
    public void addListener(InvalidationListener listener) {
        lesObservateurs.add(listener);

    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        lesObservateurs.remove(listener);

    }

    protected void beep() {
        lesObservateurs.forEach(o -> o.invalidated(this));
    }
}
