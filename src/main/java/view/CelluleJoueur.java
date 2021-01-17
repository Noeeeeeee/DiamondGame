package view;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import model.Joueur;


    public class CelluleJoueur extends ListCell<Joueur> {

        @Override
        protected void updateItem(Joueur item, boolean empty) {
            super.updateItem(item, empty);
            if(item !=null)
            {
                HBox container = new HBox();

                Label lb = new Label();
                lb.textProperty().bind(item.pseudoProperty());
                container.getChildren().add(lb);
                setGraphic(container);
            }
            else
            {
                setGraphic(null);
            }

        }
}
