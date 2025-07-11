package d10;

// Singleton
class Controller {
    private Controller() {

    }

    private static final Controller controller = new Controller();

    public static Controller getInstance() {
        return controller;
    }
}

public class Example1 {
    public static void main(String[] args) {
        Controller.getInstance();
    }
}
