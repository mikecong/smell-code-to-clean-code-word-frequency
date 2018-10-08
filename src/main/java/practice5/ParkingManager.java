package practice5;

import java.util.List;

public class ParkingManager {
    private final List<ParkingBoy> parkingBoyList;
    private final List<ParkingLot> parkingLotList;

    public ParkingManager(List<ParkingBoy> parkingBoyList, List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
        this.parkingBoyList =parkingBoyList;
    }

    public Ticket park(Car car) {
        for (ParkingBoy parkingBoy : parkingBoyList) {
            if (!parkingBoy.isFull()) {
                return parkingBoy.park(car);
            }
        }
        for (ParkingLot parkingLot : parkingLotList) {
            if (!parkingLot.isFull()) {
                return parkingLot.park(car);
            }
        }
        throw new ParkingLotFullException();
    }

    public List<ParkingBoy> getParkingBoyList() {
        return parkingBoyList;
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public double emptySelfEmptyParkingLot() {
        double sumSelfEmptyRoom = 0;
        for (ParkingLot parkingLot : parkingLotList) {
            sumSelfEmptyRoom += parkingLot.emptyParkingRoom();
        }
        return sumSelfEmptyRoom;
    }

    public double emptySelfParkingBoyEmptyParkingLot() {
        double sumSelfParkingBoyEmptyRoom = 0;
        for (ParkingBoy parkingBoy : parkingBoyList) {
            sumSelfParkingBoyEmptyRoom += parkingBoy.emptyParkingRoom();
        }
        return sumSelfParkingBoyEmptyRoom;
    }

    public Car pickUp(Ticket ticket) {
        for (ParkingBoy parkingBoy : parkingBoyList) {
            Car car = parkingBoy.pickUp(ticket);
            if (car !=null) {
                return car;
            }
        }
        for (ParkingLot parkingLot : parkingLotList) {
            Car car = parkingLot.pickUp(ticket);
            if (car != null) {
                return car;
            }
        }
        throw new NoSuchCarException();
    }


    //    private boolean isFull() {
//        for (ParkingBoy parkingBoy : parkingBoyList) {
//            if (!parkingBoy.isFull()) {
//                return false;
//            }
//        }
//        for (ParkingLot parkingLot : parkingLotList) {
//            if (!parkingLot.isFull()) {
//                return false;
//            }
//        }
//        return true;
//    }
}
