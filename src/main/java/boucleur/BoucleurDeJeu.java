package boucleur;

public class BoucleurDeJeu extends Boucleur{

    @Override
    public void run() {
        while (active)
            beep();
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            active = false;
        }
    }
}
