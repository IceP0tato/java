package examples.assignment.ex_adv1;

import java.util.Scanner;

public class BankService {
    public static void main(String[] args) {
        BankController controller = new BankController();
        Scanner scan = new Scanner(System.in);

        for (;;) {
            System.out.println("============== KB Bank  ==============");
            System.out.println("  1.계좌등록 | 2.입금 | 3.출금 | 4.잔고");
            System.out.println("======================================");
            System.out.print("선택 > ");
            int option = scan.nextInt();

            if (option == 1) { // 계좌등록
                System.out.println("--- 계좌 등록 ---");
                System.out.print("계좌번호 : ");
                String accNum = scan.next();
                System.out.print("비밀번호 : ");
                String password = scan.next();

                controller.createAccount(accNum, password); // str, str
            } else if (option == 2) { // 입금
                System.out.println("--- 입금 ---");
                System.out.print("계좌번호 : ");
                String accNum = scan.next();
                System.out.print("비밀번호 : ");
                String password = scan.next();
                System.out.print("입금액 : ");
                int money = scan.nextInt();

                controller.deposit(accNum, password, money); // str, str, int
            } else if (option == 3) { // 출금
                System.out.println("--- 출금 ---");
                System.out.print("계좌번호 : ");
                String accNum = scan.next();
                System.out.print("비밀번호 : ");
                String password = scan.next();
                System.out.print("입금액 : ");
                int money = scan.nextInt();

                controller.withdraw(accNum, password, money); // str, str, int
            } else if (option == 4) { // 잔고
                System.out.println("--- 잔고 확인 ---");
                Account[] acc = controller.getAccounts();
                for (int i=0; i<acc.length; i++) {
                    if (acc[i] != null) {
                        System.out.println("계좌번호 : " + acc[i].accNum);
                        System.out.println("비밀번호 : " + acc[i].password);
                        System.out.println("[잔고] " + acc[i].balance + "원\n");
                    } else break;
                }
            }
        }
    }
}
