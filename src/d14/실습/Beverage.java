package d14.실습;

public class Beverage {
    void drink() {
        System.out.println("음료를 마십니다.");
    }
}

class Coke extends Beverage {
    void drink() {
        System.out.println("콜라를 마십니다.");
    }
}

class Coffee extends Beverage {
    void drink() {
        System.out.println("커피를 마십니다.");
    }
}