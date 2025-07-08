package examples.ex_board.ex4;

public class BoardController {
    Board[] boards = new Board[100];

    Boolean doPost(String content, String writer) {
        Board board = new Board();
        board.content = content;
        board.writer = writer;

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
