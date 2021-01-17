package KeyboardController;


import javafx.scene.Scene;
import javafx.stage.Stage;
import manager.GameManager;
import model.Joueur;

import java.util.jar.JarEntry;

/**
 * Classe du keyboardController
 */
public class ControllerK {

    public void initializeInputControls(Scene scene)throws Exception {
        scene.setOnKeyPressed(e -> {
            if (e.getCode().toString().equalsIgnoreCase("q")) {
                Stage stage = (Stage) scene.getWindow();
                stage.close();
            }
        });
    }
}
