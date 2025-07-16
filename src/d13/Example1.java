package d13;

public class Example1 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.setName("강아지");
        animal.show();

        Bird bird = new Bird();
        bird.setName("비둘기");
        bird.show();

        Sparrow sparrow = new Sparrow();
        sparrow.setName("참새");
        sparrow.show();

        Chicken chicken = new Chicken();
        chicken.setName("닭");
        chicken.show();

        // 다형성
        Bird bird2 = sparrow;
        Animal animal2 = sparrow;

        // Sparrow sparrow2 = new Animal(); Error
        // Bird bird3 = new Animal(); Error

        Chicken obj1 = new Chicken();
        Animal obj2 = obj1;
        Chicken obj3 = (Chicken)obj2; // 강제 타입변환
        // Sparrow obj4 = (Sparrow)obj3; 불가능
    }
}

class Animal {
    private String name;

    void show() {
        System.out.println("이름: " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Bird extends Animal {

}

class Sparrow extends Bird {

}

class Chicken extends Bird {

}