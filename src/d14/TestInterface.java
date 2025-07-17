package d14;

public interface TestInterface {
    // 상수와 추상 메소드만 정의 가능
    // 상수는 반드시 초기값이 있어야 함
    int value = 10;

    // 각각의 클래스가 오버라이딩하여 구현함 (abstract method)
    void method1();
    boolean method2(int a);
}
