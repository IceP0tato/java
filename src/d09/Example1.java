package d09;

import d09.p1.A;
import d09.p2.C;

public class Example1 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.open);
        // System.out.println(a.close); 접근 불가
        // System.out.println(a.def); 접근 불가

        C c = new C();
        System.out.println(c.getClose("1234")); // 접근 가능
        System.out.println(c.getClose("0000"));
        System.out.println(c.getClose());

        // c.setClose(20); 접근 불가

    }
}
