package uni.mosey.bankatm.Model;

public class BankAccount {
    private final String name;
    private final String password;
    private final double initialBalance;

    /***
     * Constructor used to initialise the objects in the account hashmap.
     * @param name The name of the account holder.
     * @param password The PIN of the account.
     * @param initialBalance The initial balance of the account.
     */
    public BankAccount(String name, String password, double initialBalance) {
        this.name = name;
        this.password = password;
        this.initialBalance = initialBalance;
    }

    /***
     * Method used to return the initial balance of an account.
     * @return Returns the initial balance of an account.
     */
    public double getInitialBalance() {
        return initialBalance;
    }

    /***
     * Used to return the name of an account holder, to be used on labels in certain scenes.
     * @return Returns the accounts holders name.
     */
    public String getName() {
        return name;
    }

    /***
     * Used to return the PIN of an account, so it can be checked for validity when signing in.
     * @return Returns the PIN of an account.
     */
    public String getPassword() {
        return password;
    }
}

