package uni.mosey.bankatm.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    @FXML
    private Label balanceLabel;
    @FXML
    private TextField depositNum;
    @FXML
    private TextField withdrawNum;
    double initialBalance;
    private double currentBalance;

    private final AccountManager accountManager = AccountManager.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String loggedInUsername = DataSingleton.getInstance().getUsername();
        BankAccount loggedInAccount = accountManager.getAccountMap().get(loggedInUsername);
        String loggedInName = loggedInAccount.getName();
        greetingLabel.setText("Welcome back, " + loggedInName);
        // Retrieve the initial balance from the loggedInAccount
        initialBalance = loggedInAccount.getInitialBalance();
        // Set the text of the balanceLabel to show the initial balance
        balanceLabel.setText(String.valueOf(initialBalance));
    }

    public void depositClick(ActionEvent e) {
        // Check if currentBalance is initialized, if not, initialize it with the initial balance
        if (currentBalance == 0.0) {
            currentBalance = initialBalance;
        }

        // Gets the deposit amount from the textfield and parses it as a double
        double depositAmount = Double.parseDouble(depositNum.getText());

        // Add the deposit amount to the current balance
        currentBalance += depositAmount;

        // Update the label to display the new balance
        balanceLabel.setText(String.valueOf(currentBalance));

        // Clear the textfield for the next transaction
        depositNum.clear();
    }

    public void withdrawClick(ActionEvent e) {
        // Check if currentBalance is initialized, if not, initialize it with the initial balance
        if (currentBalance == 0.0) {
            currentBalance = initialBalance;
        }

        // Gets the deposit amount from the textfield and parses it as a double
        double withdrawAmount = Double.parseDouble(withdrawNum.getText());

        // Subtract the withdraw amount from the current balance
        currentBalance -= withdrawAmount;

        // Update the label to display the new balance
        balanceLabel.setText(String.valueOf(currentBalance));
    }

    @FXML
    void userLogout() throws IOException {
        new SceneSwitch(dashboardAnchorPane, "view/logout-page.fxml");
    }
}
