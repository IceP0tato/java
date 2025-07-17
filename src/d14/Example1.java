package d14;

public class Example1 {
    public static void main(String[] args) {
        Class1 obj1 = new Class1();
        obj1.showValue();
        System.out.println("======================================");
        Class2 obj2 = new Class2();
        obj2.showValue();
        obj2.showValue2();
        System.out.println("======================================");
        System.out.println(obj2.value1);
        System.out.println(obj2.value3);
        System.out.println("======================================");
        Class1 obj3 = obj2;
        System.out.println(obj3.value2);
        System.out.println("======================================");
        obj2.showValue();
        obj3.showValue();
        Class1 obj4 = obj2;
        obj4.showValue();
        Class1 obj5 = new Class1();
        obj5.showValue();

        // 오버라이딩
        // 메소드가 동일할 때 오버라이딩 메소드 최우선
    }
}

class Class1 {
    int value1 = 10;
    int value2 = 20;

    Class1() {
        System.out.println("Class1 생성");
    }

    void showValue() {
        System.out.println("Class1 실행");
    }
}

class Class2 extends Class1 {
    int value3 = 30;
    int value4 = 40;

    Class2() {
        System.out.println("Class2 생성");
    }

    void showValue() {
        System.out.println("Class2 실행 1");
    }

    void showValue2() {
        System.out.println("Class2 실행 2");
    }
}