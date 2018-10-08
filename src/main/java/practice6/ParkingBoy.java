package practice6;

import java.util.Arrays;
import java.util.List;

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

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public int parkedCarCt() {
        int count = 0;
        for (ParkingLot parkingLot : parkingLotList) {
            count += parkingLot.parkedCarCt();
        }
        return count;
    }

    public int parkingRoomCt() {
        int count = 0;
        for (ParkingLot parkingLot : parkingLotList) {
            count += parkingLot.parkingRoomCt();
        }
        return count;
    }


    public String viewReport() {
        return  "B"+" "+parkedCarCt()+" "+parkingRoomCt()+"\n";
    }
}
