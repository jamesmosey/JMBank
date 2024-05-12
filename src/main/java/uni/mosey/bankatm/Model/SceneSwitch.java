package uni.mosey.bankatm.Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import uni.mosey.bankatm.Main;

import java.io.IOException;
import java.util.Objects;

public class SceneSwitch {

    public SceneSwitch(AnchorPane currentAnchorPane, String fxml) throws IOException {
        // Retrieves and loads data from the chosen FXML file
        AnchorPane nextAnchorPane = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(fxml)));
        // Removes the old scene and sets the new one
        currentAnchorPane.getChildren().removeAll();
        currentAnchorPane.getChildren().setAll(nextAnchorPane);
    }
}
