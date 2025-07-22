package examples.assignment.ex7.view;

import examples.assignment.ex7.controller.WaitingController;
import examples.assignment.ex7.model.dto.WaitingDto;

import java.util.ArrayList;
import java.util.Scanner;

public class WaitingView {
    private WaitingView() {}
    private static final WaitingView instance = new WaitingView();
    public static WaitingView getInstance() {
        return instance;
    }
    Scanner scan = new Scanner(System.in);
    private WaitingController controller = WaitingController.getInstance();

    public void index() {
        for (;;) {
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int num = scan.nextInt();

            if (num == 1) waitingAdd();
            else if (num == 2) waitingShow();
        }
    }

    public void waitingAdd() {
        System.out.print("전화번호 : ");
        String phone = scan.next();
        System.out.print("인원수 : ");
        int count = scan.nextInt();

        boolean result = controller.waitingAdd(phone, count);
        if (result) System.out.println("[안내] 대기 등록이 완료되었습니다.\n");
        else System.out.println("[경고] 대기 등록이 실패하였습니다.\n");
    }

    public void waitingShow() {
        System.out.println("============= 대기 현황 =============");
        ArrayList<WaitingDto> waitingList = controller.waitingShow();
        for (WaitingDto dto : waitingList) {
            System.out.printf("연락처 : %s - 인원 : %d명\n", dto.getPhone(), dto.getCount());
            System.out.println("------------------------------------");
        }
        System.out.print("\n");
    }
}
