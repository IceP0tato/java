package examples.ex_board.ex9.controller;

import examples.ex_board.ex9.model.dao.BoardDao;
import examples.ex_board.ex9.model.dto.BoardDto;

import java.util.ArrayList;

public class BoardController {
    private BoardController(){}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){
        return instance;
    }
    private BoardDao boardDao = BoardDao.getInstance();

    public boolean boardWrite(String content, String writer) {
        BoardDto boardDto = new BoardDto(content, writer);
        boolean result = boardDao.boardWrite(boardDto);
        return result;
    }

    public ArrayList<BoardDto> boardPrint() {
        ArrayList<BoardDto> result = boardDao.boardPrint();
        return result;
    }
}
