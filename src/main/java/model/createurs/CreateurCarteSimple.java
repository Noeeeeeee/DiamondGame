package model.createurs;

import model.*;

import java.util.Random;

/**
 * Classe permettant de créer 2 cartes et de les ajouter dans notre liste de cartes
 */
public class CreateurCarteSimple extends CreateurCarte {
    Random rand=new Random();

    /**
     * Méthode permettant d'ajouter une nouvelle carte diamant
     * @param p
     */
    @Override
    public void CreateurCarteDiamant(Partie p) {
        p.ajouterCarte(new CarteDiamant(rand.nextInt(100),rand.nextInt(100), "/img/carteDiamant.png"));
    }

    /**
     * Méthode permettant d'ajouter une nouvelle carte piège
     * @param p
     */
    @Override
    public void CreateurCartePiege(Partie p){
        p.ajouterCarte(new CartePiege(10, 10, "/img/cartePiege.png"));
    }
}
