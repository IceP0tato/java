package d14;

class Vehicle {
    Tyre tyre;
    void run() {
        this.tyre.roll();
    }
}

interface Tyre {
    void roll();
}

class HankookTyre implements Tyre {

    @Override
    public void roll() {
        System.out.println("[한국] 타이어 회전");
    }
}

class KumhoTyre implements Tyre {

    @Override
    public void roll() {
        System.out.println("[금호] 타이어 회전");
    }
}

public class Example4 {
    public static void main(String[] args) {
        Vehicle myCar = new Vehicle();
        // myCar.run(); Error: nullPointer
        // myCar.tyre = new Tyre(); Error: Interface cannot create object

        myCar.tyre = new HankookTyre();
        myCar.run();

        myCar.tyre = new KumhoTyre();
        myCar.run();

        System.out.println(myCar.tyre instanceof Tyre);
        System.out.println(myCar.tyre instanceof KumhoTyre);
        System.out.println(myCar.tyre instanceof HankookTyre); // false
    }
}
