package model.createurs;

import model.*;

import java.util.Random;

public class CreateurCarteSimple extends CreateurCarte {
    Random rand=new Random();
    @Override
    public void CreateurCarteDiamant(Partie p) {
        p.ajouterCarte(new CarteDiamant(rand.nextInt(100),rand.nextInt(100), "/img/carteDiamant.png"));
    }

    @Override
    public void CreateurCartePiege(Partie p){
        p.ajouterCarte(new CartePiege(10, 10, "/img/cartePiege.png"));
    }
}
