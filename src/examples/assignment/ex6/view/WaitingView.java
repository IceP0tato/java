package examples.assignment.ex6.view;

import examples.assignment.ex6.controller.WaitingController;
import examples.assignment.ex6.model.dto.WaitingDto;

import java.util.ArrayList;
import java.util.Scanner;

public class WaitingView {
    private WaitingController controller = WaitingController.getInstance();
    private Scanner scan = new Scanner(System.in);

    private WaitingView() {}
    private static final WaitingView instance = new WaitingView();
    public static WaitingView getInstance() {
        return instance;
    }

    public void index() {
        for (;;) {
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("  1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int num = scan.nextInt();

            if (num == 1) addWaiting();
            else if (num == 2) getWaitingList();
        }
    }

    public void addWaiting() {
        System.out.print("전화번호 : ");
        String phone = scan.next();
        System.out.print("인원수 : ");
        int count = scan.nextInt();

        boolean result = controller.addWaiting(phone, count);
        if (result) System.out.println("[안내] 대기 등록이 완료되었습니다.\n");
        else System.out.println("[경고] 대기 등록에 실패하였습니다.\n");
    }

    public void getWaitingList() {
        System.out.println("============= 대기 현황 =============");
        ArrayList<WaitingDto> result = controller.getWaitingList();
        for (int i=0; i<result.size(); i++) {
            WaitingDto list = result.get(i);
            System.out.printf("%d. 연락처: %s - 인원: %d명\n", i+1, list.getPhone(), list.getCount());
            System.out.println("------------------------------------");
        }
    }
}
