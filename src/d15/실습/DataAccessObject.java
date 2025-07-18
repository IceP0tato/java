package d15.실습;

public interface DataAccessObject {
    default void save() {
        System.out.println("데이터를 저장합니다.");
    }
}

class OracleDao implements DataAccessObject {
    public void save() {
        System.out.println("Oracle DB에 저장");
    }
}

class MySqlDao implements DataAccessObject {
    public void save() {
        System.out.println("MySQL DB에 저장");
    }
}