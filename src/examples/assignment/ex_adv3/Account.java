package examples.assignment.ex_adv3;

public class Account {
    private String accNum, password;
    private int balance;

    Account(String accNum, String password, int balance) {
        this.accNum = accNum;
        this.password = password;
        this.balance = balance;
    }

    public String getAccNum() {
        return accNum;
    }

    public String getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance += balance;
    }
}
