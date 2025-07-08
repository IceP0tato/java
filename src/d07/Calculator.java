package d07;

public class Calculator {
    boolean isPowerOn = false;

    double getPi() { // 매개변수 X, 반환값 O
        return 3.14159;
    }

    void powerOn() { // 매개변수 X, 반환값 X
        System.out.println("계산기 전원을 켭니다.");
        isPowerOn = true;
    }

    void printSum(int x, int y) { // 매개변수 O, 반환값 X
        if(isPowerOn) {
            int sum = x + y;
            System.out.println(sum);
        } else {
            System.out.println("전원이 꺼져 있습니다.");
        }
    }

    int add(int x, int y) { // 매개변수 O, 반환값 O
        if(isPowerOn) {
            int sum = x + y;
            return sum;
        } else {
            System.out.println("전원이 꺼져 있습니다.");
            return 0;
        }
    }
}
