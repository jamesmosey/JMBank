package uni.mosey.bankatm.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

    public Button fourBtn;
    public Button logoutbtn;
    public Button depositbtn;
    public Button withdrawbtn;
    public Button oneBtn;
    public Button twoBtn;
    public Button threeBtn;
    public Button fiveBtn;
    public Button sixBtn;
    public Button sevenBtn;
    public Button nineBtn;
    public Button eightBtn;
    public Button zeroBtn;
    public Button clearbtn;
    public Button dotBtn;
    @FXML
    private AnchorPane dashboardAnchorPane;
    @FXML
    private Label greetingLabel;
    @FXML
    private Label balanceLabel;
    @FXML
    private Label msgLabel;
    @FXML
    private TextField inputField;
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
        // Format the initial balance to display with two decimal places
        String formattedBalance = String.format("%.2f", initialBalance);
        // Set the text of the balanceLabel to show the formatted initial balance
        balanceLabel.setText(formattedBalance);
    }

    public void depositClick() {
        // Check if currentBalance is initialized, if not, initialize it with the initial balance
        if (currentBalance == 0.0) {
            currentBalance = initialBalance;
        }
        // Check to make sure the input field is not blank
        String inputText = inputField.getText();
        if (inputText.isEmpty()) {
            msgLabel.setText("You must enter an amount to deposit.");
            return;
        }
        // Gets the deposit amount from the text field and parses it as a double
        double depositAmount = Double.parseDouble(inputField.getText());
        // Add the deposit amount to the current balance
        currentBalance += depositAmount;
        // Update the label to display the new balance with two decimal places
        balanceLabel.setText(String.format("%.2f", currentBalance));
        // Let the user know the deposit was successful, limited to 2 decimal places
        msgLabel.setText("Your deposit of £" + String.format("%.2f", depositAmount) + " was successful!");
        // Clear the text field for the next transaction
        inputField.clear();
    }

    public void withdrawClick() {
        // Check if currentBalance is initialized, if not, initialize it with the initial balance
        if (currentBalance == 0.0) {
            currentBalance = initialBalance;
        }
        // Check to make sure the input field is not blank
        String inputText = inputField.getText();
        if (inputText.isEmpty()) {
            msgLabel.setText("You must enter an amount to withdraw.");
            return;
        }
        // Gets the deposit amount from the text field and parses it as a double
        double withdrawAmount = Double.parseDouble(inputField.getText());
        // Check if withdrawal amount is greater than the current balance
        if (withdrawAmount > currentBalance) {
            // Tells the user they have insufficient funds and ends the transaction
            msgLabel.setText("Insufficient funds.");
            inputField.clear();
            return;
        }
        // Subtract the withdrawal amount from the current balance
        currentBalance -= withdrawAmount;
        // Update the label to display the new balance with two decimal places
        balanceLabel.setText(String.format("%.2f", currentBalance));
        // Let the user know the deposit was successful, limited to 2 decimal places
        msgLabel.setText("Your withdrawal of £" + String.format("%.2f", withdrawAmount) + " was successful!");
        // Clear the text field for the next transaction
        inputField.clear();
    }

    @FXML
    private void dashboardNumberButton(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();

        String currentText = inputField.getText();

        // Check if the current text already contains a decimal point
        if (!currentText.contains(".") || !buttonText.equals(".")) {
            // Append the button text to the input field
            inputField.setText(currentText + buttonText);
        } else {
            // Let the user know only 1 decimal place is allowed
            msgLabel.setText("Only 1 decimal place can be used.");
        }
    }

    @FXML
    private void clearInputField() {
        inputField.clear();
    }

    @FXML
    void userLogout() throws IOException {
        new SceneSwitch(dashboardAnchorPane, "view/logout-page.fxml");
    }
}
