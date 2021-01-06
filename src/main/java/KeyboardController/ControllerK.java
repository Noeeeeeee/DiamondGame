package KeyboardController;

import model.Joueur;
import model.Partie;
import model.Tour;

import java.awt.event.KeyEvent;

public class ControllerK {

    public void SPressed(KeyEvent e, Joueur j, Tour t) throws Exception {
        if(e.getKeyCode()==KeyEvent.VK_S) {
            Partie.faireSortirJoueur(j,t);
        }
        //prochain joueur
    }

    public void RPressed(KeyEvent e, Joueur j, Tour t) throws Exception {
        if(e.getKeyCode()==KeyEvent.VK_R) {
            //prochain joueur
        }
    }
}
