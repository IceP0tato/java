package d20;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Example2 {
    public static void main(String[] args) {
        // getClass() : 클래스 경로 반환
        String str = new String();
        Class c = str.getClass();
        System.out.println(c); // class java.lang.String

        Integer value = 3;
        Class c2 = value.getClass();
        System.out.println(c2); // class java.lang.Integer

        // class.forName("클래스경로") : 지정한 클래스 경로에서 클래스 불러오기
        try {
            Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // getFields() : 모든 클래스/타입의 멤버변수명 반환
        Field[] fields = c.getFields();
        for (int i=0; i<fields.length; i++) {
            System.out.println(fields[i]);
        }
        // getConstructors() : 모든 클래스/타입의 생성자명 반환
        Constructor[] constructors = c.getConstructors();
        for (int i=0; i<constructors.length; i++) {
            System.out.println(constructors[i]);
        }
        // getMethods() : 모든 클래스/타입의 메소드명 반환
        Method[] methods = c.getMethods();
        for (int i=0; i<methods.length; i++) {
            System.out.println(methods[i]);
        }

        // Wrapper
        // 문자열 -> 기본타입
        int value1 = 100;
        Integer value2 = 100;
        Integer value3 = value1; // 오토박싱 (int -> Integer)
        int value4 = value2; // 언박싱 (Integer -> int)
        int value5 = Integer.parseInt("100"); // "100" -> 100
        double value6 = Double.parseDouble("3.14"); // "3.14" -> 3.14
        float value7 = Float.parseFloat("3.14"); // "3.14" -> 3.14
        Byte value8 = Byte.parseByte("100");
        short value9 = Short.parseShort("100");
        long value10 = Long.parseLong("100");
        Boolean value11 = Boolean.parseBoolean("true");

        // 기본타입 -> 문자열
        String s1 = 100+""; // 값 + 문자열 = 문자열
        String s2 = String.valueOf(100); // String.valueOf(자료);

        // LocalDate
        // now() : 현재 시간 반환
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate); // YYYY-MM-DD
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime); // HH-MM-SS.Miliseconds
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime); // YYYY-MM-DDHH-MM-SS.Miliseconds

        // ofPattern() : 연도(y), 월(M), 일(d), 시(h), 분(m), 초(s)
        // format() : 형식 반환
        LocalDateTime.of(2025, 07, 25, 11, 38, 15);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh:mm:ss");
        String today = localDateTime.format(formatter);
        System.out.println(today);

        int year = localDateTime.getYear(); // 연도
        int month = localDateTime.getMonthValue(); // 월
        int day = localDateTime.getDayOfMonth(); // 일
        int hour = localDateTime.getHour(); // 시
        int minute = localDateTime.getMinute(); // 분
        int second = localDateTime.getSecond(); // 초

        // 날짜 계산
        LocalDateTime plusDate = localDateTime.plusDays(10); // 10일 더하기
        LocalDateTime minusDate = localDateTime.minusDays(10); // 10일 빼기
        System.out.println(plusDate);
        System.out.println(minusDate);
    }
}
