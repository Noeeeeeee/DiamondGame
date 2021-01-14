package boucleur;

public class BoucleurDeJeu extends Boucleur{

    @Override
    public void run() {
        while (running)
            beep();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            running = false;
        }
    }
}
