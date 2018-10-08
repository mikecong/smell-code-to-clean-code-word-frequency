package practice2;


import java.util.Arrays;
import java.util.List;

public class ParkingBoy {
    private final List<ParkingLot> parkingLotList;
    public ParkingBoy(ParkingLot... firstParkingLot) {
        parkingLotList = Arrays.asList(firstParkingLot);
    }


    public Ticket park(Car car) {
        for (ParkingLot parkingLot : parkingLotList) {
            if (!parkingLot.isFull()) {
               return  parkingLot.park(car);
            }
        }
        throw new ParkingLotFullException();
    }

    public Car pickUp(Ticket ticket) {
        for (ParkingLot parkingLot :parkingLotList) {
            Car car = parkingLot.pickUp(ticket);
            if (car != null) {
                return car;
            }
        }
        throw new NoSuchCarException();
    }
}
