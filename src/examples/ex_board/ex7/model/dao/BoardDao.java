package examples.ex_board.ex7.model.dao;

import examples.ex_board.ex7.model.dto.BoardDto;

// 실제 데이터가 존재하면 데이터 접근하는 기능(CRUD)
public class BoardDao {
    BoardDto[] boardDB = new BoardDto[100];

    private BoardDao() {}
    private static final BoardDao dao = new BoardDao();
    public static BoardDao getInstance() {
        return dao;
    }

    // 등록 처리
    public boolean boardWrite(BoardDto boardDto) {
        for (int i=0; i<boardDB.length; i++) {
            if (boardDB[i] == null) {
                boardDB[i] = boardDto;
                return true;
            }
        }
        return false;
    }

    public BoardDto[] boardPrint() {
        return boardDB;
    }
}
