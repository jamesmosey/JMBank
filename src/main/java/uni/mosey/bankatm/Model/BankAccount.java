package uni.mosey.bankatm.Model;

public class BankAccount {
    private final String name;
    private final String password;
    private final double initialBalance;

    public BankAccount(String name, String password, double initialBalance) {
        this.name = name;
        this.password = password;
        this.initialBalance = initialBalance;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}

