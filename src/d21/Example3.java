package d21;

class User1 extends Thread {
    public Calculator calculator;

    @Override
    public void run() {
        calculator.setMemory(100);
    }
}

class User2 extends Thread {
    public Calculator calculator;

    @Override
    public void run() {
        calculator.setMemory(200);
    }
}

class Calculator {
    public int memory;
    public synchronized void setMemory(int memory) { // 동기화된 메소드
        this.memory = memory; // 매개변수 대입
        try { Thread.sleep(2000); } // 2초 간 일시정지
        catch (Exception e) {}
        System.out.println(this.memory); // 멤버변수 확인
    }
}

public class Example3 {
    public static void main(String[] args) {
        // 동기화/비동기화
        Calculator calculator = new Calculator(); // 계산기 객체 하나 생성

        User1 user1 = new User1();
        user1.calculator = calculator;
        User2 user2 = new User2();
        user2.calculator = calculator; // user1과 같은 객체 (두 스레드는 동일한 객체 정보를 가짐)

        user1.start(); // 200 -> synchronized : 100
        user2.start(); // 200 -> synchronized : 200

        // [synchronized] 동기화 : 메소드에 lock을 사용하여 메소드를 점령함
        // 여러 스레드가 동시에 하나의 스레드를 사용하면 멤버변수 충돌이 생길 수 있음
        // 그래서 먼저 메소드를 호출한 순서대로 처리할 수 있도록 처리 순서 보장 (처리할 때까지 다른 스레드는 await(대기) 상태가 됨)
        // 사용법1 : 메소드 선언부의 반환타입 앞에 'synchronized' 삽입
        // 사용법2 : synchronized(this){} 블럭 이용
    }
}
