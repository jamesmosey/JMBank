package uni.mosey.bankatm.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import uni.mosey.bankatm.Model.DataSingleton;
import uni.mosey.bankatm.Model.SceneSwitch;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private AnchorPane dashboardAnchorPane;
    @FXML
    private Label greetingLabel;

    /* Gets the username that was input on the login page and
    stores it in the variable 'data', so it can then be displayed
    with a welcome message */
    DataSingleton data = DataSingleton.getInstance();
    public void initialize(URL url, ResourceBundle resourceBundle) {
        greetingLabel.setText("Welcome back, " + data.getUsername());
    }

    @FXML   // Uses SceneSwitch to change to logout page when logout button is clicked
    void userLogout() throws IOException {
        new SceneSwitch(dashboardAnchorPane, "view/logout-page.fxml");
    }

}
