package d07;

public class Example1 {
    public static void main(String[] args) {
        Calculator cal1 = new Calculator();
        double pi = cal1.getPi();
        System.out.println(pi);

        cal1.powerOn();
        Calculator cal2 = new Calculator();
        System.out.println(cal1.isPowerOn); // true
        System.out.println(cal2.isPowerOn); // false

        // cal1.printSum(10.4, 2.8); error: type mismatch
        cal1.printSum(3, 5);
        cal2.printSum(10, 2);

        int result = cal1.add(10, 3);
        int result2 = cal2.add(10, 10);
    }
}
