package d04;

import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        for (int i=1; i<=5; i++) {
            System.out.println(i);
        }
        System.out.println("=================================");
        for (int i=2; i<=9; i++) {
            for (int j=1; j<=9; j++) {
                System.out.printf("%d * %d = %d\n", i, j, i*j);
            }
        }
        System.out.println("=================================");
        for (int i=1; i<=10; i++) {
            System.out.println(i);
            if (i == 5) break;
        }
        System.out.println("=================================");
        for (int i=1; i<=10; i++) {
            if (i == 5) continue;
            System.out.println(i);
        }
        System.out.println("=================================");
        for (;;) {
             System.out.println("무한 루프 ('x' 를 입력하여 종료)");
             String input = new Scanner(System.in).next();
             if (input.equals("x")) break;
        }
    }
}
