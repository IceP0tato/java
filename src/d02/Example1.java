package d02;

public class Example1 {
    public static void main(String[] args) {
        // 묵시적 타입변환 (자동): byte -> short/char -> int -> long -> float -> double
        // 하나의 자료가 여러 개의 타입을 가질 수 있음 (다형성)
        byte byteValue = 10;
        short shortValue = byteValue;
        int intValue = shortValue;
        long longValue = intValue;
        float floatValue = longValue; // 10 -> 10.0
        double doubleValue = floatValue;
        System.out.println(doubleValue);

        // 명시적 타입변환 (강제): double -> float -> long -> int -> short/char -> byte (데이터 손실 발생)
        double dValue = 3.14;
        float fValue = (float) dValue;
        long lValue = (long) fValue; // 3.14 -> 3
        int iValue = (int) lValue;
        short sValue = (short) iValue;
        byte bValue = (byte) sValue;
        System.out.println(bValue);

        // 타입변환 (연산): 두 항 중에 더 큰 항으로 자동 타입변환
        byte b1 = 10;
        byte b2 = 20;
        short s1 = 30;
        int i1 = 40;
        long l1 = 50;
        float f1 = 3.14f;
        double d1 = 41.25;
        int result1 = b1 + b2; // byte + byte = int
        int result2 = b1 + s1; // byte + short = int
        int result3 = i1 + i1; // int + int = int
        long result4 = i1 + l1; // int + long = long
        float result5 = i1 + f1; // int + float = float
        double result6 = i1 + d1; // int + double = double
    }
}
