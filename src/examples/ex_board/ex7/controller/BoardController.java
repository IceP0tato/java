package examples.ex_board.ex7.controller;

import examples.ex_board.ex7.model.dao.BoardDao;
import examples.ex_board.ex7.model.dto.BoardDto;

public class BoardController {
    private BoardDao boardDao = BoardDao.getInstance();

    private BoardController() {}
    private static final BoardController board = new BoardController();
    public static BoardController getInstance() {
        return board;
    }

    public boolean boardWrite(String content, String writer) {
        BoardDto boardDto = new BoardDto(content, writer);
        boolean result = boardDao.boardWrite(boardDto);
        return result;
    }

    public BoardDto[] boardPrint() {
        BoardDto[] result = boardDao.boardPrint();
        return result;
    }
}
