package examples.ex_board.ex8.controller;

import examples.ex_board.ex8.model.dao.BoardDao;
import examples.ex_board.ex8.model.dto.BoardDto;

import java.util.ArrayList;

public class BoardController {
    private BoardDao boardDao = BoardDao.getInstance();

    private BoardController() {}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance() {
        return instance;
    }

    public boolean addBoard(String content, String writer) {
        boolean result = boardDao.addBoard(content, writer);
        return result;
    }

    public ArrayList<BoardDto> getBoardList() {
        return boardDao.getBoardList();
    }
}
