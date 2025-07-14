package examples.ex_board.ex8.model.dao;

import examples.ex_board.ex8.model.dto.BoardDto;

import java.util.ArrayList;

public class BoardDao {
    private ArrayList<BoardDto> boardDB = new ArrayList<>();

    private BoardDao() {}
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance() {
        return instance;
    }

    public boolean addBoard(String content, String writer) {
        boolean result = false;
        BoardDto boardDto = new BoardDto(content, writer);
        boardDB.add(boardDto);
        result = true;
        return result;
    }

    public ArrayList<BoardDto> getBoardList() {
        return boardDB;
    }
}
