package examples.ex_board.ex9;

import examples.ex_board.ex9.view.BoardView;

public class AppStart {
    public static void main(String[] args) {
        BoardView.getInstance().index();

        /* BoardController bc = BoardController.getInstance();
        bc.boardWrite("안녕하세요", "유재석");
        ArrayList<BoardDto> result = bc.boardPrint();
        System.out.println(result); */
    }
}
