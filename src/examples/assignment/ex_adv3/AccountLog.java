package examples.assignment.ex_adv3;

public class AccountLog {
    private static AccountLog[] accountLogs = new AccountLog[100];
    private String accNum, date, type;
    private int change, balance;

    AccountLog(String accNum, String date, String type, int change, int balance) {
        this.accNum = accNum;
        this.date = date;
        this.type = type;
        this.change = change;
        this.balance = balance;
    }

    public static AccountLog[] getAccountLogs() {
        return accountLogs;
    }

    public String getAccNum() {
        return accNum;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public int getChange() {
        return change;
    }

    public int getBalance() {
        return balance;
    }
}
