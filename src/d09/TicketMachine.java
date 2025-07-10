package d09;

public class TicketMachine {
    static int totalTickets = 0;

    void issueTicket() {
        totalTickets++;
        System.out.println("티켓 1장을 발권했습니다.");
    }

    static void printTotalTickets() {
        System.out.println("발권한 총 티켓 수: " + totalTickets);
    }
}
