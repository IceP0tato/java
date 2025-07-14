package examples.ex_board.ex8.view;

import examples.ex_board.ex8.controller.BoardController;
import examples.ex_board.ex8.model.dto.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {
    private BoardController boardController = BoardController.getInstance();
    Scanner scan = new Scanner(System.in);

    private BoardView() {}
    private static final BoardView instance = new BoardView();
    public static BoardView getInstance() {
        return instance;
    }

    public void index() {
        for (;;) {
            System.out.println("============= My Community =============");
            System.out.println("  1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int num = scan.nextInt();

            if (num == 1) addBoard();
            else if (num == 2) getBoardList();
        }
    }

    public void addBoard() {
        System.out.print("내용 : ");
        String content = scan.next();
        System.out.print("작성자 : ");
        String writer = scan.next();

        boolean result = boardController.addBoard(content, writer);
        if (result == true) System.out.println("[안내] 글쓰기 성공");
        else System.out.println("[경고] 글쓰기 실패");
    }

    public void getBoardList() {
        System.out.println("============= 게시물 목록 =============");
        ArrayList<BoardDto> result = boardController.getBoardList();
        for (int i=0; i<result.size(); i++) {
            BoardDto board = result.get(i);
            System.out.println("작성자 : " + board.getWriter());
            System.out.println("내용 : " + board.getContent());
            System.out.println("------------------------------------");
        }
    }
}
