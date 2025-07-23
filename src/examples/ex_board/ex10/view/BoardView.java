package examples.ex_board.ex10.view;

import examples.ex_board.ex10.controller.BoardController;
import examples.ex_board.ex10.model.dto.BoardDto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardView {
    private BoardView(){}
    private static final BoardView instance = new BoardView();
    public static BoardView getInstance(){
        return instance;
    }
    Scanner scan = new Scanner(System.in);
    BoardController controller = BoardController.getInstance();

    public void index() {
        for (;;) {
            try {
                System.out.println("============= My Community =============");
                System.out.println("  1.게시물쓰기 | 2.게시물출력 | 3.게시물삭제 | 4.게시물수정 ");
                System.out.println("========================================");
                System.out.print("선택 > ");
                int num = scan.nextInt();

                if (num == 1) boardWrite();
                else if (num == 2) boardPrint();
                else if (num == 3) boardDelete();
                else if (num == 4) boardUpdate();
                else System.out.println("[경고] 존재하지 않는 기능입니다.");
            } catch (InputMismatchException e) {
                System.out.println("[경고] 숫자를 입력해주세요.");
                scan = new Scanner(System.in); // 입력에 따른 입력 객체 초기화
            } catch (Exception e) {
                System.out.println("[경고] 오류가 발생하였습니다. 관리자에게 문의해주세요.");
            }
        }
    }

    public void boardWrite() {
        System.out.print("내용 : ");
        scan.nextLine(); // 내용이 바로 넘어가지 않도록 추가
        String bcontent = scan.nextLine();
        System.out.print("작성자 : ");
        String bwriter = scan.next();

        boolean result = controller.boardWrite(bcontent, bwriter);
        if (result) System.out.println("[안내] 글쓰기 성공");
        else System.out.println("[경고] 글쓰기 실패");
    }

    public void boardPrint() {
        System.out.println("============= 게시물 목록 =============");
        ArrayList<BoardDto> list = controller.boardPrint();
        for (BoardDto dto : list) {
            System.out.println("작성자 : " + dto.getBwriter());
            System.out.println("내용 : " + dto.getBcontent());
            System.out.println("------------------------------------");
        }
    }

    public void boardDelete() {
        System.out.print("삭제할 번호 : ");
        int bno = scan.nextInt();

        boolean result = controller.boardDelete(bno);
        if (result) System.out.println("[안내] 삭제 성공");
        else System.out.println("[경고] 삭제 실패");
    }

    public void boardUpdate() {
        System.out.print("수정할 번호 : ");
        int bno = scan.nextInt();
        System.out.print("새로운 내용 : ");
        scan.nextLine();
        String bcontent = scan.nextLine();

        boolean result = controller.boardUpdate(bno, bcontent);
        if (result) System.out.println("[안내] 수정 성공");
        else System.out.println("[경고] 수정 실패");
    }
}
