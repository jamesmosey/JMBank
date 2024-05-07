package uni.mosey.bankatm.Model;
import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private static final AccountManager instance = new AccountManager();
    private final Map<String, BankAccount> accountMap = new HashMap<>();

    private AccountManager() {
        // Initialize the account hashmap with sample data
        accountMap.put("1234", new BankAccount("Alice", "4321", 1000.00));
        accountMap.put("0420", new BankAccount("Bob", "0240", 2000.00));
        accountMap.put("1351", new BankAccount("Charlie", "1531", 3000.00));
    }

    public static AccountManager getInstance() {
        return instance;
    }

    public Map<String, BankAccount> getAccountMap() {
        return accountMap;
    }
}
