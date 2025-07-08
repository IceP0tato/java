package d07;

public class Product {
    String name;
    int stock;

    boolean sell(int x) {
        if (stock >= x) {
            stock -= x;
            return true;
        } else {
            System.out.println("재고 부족");
            return false;
        }
    }
}
