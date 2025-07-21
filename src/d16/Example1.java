package d16;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        // 예외 처리 (try, catch, finally)
        try {
            Class.forName("java.lang.String"); // 해당 경로의 클래스를 읽어오는 함수
        } catch (ClassNotFoundException e){
            System.out.println("예외 발생 (String class가 없습니다.)");
        }

        try {
            Class.forName("java.lang.String2"); // String2: 존재하지 않는 클래스
        } catch (ClassNotFoundException e) {
            System.out.println("예외 발생 (String2 class가 없습니다.)" + e);
        }

        try {
            Thread.sleep(1000); // 코드 실행을 1초간 일시정지하는 함수
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }

        try {
            String str1 = "강호동";
            System.out.println(str1.length());
            String str2 = null;
            System.out.println(str2.length());
        } catch (NullPointerException e) {
            System.out.println("예외 발생 (NullPointerException)");
        }

        try {
            String str3 = "100";
            String str4 = "1aa";
            Integer.parseInt(str3); // 문자열을 정수형으로 변환하여 반환하는 함수
            Integer.parseInt(str4);
        } catch (NumberFormatException e) {
            System.out.println("예외 발생 (NumberFormatException)");
        }

        try {
            int[] intArray = {1, 2, 3};
            System.out.println(intArray[0]);
            System.out.println(intArray[4]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("예외 발생: " + e);
        }

        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("정수 입력: ");
            int number = scan.nextInt();
            System.out.println(number);
        } catch (InputMismatchException e) {
            System.out.println("정수를 입력해주세요.");
        }

        // 다중 catch (먼저 발생한 예외부터 1개의 catch만 실행됨)
        try {
            Integer.parseInt("1aa");
            int[] intArray = {1, 2, 3};
            System.out.println(intArray[10]);
            String str = null;
            System.out.println(str.length());
        } catch (NumberFormatException e1) { // 실행
            System.out.println("예외 발생1: " + e1);
        } catch (ArrayIndexOutOfBoundsException e2) {
            System.out.println("예외 발생2: " + e2);
        } catch (NullPointerException e3) {
            System.out.println("예외 발생3: " + e3);
        } catch (Exception e4) { // 모든 예외 처리 (다중 catch 시 맨 아래에 정의해야 함)
            System.out.println("예외 발생4: " + e4);
        } finally { // 예외 유무에 상관 없이 무조건 실행
            System.out.println("프로그램 종료");
        }

    }
}
