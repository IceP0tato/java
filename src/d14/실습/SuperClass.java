package d14.실습;

public class SuperClass {
    String name = "상위";

    void method() {
        System.out.println("상위 메소드");
    }
}

class SubClass extends SuperClass {
    String name = "하위";

    void method() {
        System.out.println("하위 메소드");
    }
}