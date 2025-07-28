package d21;

import java.time.LocalTime;
import java.util.Scanner;

class Clock implements Runnable {
    @Override
    public void run() {
        for(;;) {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {};
        }
    }
}

class Timer extends Thread {
    boolean state = true; // 무한루프 실행 여부

    @Override
    public void run() {
        int second = 0;
        for (;;) {
            if (state == false) break;
            else {
                second++;
                System.out.println("[타이머] 지난 시간(초) : " + second);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {}
            }
        }
    }
}

public class Example2 {
    public static void main(String[] args) {
        // 시계 스레드
        Clock clock = new Clock();
        Thread thread1 = new Thread(clock);
        thread1.start();

        // 타이머 스레드
        Timer thread2 = null;

        // 메인 스레드(입력)
        for(;;) {
            System.out.println("타이머 : 1)ON 2)OFF");
            Scanner scan = new Scanner(System.in);
            int ch = scan.nextInt();
            if (ch == 1) {
                thread2 = new Timer(); // Thread 객체 생성
                thread2.start();
            } else if (ch == 2) {
                thread2.state = false;
            }
        }
    }
}
