package d15.실습;

public interface Attackable {
    default void attack() {
        System.out.println("공격!");
    }
}

class Character {
    void useWeapon(Attackable weapon) {
        weapon.attack();
    }
}

class Sword implements Attackable {
    public void attack() {
        System.out.println("검으로 공격!");
    }
}

class Gun implements Attackable {
    public void attack() {
        System.out.println("총으로 공격!");
    }
}