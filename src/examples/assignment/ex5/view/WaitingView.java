package examples.assignment.ex5.view;

import examples.assignment.ex5.controller.WaitingController;
import examples.assignment.ex5.model.dto.WaitingDto;

import java.util.Scanner;

public class WaitingView {
    private WaitingController controller = WaitingController.getInstance();
    private Scanner scan = new Scanner(System.in);

    private WaitingView() {}
    private static final WaitingView view = new WaitingView();
    public static WaitingView getInstance() {
        return view;
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

        boolean check = controller.addWaiting(phone, count);
        if (check) System.out.println("[안내] 대기 등록이 완료되었습니다.\n");
        else System.out.println("[경고] 더 이상 대기 등록을 할 수 없습니다.\n");
    }

    public void getWaitingList() {
        System.out.println("============= 대기 현황 =============");
        WaitingDto[] result = controller.getWaitingList();
        for (int i=0; i<result.length; i++) {
            if (result[i] != null) {
                System.out.printf("1. 연락처: %s - 인원: %d명\n", result[i].getPhone(), result[i].getCount());
                System.out.println("------------------------------------");
            }
        }
    }
}
