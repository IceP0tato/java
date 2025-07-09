package examples.ex_board.ex5;

public class BoardController {
    Board[] boards = new Board[100];

    Boolean doPost(String content, String writer) {
        Board board = new Board(content, writer);

        for (int i=0; i<boards.length; i++) {
            if (boards[i] == null) {
                boards[i] = board;
                return true;
            }
        }
        return false;
    }

    Board[] doGet() {
        return boards;
    }
}
