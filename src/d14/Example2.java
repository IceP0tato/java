package d14;

class Car {
    Tire tire;
    void run() {
        this.tire.roll();
    }
}

class Tire {
    void roll() {
        System.out.println("[일반] 타이어 회전");
    }
}

class HankookTire extends Tire {
    void roll() {
        System.out.println("[한국] 타이어 회전");
    }
}

class KumhoTire extends Tire {
    void roll() {
        System.out.println("[금호] 타이어 회전");
    }
}

public class Example2 {
    public static void main(String[] args) {
        Car myCar = new Car();
        // myCar.run(); Error: nullPointer

        // 다형성
        myCar.tire = new Tire();
        myCar.run(); // 일반

        myCar.tire = new HankookTire();
        myCar.run();

        myCar.tire = new KumhoTire();
        myCar.run();

        // 하위타입 객체 생성 시 상위타입 객체도 같이 생성됨
        System.out.println(myCar.tire instanceof Tire);
        System.out.println(myCar.tire instanceof KumhoTire);
        System.out.println(myCar.tire instanceof HankookTire); // false
    }
}