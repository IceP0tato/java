package d21;

import java.awt.*;

class 작업스레드2 extends Thread {
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i=1; i<=5; i++) {
            try {
                toolkit.beep();
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class 작업스레드1 implements Runnable {
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i=1; i<=5; i++) {
            try {
                toolkit.beep();
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

public class Example1 {
    public static void main(String[] args) {
        /*
        프로그램 : 코드(명령어)들의 집합
        프로세스 : 실행중인 프로그램
        멀티태스킹 : 두 가지 이상의 작업을 동시에 처리
        멀티 프로세스 : 운영체제가 멀티태스킹

        스레드 : 하나의 프로세스 내에서 실행되는 작업 단위
        목적 : 코드를 읽고 CPU가 처리
        예시 : main 메소드

        멀티 스레드 : 하나의 프로그램 내 멀티태스킹 (main 외 새로운 작업 스레드를 생성하여 동시 작업)
        목적 : 병렬 처리
        사용처 : 웹/앱, 채팅/첨부파일/jdbc, 동기화/비동기화 처리 등
         */

        Toolkit toolkit = Toolkit.getDefaultToolkit(); // java ui 제공 (java.awt)

        System.out.println("[1] main thread");
        for (int i=1; i<=5; i++) {
            System.out.println("[1] main thread" + i);
        }

        for (int i=1; i<=5; i++) {
            System.out.println("[1] sound");
            toolkit.beep(); // '띵' 소리 제공하는 메소드 (소리가 나는 도중에 반복문은 종료됨)
            try {
                Thread.sleep(1000); // 현재 스레드를 밀리초만큼 일시정지 (예외 처리 필요)
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // 멀티 스레드 예시
        // 1. 익명 구현체 (인터페이스 타입을 클래스 없이 직접 구현)
        // Thread thread = new Thread(new Runnable(){@Override public void run(){}});
        Runnable runnable1 = new Runnable(){
            @Override
            public void run(){ // 작업 스레드가 실행하는 최초 시작점 처리 메소드
                for (int i=1; i<=5; i++) {
                    toolkit.beep();
                }
                try {
                    Thread.sleep(1000); // 현재 스레드를 밀리초만큼 일시정지 (예외 처리 필요)
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };
        Thread thread1 = new Thread(runnable1);
        thread1.start(); // 작업 스레드 실행 (구현된 run 메소드 실행)
        for (int i=1; i<=5; i++) {
            System.out.println("[2] main thread");
            try {
                Thread.sleep(1000); // 현재 스레드를 밀리초만큼 일시정지 (예외 처리 필요)
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // 2. 구현체
        // class 작업클래스 implements Runnable{@Override public void run() {} };
        // Thread thread = new Thread(new 작업클래스());
        // thread.start();
        작업스레드1 threadTest = new 작업스레드1(); // 구현체
        Thread thread2 = new Thread(threadTest); // 구현체 대입
        thread2.start(); // 구현체를 갖는 Thread 객체 start

        // 3. 상속 (상속은 클래스당 1번, 구현은 클래스당 여러 번)
        // class 작업클래스 extends Thread{@Override public void run() {} };
        // 작업클래스 thread = new Thread();
        // thread.start();
        작업스레드2 thread3 = new 작업스레드2();
        thread3.start();
        for (int i=1; i<=5; i++) {
            System.out.println("[3] main thread");
            try {
                Thread.sleep(1000); // 현재 스레드를 밀리초만큼 일시정지 (예외 처리 필요)
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
