package d02;
import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        // new Scanner(System.in).next();
        Scanner scan = new Scanner(System.in);

        System.out.printf("1. next() : ");
        String text1 = scan.next(); // .next(): 입력받은 문자열 반환 (띄어쓰기 불가)
        System.out.println("1. next result : " + text1);

        System.out.print("2. nextLine() : ");
        scan.nextLine(); // nextLine() 앞에 next()가 있으면 엔터 키 문제가 발생하므로 무의미한 입력을 하나 받는 것으로 해결
        String text2 = scan.nextLine(); // .nextLine(): 입력받은 문자열 반환 (띄어쓰기 가능)
        System.out.println("2. nextLine result : " + text2);

        System.out.print("3. nextByte() : ");
        byte value1 = scan.nextByte(); // .nextByte(): 입력받은 정수(byte) 반환, 입력값이 허용 범위를 벗어나면 오류
        System.out.println("3. nextByte result : " + value1);

        System.out.print("4. nextShort() : ");
        short value2 = scan.nextShort(); // .nextShort(): 입력받은 정수(short) 반환, 입력값이 허용 범위를 벗어나면 오류
        System.out.println("4. nextShort result : " + value2);

        System.out.print("5. nextInt() : ");
        int value3 = scan.nextInt(); // .nextInt(): 입력받은 정수(int) 반환, 입력값이 허용 범위를 벗어나면 오류
        System.out.println("5. nextInt result : " + value3);

        System.out.print("6. nextLong() : ");
        long value4 = scan.nextLong(); // .nextLong(): 입력받은 정수(long) 반환, 입력값이 허용 범위를 벗어나면 오류
        System.out.println("6. nextLong result : " + value4);

        System.out.print("7. nextFloat() : ");
        float value5 = scan.nextFloat(); // .nextFloat(): 입력받은 실수(float) 반환, 입력값이 허용 범위를 벗어나면 오류
        System.out.println("7. nextFloat result : " + value5);

        System.out.print("8. nextDouble() : ");
        double value6 = scan.nextDouble(); // .nextDouble(): 입력받은 실수(double) 반환, 입력값이 허용 범위를 벗어나면 오류
        System.out.println("8. nextDouble result : " + value6);

        System.out.print("9. nextBoolean() : ");
        boolean value7 = scan.nextBoolean(); // .nextBoolean(): 입력받은 논리(boolean) 반환, 입력값이 허용 범위를 벗어나면 오류
        System.out.println("9. nextBoolean result : " + value7);

        System.out.print("10. next() : ");
        char value8 = scan.next().charAt(0); // .next().charAt(0): 입력받은 문자열 중에 첫 번째 글자 반환 [.nextChar()는 없음]
        System.out.println("10. next result : " + value8);
    }
}
