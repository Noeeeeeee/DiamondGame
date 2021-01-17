package model.createurs;

import model.Partie;

/**
 * Classe abstraite permettant de créer 2 cartes
 */
public abstract class CreateurCarte {

    public abstract void CreateurCarteDiamant(Partie p);

    public abstract void CreateurCartePiege(Partie p);

}
