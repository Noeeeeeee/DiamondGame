package boucleur;

public class BoucleurDeJeu extends Boucleur{

    @Override
    public void run() {
        while (active)
            beep();
        try {
            Thread.sleep(20000);
        }
        catch (InterruptedException e) {
            active = false;
        }
    }
}
