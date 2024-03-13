package uni.mosey.bankatm.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import uni.mosey.bankatm.Model.AccountManager;
import uni.mosey.bankatm.Model.BankAccount;
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

    private final AccountManager accountManager = AccountManager.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String loggedInUsername = DataSingleton.getInstance().getUsername();
        BankAccount loggedInAccount = accountManager.getAccountMap().get(loggedInUsername);
        String loggedInName = loggedInAccount.getName();
        greetingLabel.setText("Welcome back, " + loggedInName);
    }

    @FXML
    void userLogout() throws IOException {
        new SceneSwitch(dashboardAnchorPane, "view/logout-page.fxml");
    }
}
