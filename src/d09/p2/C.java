package d09.p2;

public class C {
    private int close = 10;

    // getter
    public int getClose() {
        return close;
    }

    // getter: 유효성 검사 가능
    public int getClose(String pwd) {
        if (pwd.equals("1234")) return close;
        else return 0;
    }

    // setter
    private void setClose(int close) {
        this.close = close;
    }
}
