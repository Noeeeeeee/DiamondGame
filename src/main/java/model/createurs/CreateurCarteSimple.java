package model.createurs;

import model.*;

public class CreateurCarteSimple extends CreateurCarte {

    @Override
    public void CreateurCarteDiamant(Tour t) {
        t.ajouterCarte(new CarteDiamant(10, 10, "/images/carteDiamant.jpg"));
    }

    @Override
    public void CreateurCartePiege(Tour t){
        t.ajouterCarte(new CartePiege(10, 10, "/images/cartePiege.jpg"));
    }

    @Override
    public void CreateurCarteTresor(Tour t){
        t.ajouterCarte(new CarteTresor(10, 10, "/images/carteTresor.jpg"));
    }
}
