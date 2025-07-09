package examples.assignment.ex_adv1;

public class BankController {
    Account[] accounts = new Account[100];

    // 계좌등록 함수
    void createAccount(String accNum, String password) {
        Account acc = new Account();
        acc.accNum = accNum;
        acc.password = password;
        acc.balance = 0;

        for (int i=0; i<accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = acc;
                System.out.println("[안내] 계좌 등록이 완료되었습니다.\n");
                return;
            }
        }
        System.out.println("[경고] 더 이상 계좌를 등록할 수 없습니다.\n");
    }

    // 입금 함수
    void deposit(String accNum, String password, int money) {
        for (int i=0; i<accounts.length; i++) {
            if (accounts[i] != null) {
                if (accounts[i].accNum.equals(accNum) && accounts[i].password.equals(password)) { // 계좌 조회
                    accounts[i].balance += money;
                    System.out.println("[안내] 입금이 완료되었습니다.\n");
                    return;
                }
            }
        }
        System.out.println("[경고] 계좌정보가 일치하지 않습니다.\n");
    }

    // 출금 함수
    void withdraw(String accNum, String password, int money) {
        for (int i=0; i<accounts.length; i++) {
            if (accounts[i] != null) {
                if (accounts[i].accNum.equals(accNum) && accounts[i].password.equals(password)) { // 계좌 조회
                    if (accounts[i].balance < money) {
                        System.out.println("[경고] 잔액이 부족합니다.\n");
                    } else {
                        accounts[i].balance -= money;
                        System.out.println("[안내] 출금이 완료되었습니다.\n");
                    }
                    return;
                }
            }
        }
        System.out.println("[경고] 계좌정보가 일치하지 않습니다.\n");
    }

    // 잔고 확인 함수
    Account[] getAccounts() {
        return accounts;
    }
}
