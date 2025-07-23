package d18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
    private String db_url = "jdbc:mysql://localhost:3306/mydb0723";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;

    private Dao() { connect(); }
    private static final Dao instance = new Dao();
    public static Dao getInstance() {
        return instance;
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, db_user, db_password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean userInsert() {
        try {
            String sql = "insert into user(uname, uage) values('유재석', 40);";
            PreparedStatement ps = conn.prepareStatement(sql);
            int count = ps.executeUpdate();
            System.out.println(count);
            return count >= 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean userInsert2(String uname, int uage) {
        try {
            // ? : sql 매개변수
            String sql = "insert into user(uname, uage) values(?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            // 매개변수 설정 (ps.setXXX(?의 번호, 값))
            ps.setString(1, uname); // 첫 번에 ?에 uname을 String 타입으로 대입
            ps.setInt(2, uage); // 두 번째 ?에 uage를 int 타입으로 대입

            int count = ps.executeUpdate();
            System.out.println(count);
            return count >= 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public void userSelect() {
        try {
            String sql = "select * from user";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) { // 전체 순회 (rs.next() : 조회 결과에서 레코드 하나씩 조회)
                // rs.getXXX(속성명 또는 순서번호) : 값 가져오기
                System.out.printf("번호 : %d, 이름 : %s, 나이 : %d\n", rs.getInt(1), rs.getString(2), rs.getInt(3));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
