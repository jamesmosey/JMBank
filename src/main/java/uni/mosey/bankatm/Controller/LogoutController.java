package uni.mosey.bankatm.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uni.mosey.bankatm.Model.SceneSwitch;

import java.io.IOException;

public class LogoutController {

    @FXML
    private Button cancelBtn;
    @FXML
    private Button signOutBtn;
    @FXML
    private Button signOutExitBtn;
    @FXML
    private AnchorPane logoutAnchorPane;

    Stage stage;

    @FXML   // Uses SceneSwitch to change the scene to the login page when sign out is clicked
    void userSignOut() throws IOException {
        new SceneSwitch(logoutAnchorPane, "view/login-page.fxml");
    }

    @FXML   // Closes the application when the quit button is clicked
    void userSignOutQuit(ActionEvent event) throws IOException {
        stage = (Stage) logoutAnchorPane.getScene().getWindow();
        stage.close();
    }

    @FXML   // Uses SceneSwitch to change the current scene back to the dashboard
    void cancelSignOut() throws IOException {
        new SceneSwitch(logoutAnchorPane, "view/dashboard.fxml");
    }

}
