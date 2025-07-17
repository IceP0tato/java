package d14.실습;

public class Shape {
    void draw() {
        System.out.println("도형을 그립니다.");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("원을 그립니다.");
    }
}