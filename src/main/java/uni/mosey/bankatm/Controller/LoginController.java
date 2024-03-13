package uni.mosey.bankatm.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import uni.mosey.bankatm.Model.BankAccount;
import uni.mosey.bankatm.Model.DataSingleton;
import uni.mosey.bankatm.Model.SceneSwitch;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginController {

    @FXML
    private Label userErrorLabel;
    @FXML
    private Label passErrorLabel;
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

    // Uses DataSingleton class to handle any data communication between scenes
    DataSingleton data = DataSingleton.getInstance();


    private final Map<String, BankAccount> accountMap = new HashMap<>();
    private String currentAccount;

    public LoginController() {
        // Initialize the account-password mapping
        accountMap.put("1234", new BankAccount("Alice", "4321"));
        accountMap.put("0420", new BankAccount("Bob", "0240"));
        accountMap.put("1351", new BankAccount("Charlie", "1531"));
    }

    @FXML
    private void clearInput() {
        usernameTextField.clear();
        passwordTextField.clear();
    }

    @FXML
    private void handleNumberButton(javafx.event.ActionEvent event) {
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
                // Show the PIN number TextField
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
