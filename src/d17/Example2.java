package d17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Example2 {
    public static void main(String[] args) {
        // JDBC (Java DataBase Connect)
        // MySQL - Connector/J - .jar file

        // 데이터베이스 연동
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String db_url = "jdbc:mysql://localhost:3306/mydb0722", db_user = "root", db_password = "1234";
            // DriverManager: DB 연동 클래스(구현체)
            // DB 연동 함수 (서버 주소, 계정명, 비밀번호)
            Connection conn = DriverManager.getConnection(db_url, db_user, db_password);
            System.out.println("데이터베이스 연동 완료");

            // SQL 쿼리문
            String sql = "insert into test values('안녕하세요.')";
            // 지정된 SQL을 연동된 인터페이스에 대입
            PreparedStatement ps = conn.prepareStatement(sql);
            // SQL 실행 (데이터베이스에 누적됨)
            ps.execute();
            // ResultSet rs = ps.executeQuery(); SELECT 문법 실행 -> 실행 결과를 ResultSet 타입 반환
            // int count = ps.executeUpdate(); INSERT, UPDATE, DELETE 문법 실행 -> int 타입 (영향받은 개수) 반환

            // ResultSet: SQL 결과 조작
            // rs.next(); 조회된 레코드 중에서 다음 레코드로 이동
            // rs.getXXX/* XXX: 적절한 자바타입 getInt, getDouble 등 */(속성명); 현재 레코드에서 지정한 속성명의 값 반환

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 연동 실패");
        } catch (SQLException e) {
            System.out.println("데이터베이스 연동 실패");
        }
    }
}
