package practice4;

import java.util.Arrays;
import java.util.List;

public class SuperParkingBoy {
    private final List<ParkingLot> parkingLotList;

    public SuperParkingBoy(ParkingLot... parkingLotList) {
        this.parkingLotList = Arrays.asList(parkingLotList);
    }


    public Ticket park(Car car) {
        parkingLotList.sort((p1, p2) -> p2.parkingRoomVacancyRate().compareTo(p1.parkingRoomVacancyRate()));
        ParkingLot parkingLot = parkingLotList.get(0);
        if (!parkingLot.isFull()) {
            return parkingLot.park(car);
        }
        throw new ParkingLotFullException();
    }

    public Car pickUp(Ticket ticket) {
        for (ParkingLot parkingLot :parkingLotList) {
            Car car = parkingLot.getTicketCarMap().get(ticket);
            if (car !=null) {
                return car;
            }
        }
        throw new NoSuchCarException();
    }
}
