/* [JAVA] 심화과제2 : BankService 아래 실행예시를 참고하여 코드를 구현하시오. *미제출
[ 클래스 개수 ] : 3개 (Account, BankController, BankService)
[ 규칙 ] BankController 에서는 입력과 출력을 하지 않습니다.
[ 계좌 최대 개수 ] : 100개
[ 실행 예시 ]
=========== KB Bank ===========
  1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체
============================
선택 > 1
--- 계좌 등록 (보내는 사람) ---
계좌번호 : 111-111
비밀번호 : 1234
[안내] 계좌 등록이 완료되었습니다.

=========== KB Bank ===========
  1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체
============================
선택 > 1
--- 계좌 등록 (받는 사람) ---
계좌번호 : 222-222
비밀번호 : 5678
[안내] 계좌 등록이 완료되었습니다.

=========== KB Bank ===========
  1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체
============================
선택 > 2
--- 입금 ---
계좌번호 : 111-111
비밀번호 : 1234
입금액 : 50000
[안내] 입금이 완료되었습니다.

=========== KB Bank ===========
  1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체
============================
선택 > 5
--- 계좌 이체 ---
보내는 분 계좌번호 : 111-111
비밀번호 : 1234
받는 분 계좌번호 : 222-222
이체할 금액 : 20000
[안내] 이체가 완료되었습니다.

=========== KB Bank ===========
  1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체
===============================
선택 > 4
--- 잔고 확인 (보내는 사람) ---
계좌번호 : 111-111
비밀번호 : 1234
[잔고] 30000원

=========== KB Bank ===========
  1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체
============================
선택 > 4
--- 잔고 확인 (받는 사람) ---
계좌번호 : 222-222
비밀번호 : 5678
[잔고] 20000원

=========== KB Bank  ===========
  1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체
=============================
--- 계좌 이체 (잔액 부족) ---
보내는 분 계좌번호 : 111-111
비밀번호 : 1234
받는 분 계좌번호 : 222-222
이체할 금액 : 40000
[경고] 잔액이 부족합니다.

=========== KB Bank  ===========
  1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체
=============================
선택 > 5
--- 계좌 이체 (비밀번호 오류) ---
보내는 분 계좌번호 : 111-111
비밀번호 : 0000
받는 분 계좌번호 : 222-222
이체할 금액 : 10000
[경고] 계좌정보가 일치하지 않습니다. */

package examples.assignment.ex_adv3;

import java.util.Scanner;

public class BankService {
    public static void main(String[] args) {
        BankController bc = new BankController();
        Scanner scan = new Scanner(System.in);

        for (;;) {
            System.out.println("============== KB Bank  ==============");
            System.out.println("  1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체 | 6.거래내역");
            System.out.println("======================================");
            System.out.print("선택 > ");
            int option = scan.nextInt();

            if (option == 1) { // 계좌등록
                System.out.println("--- 계좌 등록 ---");
                System.out.print("계좌번호 : ");
                String accNum = scan.next();
                System.out.print("비밀번호 : ");
                String password = scan.next();

                bc.createAccount(accNum, password); // str, str
            } else if (option == 2) { // 입금
                System.out.println("--- 입금 ---");
                System.out.print("계좌번호 : ");
                String accNum = scan.next();
                System.out.print("비밀번호 : ");
                String password = scan.next();
                System.out.print("입금액 : ");
                int money = scan.nextInt();

                bc.deposit(accNum, password, money); // str, str, int
            } else if (option == 3) { // 출금
                System.out.println("--- 출금 ---");
                System.out.print("계좌번호 : ");
                String accNum = scan.next();
                System.out.print("비밀번호 : ");
                String password = scan.next();
                System.out.print("출금액 : ");
                int money = scan.nextInt();

                bc.withdraw(accNum, password, money); // str, str, int
            } else if (option == 4) { // 잔고
                System.out.println("--- 잔고 확인 ---");
                Account[] acc = bc.getAccounts();
                for (int i=0; i<acc.length; i++) {
                    if (acc[i] != null) {
                        System.out.println("계좌번호 : " + acc[i].getAccNum());
                        System.out.println("비밀번호 : " + acc[i].getPassword());
                        System.out.println("[잔고] " + acc[i].getBalance() + "원\n");
                    } else break;
                }
            } else if (option == 5) { // 계좌이체
                System.out.println("--- 계좌 이체 ---");
                System.out.print("보내는 분 계좌번호 : ");
                String accNumS = scan.next();
                System.out.print("비밀번호 : ");
                String password = scan.next();
                System.out.print("받는 분 계좌번호 : ");
                String accNumR = scan.next();
                System.out.print("이체할 금액 : ");
                int money = scan.nextInt();

                bc.transfer(accNumS, password, accNumR, money); // str, str, str, int
            } else if (option == 6) { // 거래내역
                System.out.print("계좌번호 : ");
                String accNum = scan.next();
                System.out.print("비밀번호 : ");
                String password = scan.next();

                bc.log(accNum, password); // str, str, int
            }
        }
    }
}
