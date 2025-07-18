package d15.실습;

public interface Runnable {
    default void run() {
        System.out.println("달립니다.");
    }
}

class Person implements Runnable {
    public void run() {
        System.out.println("사람이 달립니다.");
    }
}

class Car implements Runnable {
    public void run() {
        System.out.println("자동차가 달립니다.");
    }
}