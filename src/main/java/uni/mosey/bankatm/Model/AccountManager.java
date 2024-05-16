package uni.mosey.bankatm.Model;
import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private static final AccountManager instance = new AccountManager();
    private final Map<String, BankAccount> accountMap = new HashMap<>();

    /***
     * Constructor method to populate the hashmap and instantiate/initialise account-password-balance mapping.
     * Used to set the default login credentials for users of the ATM, links the account number to the name, pin
     * and balance of the account. This hashmap is accessed through an instance throughout the program.
     */
    private AccountManager() {
        // Initialize the account hashmap with sample data
        accountMap.put("1234", new BankAccount("Alice", "4321", 1000.00));
        accountMap.put("0420", new BankAccount("Bob", "0240", 2000.00));
        accountMap.put("1351", new BankAccount("Charlie", "1531", 3000.00));
    }

    /***
     * Static method used to provide a single point of access to the instance of this class (the hashmap).
     * This allows the controllers to use the data from the hashmap in different areas of the application.
     * @return Returns the instance of the class.
     */
    public static AccountManager getInstance() {
        return instance;
    }

    /***
     * This method allows other class to retrieve the account information of each account stored in the hashmap.
     * @return Returns the account hashmap.
     */
    public Map<String, BankAccount> getAccountMap() {
        return accountMap;
    }
}