package examples.ex_board.ex10.model.dao;

import examples.ex_board.ex10.model.dto.BoardDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDao {
    private BoardDao(){ connect(); }
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){
        return instance;
    }
    private String db_url = "jdbc:mysql://localhost:3306/exam10";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;

    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, db_user, db_password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean boardWrite(BoardDto boardDto) {
        try {
            String sql = "insert into board(bcontent, bwriter) values(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBcontent());
            ps.setString(2, boardDto.getBwriter());
            int count = ps.executeUpdate();
            return count >= 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<BoardDto> boardPrint() {
        ArrayList<BoardDto> list = new ArrayList<>();
        try {
            String sql = "select * from board";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int bno = rs.getInt("bno");
                String bcontent = rs.getString("bcontent");
                String bwriter = rs.getString("bwriter");
                BoardDto boardDto = new BoardDto(bno, bcontent, bwriter);
                list.add(boardDto);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean boardDelete(int bno) {
        try {
            String sql = "delete from board where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bno);

            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean boardUpdate(BoardDto boardDto) {
        try {
            String sql = "update board set bcontent = ? where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBcontent());
            ps.setInt(2, boardDto.getBno());

            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
