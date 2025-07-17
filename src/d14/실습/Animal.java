package d14.실습;

public class Animal {
    void makeSound() {
        System.out.println("동물이 소리를 냅니다.");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("고양이가 야옹하고 웁니다.");
    }
}