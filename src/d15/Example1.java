package d15;

interface Keyboard {
    public static final String value = "상수";
    String date = "2025-01-01"; // 상수 키워드 생략 가능

    public abstract void aKey();
    void bKey(); // 추상 키워드 생략 가능
}

class Game1 implements Keyboard {
    @Override
    public void aKey() {
        System.out.println("공격");
    }

    @Override
    public void bKey() {
        System.out.println("방어");
    }
}

class Game2 implements Keyboard {

    @Override
    public void aKey() {
        System.out.println("슈팅");
    }

    @Override
    public void bKey() {
        System.out.println("태클");
    }
}

public class Example1 {
    public static void main(String[] args) {
        // 객체 생성은 불가능하지만 변수 선언은 가능
        Keyboard myKeyboard;
        myKeyboard = new Game1();
        myKeyboard.aKey();
        myKeyboard.bKey();

        myKeyboard = new Game2();
        myKeyboard.aKey();
        myKeyboard.bKey();

        // 익명구현체: 클래스 없이 객체 생성
        // 타입 변수 = new 인터페이스(){구현};
        Keyboard yourKeyboard = new Keyboard() {
            @Override
            public void aKey() {
                System.out.println("A키");
            }

            @Override
            public void bKey() {
                System.out.println("B키");
            }
        };
        yourKeyboard.aKey();
        yourKeyboard.bKey();
    }
}
