package examples.ex_board.ex9.view;

import examples.ex_board.ex9.controller.BoardController;
import examples.ex_board.ex9.model.dto.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {
    private BoardView(){}
    private static final BoardView instance = new BoardView();
    public static BoardView getInstance(){
        return instance;
    }
    Scanner scan = new Scanner(System.in);
    BoardController boardController = BoardController.getInstance();

    public void index() {
        for (;;) {
            System.out.println("========================");
            System.out.println("1. 등록 / 2. 전체 조회");
            System.out.println("========================");
            System.out.print("선택 > ");
            int choose = scan.nextInt();

            if (choose == 1) boardWrite();
            else if (choose == 2) boardPrint();
        }
    }

    public void boardWrite() {
        System.out.print("내용: ");
        String content = scan.next();
        System.out.print("작성자: ");
        String writer = scan.next();

        boolean result = boardController.boardWrite(content, writer);
        if (result) System.out.println("작성 완료");
        else System.out.println("작성 실패");
    }

    public void boardPrint() {
        ArrayList<BoardDto> result = boardController.boardPrint();

        for (BoardDto dto : result) {
            System.out.println("작성자: " + dto.getWriter());
            System.out.println("내용: " + dto.getContent());
            System.out.println("-------------------------------------");
        }
    }
}
