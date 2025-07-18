package d15.실습;

public interface Greeting {
    default void welcome() {
        System.out.println("[Interface] 환영합니다.");
    }
}
