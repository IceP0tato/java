package d02;

public class Example3 {
    public static void main(String[] args) {
        int x = 10;
        int y = -3;

        // 연결연산자
        System.out.println(x + "개");

        // 산술연산자
        System.out.println(x + y);
        System.out.println(x - y);
        System.out.println(x * y);
        System.out.println(x / y); // 타입이 int 여서 소수점은 나오지 않음
        System.out.println(10.0 / -3.0); // 타입 double
        System.out.println(x % y);

        // 비교연산자
        System.out.println(x > y);
        System.out.println(x < y);
        System.out.println(x >= y);
        System.out.println(x <= y);
        System.out.println(x == y);
        System.out.println(x != y);

        // 논리연산자
        System.out.println(x > 10 && x < 20);
        System.out.println(y == 10 || y == 20);
        System.out.println(!(x >= 30));

        // 증감연산자
        System.out.println(x++); // 10
        System.out.println(++x); // 12
        System.out.println(y--); // -3
        System.out.println(--y); // -5

        // (복합)대입연산자
        int z = 30;
        z += 10;

        // 삼항연산자
        System.out.println(z>=60?"합격":"불합격");

        // 문자열 비교와 리터럴 비교는 다름
        // System.out.println("10" == 10); error
        System.out.println("10".equals(10)); // false
    }
}
