package uni.mosey.bankatm.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import uni.mosey.bankatm.Model.AccountManager;
import uni.mosey.bankatm.Model.BankAccount;
import uni.mosey.bankatm.Model.DataSingleton;
import uni.mosey.bankatm.Model.SceneSwitch;

import java.io.IOException;
import java.util.Map;

public class LoginController {

    public ImageView loginImage;
    public Button oneBtn;
    public Button twoBtn;
    public Button threeBtn;
    public Button fourBtn;
    public Button fiveBtn;
    public Button sixBtn;
    public Button sevenBtn;
    public Button nineBtn;
    public Button eightBtn;
    public Button zeroBtn;
    public Button confirmbtn;
    public Button clearbtn;
    public Button confirmBtn;
    public Button clearBtn;
    @FXML
    private Label userErrorLabel;
    @FXML
    private Label loginLabel;
    @FXML
    private Label inputLabel1;
    @FXML
    private Label inputLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private AnchorPane loginPageAnchorPane;

    // This class accesses the hashmap through an instance of the 'AccountManager' class.
    private final AccountManager accountManager = AccountManager.getInstance();
    private final Map<String, BankAccount> accountMap = accountManager.getAccountMap();

    // Stores the name of the person currently logged in as a string
    private String currentAccount;

    /***
     * Simple method assigned to the clear button of the login and pin pages. Clears all input from the text fields.
     */
    @FXML
    private void clearInput() {
        usernameTextField.clear();
        passwordTextField.clear();
    }

    /***
     * This method is assigned to each of the number buttons, it takes the text displayed on the button (the number)
     * and outputs it into the input field. This method only lets the user enter 4 numbers per field, so they cannot
     * go beyond the account number/pin limit.
     * @param event This parameter allows the method to receive information about the event (which button was clicked).
     */
    @FXML
    private void handleNumberButton(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();

        // Check which text field is visible
        if (usernameTextField.isVisible()) {
            // If account number text field is visible
            if (usernameTextField.getText().length() < 4) {
                // Only append the button text if the length is less than 4
                usernameTextField.setText(usernameTextField.getText() + buttonText);
            }
        } else if (passwordTextField.isVisible()) {
            // If password text field is visible
            if (passwordTextField.getText().length() < 4) {
                // Only append the button text if the length is less than 4
                passwordTextField.setText(passwordTextField.getText() + buttonText);
            }
        }
    }

    /***
     * This method is assigned to the confirm button, which runs checks to make sure a valid account number and pin are
     * entered, and that the account number and pin match in the hashmap where they are linked. If the account number/pin
     * is invalid OR they account number and pin don't match, an error will be displayed to the user. If they are valid
     * and match, the user will be logged in and taken to the dashboard.
     * @throws IOException Input/output exception is thrown in the case that there is an issue with the FXML file.
     */
    @FXML
    private void handleConfirmButton() throws IOException {
        if (usernameTextField.isVisible()) {
            // If the account number text field is visible
            String accountInput = usernameTextField.getText();
            if (accountInput.isEmpty()) {
                userErrorLabel.setText("Please enter a valid account number.");
                return;
            }

            // Check if input is a valid account number
            if (accountMap.containsKey(accountInput)) {
                // Set the username to be stored
                DataSingleton.getInstance().setUsername(accountInput);
                // Hide the account number TextField
                usernameTextField.setVisible(false);
                // Show the PIN TextField
                passwordTextField.setVisible(true);
                // Show the PIN label
                inputLabel1.setVisible(true);
                inputLabel.setVisible(false);
                // Set the current account
                currentAccount = accountInput;
                // Clear any error messages
                userErrorLabel.setText("");
                // Update UI labels
                loginLabel.setText("Please enter your PIN number.");
            } else {
                userErrorLabel.setText("Invalid account number. Please try again.");
                // Clear the TextField for another attempt
                usernameTextField.clear();
            }
        } else if (passwordTextField.isVisible()) {
            // If the password text field is visible
            String pinInput = passwordTextField.getText();
            if (pinInput.isEmpty()) {
                userErrorLabel.setText("Please enter a valid PIN number.");
                return;
            }

            // Check if the PIN matches the current account
            String correctPassword = accountMap.get(currentAccount).getPassword();
            if (correctPassword.equals(pinInput)) {
                new SceneSwitch(loginPageAnchorPane, "view/dashboard.fxml");
            } else {
                userErrorLabel.setText("Invalid PIN number. Please try again.");
                // Clear the TextField for another attempt
                passwordTextField.clear();
            }
        }
    }

}
