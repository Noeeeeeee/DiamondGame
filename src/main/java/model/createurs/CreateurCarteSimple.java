package model.createurs;

import model.*;

public class CreateurCarteSimple extends CreateurCarte {

    @Override
    public void CreateurCarteDiamant(Partie p) {
        p.ajouterCarte(new CarteDiamant(100, 10, "/img/carteDiamant.jpg"));
    }

    @Override
    public void CreateurCartePiege(Partie p){
        p.ajouterCarte(new CartePiege(10, 10, "/img/cartePiege.png"));
    }

    @Override
    public void CreateurCarteTresor(Partie p){
        p.ajouterCarte(new CarteTresor(10, 10, "/img/carteTresor.jpg"));
    }
}

