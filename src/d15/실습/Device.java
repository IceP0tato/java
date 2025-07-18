package d15.실습;

public interface Device {
    void turnOn();
    void turnOff();
    public default void setMute(boolean mute) {
        System.out.println("무음 처리합니다.");
    }
}

class Television implements Device {
    public void turnOn() {
        System.out.println("전원을 켭니다.");
    }

    public void turnOff() {
        System.out.println("전원을 끕니다.");
    }
}