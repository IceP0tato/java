package d16;

public class Example2 {
    // throws
    public static void method1() throws NullPointerException {
        String str = null;
        System.out.println(str.length());
    } // 일반예외 : 무조건 예외 처리

    public static void method2() throws ClassNotFoundException{
        Class.forName("com.sql.jdbc");
    } // 실행예외

    public static void main(String[] args) {
        // throw (예외 발생 시 메소드를 호출한 곳으로 예외 전달/리턴)
        try {
            method1();
        } catch (NullPointerException e) {
            System.out.println("예외 발생: " + e);
        }

        try {
            method2();
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }
    }
}
