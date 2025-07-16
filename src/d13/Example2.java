package d13;

public class Example2 {
    public static void main(String[] args) {
        A a = new A(); // Object, A 객체 생성
        System.out.println("=========================");
        B b = new B(); // Object, A, B 객체 생성
        System.out.println("=========================");
        C c = new C(); // Object, A, C 객체 생성
        System.out.println("=========================");
        D d = new D(); // Object, A, B, D 객체 생성
        System.out.println("=========================");
        E e = new E(); // Object, A, C, E 객체 생성
        System.out.println("=========================");

        // 자동 타입변환
        A a1 = b;
        Object o1 = b;
        // B b2 = c; Error

        // 강제 타입변환
        B b2 = (B)a1;
        A a2 = e;
        C c1 = (C)a2;
        // B b3 = (B)a2; 실행 도중 Error

        // instanceof : 인스턴스(객체/값) 타입 확인
        System.out.println(a instanceof Object);
        System.out.println(b instanceof A);
        // System.out.println(e instanceof B); Error (false)
        System.out.println(a2 instanceof C);
        System.out.println(a2 instanceof B); // false

        // 코드 작성 시 명령어(코드)가 중복되면 메소드화
        // 클래스 정의 도중 다른 클래스와 멤버변수가 중복되면 상속화
    }
}

// A의 부모 : Object (.toString() 등이 있음)
class A {
    A() {
        System.out.println("A 생성자");
    }
}

class B extends A {
    B() {
        System.out.println("B 생성자");
    }
}

class C extends A {
    C() {
        System.out.println("C 생성자");
    }
}

class D extends B {
    D() {
        System.out.println("D 생성자");
    }
}

class E extends C {
    E() {
        System.out.println("E 생성자");
    }
}