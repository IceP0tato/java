package d08;

public class Example1 {
    public static void main(String[] args) {
        Phone p1 = new Phone();
        Phone p2 = new Phone("갤럭시 S25", "실버");
        Phone p3 = new Phone("아이폰 15", "화이트", 1500000);

    }
}

class Phone {
    String model, color;
    int price;

    // 메소드 오버로딩
    Phone() {
        System.out.println("기본 생성자 실행");
    }

    Phone(String pModel, String pColor) {
        model = pModel;
        color = pColor;
        price = 1000000;
    }

    Phone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }
}