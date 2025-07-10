package examples.assignment.ex_adv3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankController {
    private static Account[] accounts = new Account[100];

    // 계좌등록 함수
    void createAccount(String accNum, String password) {
        Account acc = new Account(accNum, password, 0);

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
                if (accounts[i].getAccNum().equals(accNum) && accounts[i].getPassword().equals(password)) { // 계좌 조회
                    String date = getTime(); // 현재 시간
                    accounts[i].setBalance(money);

                    AccountLog log = new AccountLog(accNum, date, "입금", money, accounts[i].getBalance()); // 입금 로그 작성
                    AccountLog[] logs = AccountLog.getAccountLogs();
                    for (int k=0; k<logs.length; k++) {
                        if (logs[k] == null) {
                            logs[k] = log;
                            break;
                        }
                    }
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
                if (accounts[i].getAccNum().equals(accNum) && accounts[i].getPassword().equals(password)) { // 계좌 조회
                    if (accounts[i].getBalance() < money) {
                        System.out.println("[경고] 잔액이 부족합니다.\n");
                    } else {
                        String date = getTime(); // 현재 시간
                        accounts[i].setBalance(-money);

                        AccountLog log = new AccountLog(accNum, date, "출금", money, accounts[i].getBalance()); // 출금 로그 작성
                        AccountLog[] logs = AccountLog.getAccountLogs();
                        for (int k=0; k<logs.length; k++) {
                            if (logs[k] == null) {
                                logs[k] = log;
                                break;
                            }
                        }
                        System.out.println("[안내] 출금이 완료되었습니다.\n");
                    }
                    return;
                }
            }
        }
        System.out.println("[경고] 계좌정보가 일치하지 않습니다.\n");
    }

    // 계좌 이체 함수
    void transfer(String accNumS, String password, String accNumR, int money) {
        for (int i=0; i<accounts.length; i++) {
            if (accounts[i] != null) {
                if (accounts[i].getAccNum().equals(accNumS) && accounts[i].getPassword().equals(password)) { // 계좌 조회 (보내는 사람)
                    for (int j=0; j<accounts.length; j++) {
                        if (accounts[j] != null) {
                            if (accounts[j].getAccNum().equals(accNumR)) { // 계좌 조회 (받는 사람)
                                if (accounts[i].getBalance() < money) {
                                    System.out.println("[경고] 잔액이 부족합니다.\n");
                                } else {
                                    String date = getTime(); // 현재 시간
                                    accounts[i].setBalance(-money);
                                    accounts[j].setBalance(money);

                                    AccountLog logS = new AccountLog(accNumS, date, "이체", money, accounts[i].getBalance()); // 이체 로그 작성 (보내는 사람)
                                    AccountLog logR = new AccountLog(accNumR, date, "이체", money, accounts[j].getBalance()); // 이체 로그 작성 (받는 사람)
                                    AccountLog[] logs = AccountLog.getAccountLogs();
                                    for (int k=0; k<logs.length; k++) {
                                        if (logs[k] == null) {
                                            logs[k] = logS;
                                            logs[k+1] = logR;
                                            break;
                                        }
                                    }
                                    System.out.println("[안내] 이체가 완료되었습니다.\n");
                                }
                                return;
                            }
                        }
                    }
                    System.out.println("[경고] 받는 분의 계좌를 찾을 수 없습니다.\n");
                    return;
                }
            }
        }
        System.out.println("[경고] 계좌정보가 일치하지 않습니다.\n");
    }

    // 거래내역 조회 함수
    void log(String accNum, String password) {
        for (int i=0; i<accounts.length; i++) {
            if (accounts[i] != null) {
                if (accounts[i].getAccNum().equals(accNum) && accounts[i].getPassword().equals(password)) { // 계좌 조회
                    AccountLog[] logs = AccountLog.getAccountLogs();
                    for (int j=0; j<logs.length; j++) {
                        if (logs[j] != null) {
                            if (accounts[i].getAccNum().equals(logs[j].getAccNum())) { // accNum 이 일치하는 로그만 출력
                                System.out.print("[" + logs[j].getDate() + "]");
                                System.out.print(" " + logs[j].getType() + " | ");
                                if (j-1 >= 0) { // j-1 으로 ArrayOutOfIndex 예외를 방지하기 위한 코드
                                    if (logs[j-1].getAccNum().equals(logs[j].getAccNum())) { // 다른 계정의 기록과 비교하지 않도록 최초 로그를 분리하는 코드
                                        changeChecker(logs[j-1].getBalance(), logs[j].getBalance());
                                    } else {
                                        changeChecker(logs[j].getBalance());
                                    }
                                } else {
                                    changeChecker(logs[j].getBalance());
                                }
                                System.out.print(logs[j].getChange() + "원 | ");
                                System.out.print("잔액: " + logs[j].getBalance() + "원\n");
                            }
                        } else return;
                    }
                }
            }
        }
        System.out.println("[경고] 계좌 정보를 찾을 수 없습니다.\n");
    }

    // 변동액 체크 함수 (이전, 현재 기록 존재 시 비교)
    void changeChecker(int prev, int curr) {
        if (prev>curr) System.out.print("-");
        else System.out.print("+");
    }

    // 변동액 체크 함수 (현재 기록만 존재 시 비교 [최초 로그])
    void changeChecker(int curr) {
        if (curr>0) System.out.print("+");
        else System.out.print("-");
    }

    // 현재 시간 출력 함수
    String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format( LocalDateTime.now() );
    }

    // 잔고 확인 함수
    Account[] getAccounts() {
        return accounts;
    }
}
