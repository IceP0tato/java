package examples.ex_board.ex10.controller;

import examples.ex_board.ex10.model.dao.BoardDao;
import examples.ex_board.ex10.model.dto.BoardDto;

import java.util.ArrayList;

public class BoardController {
    private BoardController(){}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){
        return instance;
    }
    BoardDao dao = BoardDao.getInstance();

    public boolean boardWrite(String bcontent, String bwriter) {
        BoardDto boardDto = new BoardDto(bcontent, bwriter);
        return dao.boardWrite(boardDto);
    }

    public ArrayList<BoardDto> boardPrint() {
        return dao.boardPrint();
    }

    public boolean boardDelete(int bno) {
        return dao.boardDelete(bno);
    }

    public boolean boardUpdate(int bno, String bcontent) {
        BoardDto boardDto = new BoardDto(bno, bcontent, null);
        return dao.boardUpdate(boardDto);
    }
}
