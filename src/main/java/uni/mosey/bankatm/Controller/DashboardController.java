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

    /***
     * Initialises the UI elements with the currently logged-in user's information (name + initial balance),
     * as well as disallowing keyboard input into the input field, forcing button use only.
     * @param url Represents the location of the FXML file associated with this controller class.
     * @param resourceBundle Inherited parameter from the 'Initializable' interface, used to provide
     *                       localised versions of text and resource. Unused in this method.
     */
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
        // Disallows keyboard input into the text field, forcing button use only.
        inputField.setEditable(false);
    }

    /***
     * Method called when the deposit button is clicked, which adds whatever number is in the input field
     * to the current balance of the account. Contains some rules for input (only one decimal place, requires
     * a number larger than zero to be deposited). Also provides a message to let the user know if their deposit
     * was successful or not.
     */
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

    /***
     * Method called when the withdrawal button is clicked, which subtracts whatever number is in the input field
     * from the current balance of the account. Contains some rules for input (only one decimal place,
     * requires a number larger than zero to be withdrawn, cannot withdraw more than what is in the account).
     * Also provides a message to let the user know if their withdrawal was successful or not.
     */
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

    /***
     * This method is assigned to each of the number buttons (including '.'), it takes the text displayed on the
     * button (the number or decimal point) and outputs it into the input field. This method also stops the user
     * from entering more than one decimal place per transaction, which would lead to errors.
     * @param event This parameter allows the method to receive information about the event (which button was clicked).
     */
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

    /***
     * Simple method to clear the input field, in the case of a mis-input. Assigned to the 'clear' button.
     */
    @FXML
    private void clearInputField() {
        inputField.clear();
    }

    /***
     * Method assigned to the logout button, takes the user to the logout page.
     * @throws IOException Throws input/output exception in the case that there is a problem with the FXML file.
     */
    @FXML
    void userLogout() throws IOException {
        new SceneSwitch(dashboardAnchorPane, "view/logout-page.fxml");
    }
}
