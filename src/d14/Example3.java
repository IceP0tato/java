package d14;

public class Example3 {
    public static void main(String[] args) {
        // 인터페이스
        // TestInterface ti = new TestInterface(); Error: Interface는 생성자가 없음
        System.out.println(TestInterface.value);

        // 구현체
        new Tool();
        Tool tool1 = new Tool();
        tool1.method1();
        TestInterface tool2 = new Tool();
        tool2.method1();

        // 상속: extends, 객체생성 O, 다중 상속 불가, 오버라이딩 선택
        // 구현(인터페이스): implements, 객체생성 X, 여러 개의 인터페이스 구현 가능, 오버라이딩 필수
    }
}

class Tool implements TestInterface {
    // 추상 메소드들을 반드시 모두 구현해야 함
    public void method1() {
        System.out.println("메소드 출력");
    }

    public boolean method2(int a) {
        return a > 10;
    }
}