package d15.실습;

public interface Flyable {
    default void fly() {
        System.out.println("[Interface] 하늘을 납니다.");
    }
}

interface Swimmable {
    default void swimmable() {
        System.out.println("[Interface] 물에서 헤엄칩니다.");
    }
}

class Duck implements Flyable, Swimmable {
    public void fly() {
        System.out.println("[Class] 하늘을 납니다.");
    }

    public void swimmable() {
        System.out.println("[Class] 물에서 헤엄칩니다.");
    }
}