package d08;

public class BankAccount {
    String accountNumber, ownerName;
    int balance;

    BankAccount(String accountNumber, String ownerName, int balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    void deposit(int money) {
        balance += money;
    }

    void withdraw(int money) {
        balance -= money;
    }
}
