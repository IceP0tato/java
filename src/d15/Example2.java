package d15;

interface Buy {
    void buy();

    // 디폴트 메소드: 인터페이스 타입에서 구현한 메소드 (사용 가능)
    public default void method1() {

    }
    // 정적 메소드: 인터페이스 타입에서 정적 구현 메소드
    public static void method2() {

    }
    // private 메소드: 현재 인터페이스 타입에서만 사용 가능한 구현 메소드
    private void method3() {

    }
    // private 정적 구현 메소드
    private static void method4() {

    }
}

interface Sell {
    void sell();
}

class Customer implements Buy, Sell {
    // 인터페이스는 여러 개 구현 가능 (상속은 1개만 상속 가능)
    @Override
    public void buy() {
        System.out.println("판매");
    }

    @Override
    public void sell() {
        System.out.println("구매");
    }
}

public class Example2 {
    public static void main(String[] args) {
        Buy buy = new Customer();
        buy.buy();
        // buy.sell(); Error

        buy.method1();
        Buy.method2();
        // buy.method3(); Error: private (구현체에서 구현하지 않을 때 사용해야 함)
        // Buy.method4(); Error: private
    }
}
