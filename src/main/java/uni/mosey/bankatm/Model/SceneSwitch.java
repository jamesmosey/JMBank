package uni.mosey.bankatm.Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import uni.mosey.bankatm.Main;

import java.io.IOException;
import java.util.Objects;

public class SceneSwitch {

    /***
     * This constructor allows for the switching of scenes in this JavaFX application. Takes the current AnchorPane
     * and loads the new FXML file in its place.
     * @param currentAnchorPane The current AnchorPane being displayed.
     * @param fxml Stores the filename of the FXML file which is to be displayed next.
     * @throws IOException Input/output exception is thrown in the case that there is an issue with the FXML file.
     */
    public SceneSwitch(AnchorPane currentAnchorPane, String fxml) throws IOException {
        // Retrieves and loads data from the chosen FXML file
        AnchorPane nextAnchorPane = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(fxml)));
        // Removes the old scene and sets the new one
        currentAnchorPane.getChildren().removeAll();
        currentAnchorPane.getChildren().setAll(nextAnchorPane);
    }
}
