package d09;

public class Example2 {
    void memberMethod() {

    }
    static void nonMemberMethod() {

    }
    public static void main(String[] args) {
        D d = new D();
        System.out.println(d.last);
        // d.last = 20; 수정 불가

        System.out.println(D.stat); // 객체 X stat
        D.stat= 20;
        System.out.println(d.stat); // 객체 O stat

        System.out.println(D.constVal);

        // memberMethod(); 불가능
        nonMemberMethod(); // 가능 : static 이라 객체 없이 메소드 사용 가능
        Example2 exam = new Example2();
        exam.memberMethod(); // 가능 : 객체를 만들고 non-static 메소드 사용 가능
    }
}

class D {
    final int last = 10; // 초기값이 반드시 존재해야 함
    static int stat; // 객체를 생성(new)하지 않아도 사용 가능
    static final int constVal = 10; // 상수

    // static 으로 선언한 메소드는 같은 클래스 내의 메소드를 호출할 수 없음 (static 우선 할당)
    static void test() {
        // test2(); 불가능
        test3();
    }

    void test2() {
        test3();
        test4();
    }

    static void test3() {

    }

    void test4() {

    }
}