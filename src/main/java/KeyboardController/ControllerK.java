package KeyboardController;


import javafx.scene.Scene;
import manager.GameManager;
import model.Joueur;

import java.util.jar.JarEntry;

public class ControllerK {

    public void initializeInputControls(Scene scene)throws Exception {
        scene.setOnKeyPressed(e -> {
            if (e.getCode().toString().equalsIgnoreCase("s")) {
                try {
                    GameManager.getInstance().faireSortirJoueur();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
}
