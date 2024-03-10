package uni.mosey.bankatm.Model;

public class BankAccount {
    public int accNumber = 0;
    public int accPass = 0;
    public double balance = 0;

    public BankAccount() {
        // Default constructor
    }

    public BankAccount(int a, int p, int b) {
        accNumber = a;
        accPass = p;
        balance = b;
    }

}
