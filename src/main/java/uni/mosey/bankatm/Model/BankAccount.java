package uni.mosey.bankatm.Model;

public class BankAccount {
    private double balance;
    private String name;
    private String password;
    private double initialBalance;

    public BankAccount(String name, String password, double initialBalance) {
        this.name = name;
        this.password = password;
        this.initialBalance = initialBalance;
    }


    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
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

