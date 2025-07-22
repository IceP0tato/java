package d17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
    private Dao() {
        openDB();
    }
    private static final Dao instance = new Dao();
    public static Dao getInstance() {
        return instance;
    }

    private String db_url = "jdbc:mysql://localhost:3306/mydb0722";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;

    public void openDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, db_user, db_password);
        } catch (ClassNotFoundException e) {
            System.out.println("데이터베이스 연동 실패");
        } catch (SQLException e) {
            System.out.println("SQL 연동 실패");
        }
    }


}
