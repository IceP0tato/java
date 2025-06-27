package d01;

public class Example2 {
    public static void main(String[] args) {
        // 리터럴 (모든 정수는 int, 모든 실수는 double)
        System.out.println(3);
        System.out.println(3.14);
        System.out.println('김');
        System.out.println("김현수");
        System.out.println(true);

        // 기본 자료형
        // 정수 : byte, short, int, long
        // 실수 : float, double
        // 문자 : char , 문자열 : String
        // 논리 : boolean

        boolean bool1 = true;
        boolean bool2 = false;
        System.out.println(bool1);
        System.out.println(bool2);

        char ch1 = 'A'; // ''
        System.out.println(ch1);

        String str1 = "ABC"; // 참조 자료형 (배열 형태) ""
        System.out.println(str1);

        // byte : 정수 -128 ~ +127
        // short : 정수 ~ -+ 3만
        // int : 정수 ~ -+ 21억 (정수 리터럴)
        // long : 정수 ~ -+ 21억 이상 (리터럴 뒤에 L/l)

        byte b1 = 100;
        short s1 = 32000;
        int i1 = 2100000000;
        long l1 = 3000000000000L;
        System.out.println(b1);
        System.out.println(s1);
        System.out.println(i1);
        System.out.println(l1);

        // double : 실수 소수점 17자리까지 (실수 리터럴)
        // float : 실수 소수점 8자리까지 (리터럴 뒤에 F/f)
        double d1 = 0.123456789123456789;
        float f1 = 0.123456789f;
        System.out.println(d1);
        System.out.println(f1);
    }
}
