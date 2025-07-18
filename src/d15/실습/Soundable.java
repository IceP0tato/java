package d15.실습;

public interface Soundable {
    void makeSound();
}

class Cat implements Soundable {
    public void makeSound() {
        System.out.println("야옹");
    }
}

class Dog implements Soundable {
    public void makeSound() {
        System.out.println("멍멍");
    }
}
