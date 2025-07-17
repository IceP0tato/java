package d14.실습;

public class Weapon {
    void attack() {
        System.out.println("무기로 공격합니다.");
    }
}

class Sword extends Weapon {
    void attack() {
        System.out.println("검으로 공격합니다.");
    }
}

class Gun extends Weapon {
    void attack() {
        System.out.println("총으로 공격합니다.");
    }
}

class Character extends Weapon {
    void use(Weapon weapon) {
        weapon.attack();
    }
}