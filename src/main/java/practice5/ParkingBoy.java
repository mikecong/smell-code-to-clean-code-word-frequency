package practice5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ParkingBoy {
    private final List<ParkingLot> parkingLotList;

    public ParkingBoy(ParkingLot... parkingLotList) {
        this.parkingLotList = Arrays.asList(parkingLotList);
    }


    public Ticket park(Car car) {
        for (ParkingLot parkingLot : parkingLotList) {
            if (!parkingLot.isFull()) {
                return parkingLot.park(car);
            }
        }
        throw new ParkingLotFullException();
    }

    public Car pickUp(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLotList) {
            Car car = parkingLot.getTicketCarMap().get(ticket);
            if (car != null) {
                return car;
            }
        }
        throw new NoSuchCarException();
    }

    public boolean isFull() {
        for (ParkingLot parkingLot : parkingLotList) {
            if (!parkingLot.isFull()) {
                return false;
            }
        }
        return true;
    }

    public double emptyParkingRoom() {
        double selfEmptyParkingRoom = 0;
        for (ParkingLot parkingLot : parkingLotList) {
            selfEmptyParkingRoom += parkingLot.emptyParkingRoom();
        }
        return selfEmptyParkingRoom;
    }
}
