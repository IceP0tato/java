package d07;

public class ParkingLot {
    int calculateFee(int x) {
        int fee = (x-30)/10 * 500 + 1000;

        if (x <= 30) return 1000;
        else if (fee >= 20000) return 20000;
        else return fee;
    }
}
