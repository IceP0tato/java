package examples.assignment.ex3;

public class WaitingController {
    examples.assignment.ex3.Waiting[] waitings = new examples.assignment.ex3.Waiting[100];

    boolean addWaiting(String phone, int count) {
        examples.assignment.ex3.Waiting waiting = new examples.assignment.ex3.Waiting();
        waiting.phone = phone;
        waiting.count = count;

        for (int i=0; i<waitings.length; i++) {
            if (waitings[i] == null) {
                waitings[i] = waiting;
                return true;
            }
        }
        return false;
    }

    Waiting[] getWaitingList() {
        return waitings;
    }
}
