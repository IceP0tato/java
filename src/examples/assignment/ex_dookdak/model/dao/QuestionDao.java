package examples.assignment.ex_dookdak.model.dao;

import examples.assignment.ex_dookdak.model.dto.ProductDto;
import examples.assignment.ex_dookdak.model.dto.QuestionDto;

import java.sql.*;
import java.util.ArrayList;

public class QuestionDao {
    private QuestionDao() { connect(); }
    private static final QuestionDao instance = new QuestionDao();
    public static QuestionDao getInstance() {
        return instance;
    }
    private ArrayList<QuestionDto> questionList = new ArrayList<>();
    private Connection conn;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dookdak", "root", "1234");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addQuestion(QuestionDto dto) {
        PreparedStatement ps = null;
        try {
            String sql = "insert into question(pId, qUser, qDesc, qPw) values (?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dto.getpId());
            ps.setString(2, dto.getqUser());
            ps.setString(3, dto.getqDesc());
            ps.setString(4, dto.getqPw());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("[경고] 데이터 입력 중 오류가 발생하였습니다. 관리자에게 문의해주세요.");
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<QuestionDto> detailProduct(int pId) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from question join product on question.pId = product.pId where question.pId = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pId);
            rs = ps.executeQuery();

            while (rs.next()) {
                String qUser = rs.getString("qUser");
                String qDesc = rs.getString("qDesc");
                QuestionDto list = new QuestionDto(qUser, qDesc);
                questionList.add(list);
            }
            return questionList;
        } catch (SQLException e) {
            System.out.println("[경고] 데이터 입력 중 오류가 발생하였습니다. 관리자에게 문의해주세요.");
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) ps.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
