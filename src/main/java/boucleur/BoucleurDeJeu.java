package boucleur;

/**
 * Classe qui hérite de boucleur, instanciable
 */
public class BoucleurDeJeu extends Boucleur{

    /**
     * Exécute une méthode en boucleur avec un délai d'attente entre chaque exécution
     */
    @Override
    public void run() {
        while (running) {
            beep();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }
}

