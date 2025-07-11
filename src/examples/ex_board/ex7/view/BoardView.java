package examples.ex_board.ex7.view;

import examples.ex_board.ex7.controller.BoardController;
import examples.ex_board.ex7.model.dto.BoardDto;

import java.util.Scanner;

// 게시판 관련 입출력 클래스
public class BoardView {
    // 여러 메소드에서 사용할 입력 객체
    private BoardController boardController = BoardController.getInstance();
    private Scanner scan = new Scanner(System.in);

    private BoardView() {}
    private static final BoardView view = new BoardView();
    public static BoardView getInstance() {
        return view;
    }

    public void index() {
        for (;;) {
            System.out.println("============= My Community =============");
            System.out.println("  1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int num = scan.nextInt();
            if (num == 1) boardWrite();
            else if (num == 2) boardPrint();
        }
    }

    public void boardWrite() {
        System.out.print("작성자 : ");
        String writer = scan.next();
        System.out.print("내용 : ");
        String content = scan.next();

        boolean result = boardController.boardWrite(content, writer);
        if (result) System.out.println("[안내] 글쓰기 성공");
        else System.out.println("[경고] 게시물을 등록할 공간이 부족합니다.");
    }

    public void boardPrint() {
        System.out.println("============= 게시물 목록 =============");
        BoardDto[] result = boardController.boardPrint();
        for (int i=0; i<result.length; i++) {
            BoardDto boardDto = result[i];
            if (boardDto != null) {
                System.out.println("작성자 : " + boardDto.getWriter());
                System.out.println("내용 : " + boardDto.getContent());
                System.out.println("------------------------------------");
            }
        }
    }
}
