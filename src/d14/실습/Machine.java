package d14.실습;

public class Machine {
    Machine() {
        System.out.println("부모 클래스 생성자 실행");
    }
}

class Computer extends Machine {
    Computer() {
        System.out.println("자식 클래스 생성자 실행");
    }
}