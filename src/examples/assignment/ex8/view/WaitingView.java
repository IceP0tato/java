package examples.assignment.ex8.view;

import examples.assignment.ex8.controller.WaitingController;
import examples.assignment.ex8.model.dto.WaitingDto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WaitingView {
    private WaitingView() {}
    private static final WaitingView instance = new WaitingView();
    public static WaitingView getInstance() {
        return instance;
    }
    Scanner scan = new Scanner(System.in);
    WaitingController controller = WaitingController.getInstance();

    public void index() {
        for (;;) {
            try {
                System.out.println("\n===================== 맛집 대기 시스템 =========================");
                System.out.println("1. 대기 등록 | 2. 대기 현황 조회 | 3. 대기 취소 | 4. 대기 인원수 수정");
                System.out.println("==============================================================");
                System.out.print("선택 > ");
                int choice = scan.nextInt();

                if (choice == 1) waitingInsert();
                else if (choice == 2) waitingSelect();
                else if (choice == 3) waitingDelete();
                else if (choice == 4) waitingUpdate();
                else System.out.println("[경고] 존재하지 않는 기능입니다. 다시 입력해주세요.");
            } catch (InputMismatchException e) {
                System.out.println("[경고] 숫자를 입력해주세요.");
                scan = new Scanner(System.in);
            } catch (Exception e) {
                System.out.println("[경고] 알 수 없는 오류가 발생했습니다. 관리자에게 문의해주세요.");
                throw new RuntimeException(e);
            }
        }
    }

    public void waitingInsert() {
        System.out.println("\n===================== 대기 등록 =====================");
        System.out.print("연락처를 입력해주세요: ");
        String phone = scan.next();
        System.out.print("예약하는 인원수를 입력해주세요: ");
        int count = scan.nextInt();

        boolean result = controller.waitingInsert(phone, count);
        if (result) System.out.println("[안내] 대기 정보가 등록되었습니다.");
        else System.out.println("[경고] 대기 정보를 등록하지 못했습니다.");
    }

    public void waitingSelect() {
        System.out.println("\n===================== 대기 현황 조회 =====================");
        ArrayList<WaitingDto> list = controller.waitingSelect();
        for (WaitingDto dto : list) {
            System.out.printf("대기번호: %d, 연락처: %s, 인원수: %d\n", dto.getNum(), dto.getPhone(), dto.getCount());
            System.out.println("------------------------------------------------------");
        }
    }

    public void waitingDelete() {
        System.out.println("\n===================== 대기 취소 =====================");
        System.out.print("대기번호를 입력해주세요: ");
        int num = scan.nextInt();

        boolean result = controller.waitingDelete(num);
        if (result) System.out.println("[안내] 대기 정보가 삭제되었습니다.");
        else System.out.println("[경고] 대기 정보를 삭제하지 못했습니다.");
    }

    public void waitingUpdate() {
        System.out.println("\n===================== 대기 인원수 수정 =====================");
        System.out.print("대기번호를 입력해주세요: ");
        int num = scan.nextInt();
        System.out.print("예약하는 인원수를 입력해주세요: ");
        int count = scan.nextInt();

        boolean result = controller.waitingUpdate(num, count);
        if (result) System.out.println("[안내] 대기 정보가 수정되었습니다.");
        else System.out.println("[경고] 대기 정보를 수정하지 못했습니다.");
    }
}
