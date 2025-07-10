package examples.assignment.ex4;

public class WaitingController {
    private static final Waiting[] waitings = new Waiting[100];

    public static boolean addWaiting(String phone, int count) {
        Waiting waiting = new Waiting(phone, count);

        for (int i=0; i<waitings.length; i++) {
            if (waitings[i] == null) {
                waitings[i] = waiting;
                return true;
            }
        }
        return false;
    }

    public static Waiting[] getWaitingList() {
        return waitings;
    }
}
