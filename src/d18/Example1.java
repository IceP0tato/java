package d18;

public class Example1 {
    public static void main(String[] args) {
        Dao dao = Dao.getInstance();

        dao.userInsert();
        dao.userInsert2("강호동", 30);
        dao.userInsert2("신동엽", 25);

        dao.userSelect();
    }
}
