package examples.assignment.ex_adv4.model.dao;

import examples.assignment.ex_adv4.model.dto.WaitingDto;

import java.sql.*;
import java.util.ArrayList;

public class WaitingDao {
    private WaitingDao() { openDB(); }
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance() {
        return instance;
    }
    private ArrayList<WaitingDto> waitingList = new ArrayList<>();
    private Connection conn;

    // 입력: phone, count 추가
    public boolean waitingAdd(WaitingDto waitingDto) {
        waitingList.add(waitingDto);
        saveDB(waitingDto);
        return true;
    }

    // 출력: waitingList 반환
    public ArrayList<WaitingDto> waitingShow() {
        return waitingList;
    }

    // DB 연동
    public void openDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ex_advanced";
            String id = "root";
            String pw = "1234";
            conn = DriverManager.getConnection(url, id, pw);
            loadDB();
        } catch (ClassNotFoundException e) {
            System.out.println("[경고] 데이터베이스 연동에 실패하였습니다.");
        } catch (SQLException e) {
            System.out.println("[경고] 데이터베이스 접근 중 문제가 발생했습니다.");
        }
    }

    // DB에 있는 데이터 가져오기
    public void loadDB() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from waitingList";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String phone = rs.getString("phone");
                int count = rs.getInt("count");
                WaitingDto waitingDto = new WaitingDto(phone, count);
                waitingList.add(waitingDto);
            }
        } catch (Exception e) {
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

    // DB에 데이터 저장하기
    public void saveDB(WaitingDto waitingDto) {
        PreparedStatement ps = null;
        try {
            // Phone은 작은따옴표로 묶어 정수형으로 계산이 되지 않도록, 문자열로 처리
            String sql = "insert into waitingList values('" + waitingDto.getPhone() + "', " + waitingDto.getCount() + ")";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
