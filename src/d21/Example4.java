package d21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example4 {
    public static void main(String[] args) {
        // 스레드풀 : 미리 일정 개수의 스레드를 생성하고 필요에 따라 재사용하는 방식
        // 작업이 들어올 때마다 기존 스레드 이용 (스레드 재사용, 자원 효율성, 과부하 방지 등)
        // 작업의 요청을 '큐' 자료구조로 배치하여 순서대로 스레드풀에서 대기중인 스레드에게 작업 배정
        // 사용처 : 톰캣, jdbc, 업로드/다운로드, 채팅

        // nThreads : 스레드풀에 저장할 스레드 수
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i=1; i<=3; i++) {
            String name = "Thread" + i;
            // 익명 구현체
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try { Thread.sleep(2000); }
                    catch (Exception e) {}
                    System.out.println("Task Thread : " + name);
                }
            };
            // 생성된 스레드를 스레드풀에 삽입 (실행 순서는 개발자가 정할 수 없음)
            executorService.submit(runnable);
        }
        // 스레드풀 종료
        executorService.shutdown();
    }
}
