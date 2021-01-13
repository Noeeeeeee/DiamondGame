package KeyboardController;

import model.Joueur;
import model.Partie;
import model.Tour;

import java.awt.event.KeyEvent;

public class ControllerK {

    public void SPressed(KeyEvent e, Joueur j,Partie p)throws Exception {
        try {
            if (e.getKeyCode() == KeyEvent.VK_S) {
                p.faireSortirJoueur(j);
            }
        }catch(Exception e1) {
                throw e1;
            }
    }

    public void RPressed(KeyEvent e, Joueur j) throws Exception {
        if(e.getKeyCode()==KeyEvent.VK_R ) {
            //prochain joueur
        }
    }
}
