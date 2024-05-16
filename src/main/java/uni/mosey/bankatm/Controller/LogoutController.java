package uni.mosey.bankatm.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uni.mosey.bankatm.Model.SceneSwitch;

import java.io.IOException;

public class LogoutController {

    public Label signoutLabel;
    public Button signOutBtn;
    public Button signOutExitBtn;
    public Button cancelBtn;
    @FXML
    private AnchorPane logoutAnchorPane;

    Stage stage;

    /***
     * Assigned to the sign-out button, uses the SceneSwitch model to change the scene back to the login scene,
     * if the user chooses to sign out but NOT quit.
     * @throws IOException Input/output exception is thrown in the case that there is an issue with the FXML file.
     */
    @FXML   // Uses SceneSwitch to change the scene to the login page when sign out is clicked
    void userSignOut() throws IOException {
        new SceneSwitch(logoutAnchorPane, "view/login-page.fxml");
    }

    /***
     * Assigned to the sign-out and quit button, closes the stage and exits the application.
     */
    @FXML   // Closes the application when the quit button is clicked
    void userSignOutQuit() {
        stage = (Stage) logoutAnchorPane.getScene().getWindow();
        stage.close();
    }

    /***
     * Assigned to the cancel button, changes the scene back to the dashboard.
     * @throws IOException Input/output exception is thrown in the case that there
     *                     is an issue with the FXML file.
     */
    @FXML   // Uses SceneSwitch to change the current scene back to the dashboard
    void cancelSignOut() throws IOException {
        new SceneSwitch(logoutAnchorPane, "view/dashboard.fxml");
    }

}
