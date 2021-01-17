package boucleur;

        import javafx.application.Platform;
        import javafx.beans.InvalidationListener;
        import javafx.beans.Observable;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Classe abstraite contenant les méthode pour le boucleur
 */
public abstract class Boucleur implements Runnable, Observable {

    /**
     * liste des objets pour boucler
     */
    private List<InvalidationListener> mesObservateurs = new ArrayList<>();
    /**
     * Valeur boolean permettant à la boucle de tourner
     */
    protected boolean running = false;

    /**
     * Méthode permettant de lancer ou arrêter le boucleur
     * @param running
     */
    public void setActive(boolean running) {
        this.running = running;
    }

    /**
     * Ajout dans la liste d'objets qui pourront executer une méthode en boucle
     * @param invalidationListener
     */
    @Override
    public void addListener(InvalidationListener invalidationListener) {
        mesObservateurs.add(invalidationListener);

    }

    /**
     * Supprime à la liste d'objets qui pourront executer une méthode en boucle
     * @param invalidationListener
     */
    @Override
    public void removeListener(InvalidationListener invalidationListener) {
        mesObservateurs.remove(invalidationListener);

    }

    /**
     * Méthode qui sera appelée en boucle dans les classes filles
     */
    protected void beep() {

        mesObservateurs.forEach(o -> Platform.runLater(()-> o.invalidated(this))); //Faire tourner dans le thread principal

    }

}
