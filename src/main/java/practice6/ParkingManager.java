package practice6;

import java.util.List;

public class ParkingManager {
    private final List<ParkingBoy> parkingBoyList;
    private final List<ParkingLot> parkingLotList;

    public ParkingManager(List<ParkingBoy> parkingBoyList, List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
        this.parkingBoyList = parkingBoyList;
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

    public int emptySelfEmptyParkingLot() {
        int sumSelfEmptyRoom = 0;
        for (ParkingLot parkingLot : parkingLotList) {
            sumSelfEmptyRoom += parkingLot.emptyParkingRoom();
        }
        return sumSelfEmptyRoom;
    }

    public int parkedCarCt() {
        int count = 0;
        for (ParkingLot parkingLot : parkingLotList) {
            count = +parkingLot.parkedCarCt();
        }
        for (ParkingBoy parkingBoy : parkingBoyList) {
            count += parkingBoy.parkedCarCt();
        }
        return count;
    }


    public int parkingRoomCt() {
        int count = 0;
        for (ParkingLot parkingLot : parkingLotList) {
            count = +parkingLot.parkingRoomCt();
        }
        for (ParkingBoy parkingBoy : parkingBoyList) {
            count += parkingBoy.parkingRoomCt();
        }
        return count;
    }

    public Car pickUp(Ticket ticket) {
        for (ParkingBoy parkingBoy : parkingBoyList) {
            Car car = parkingBoy.pickUp(ticket);
            if (car != null) {
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

    public String viewReport() {
        String formatStr = "M " + parkedCarCt() + " " + parkingRoomCt() + "\n";
        for (ParkingLot parkingLot : parkingLotList) {
            formatStr += " "+parkingLot.viewReport();
        }
        for (ParkingBoy parkingBoy : parkingBoyList) {
            formatStr += " " + parkingBoy.viewReport();
            for (ParkingLot parkingLot : parkingBoy.getParkingLotList()) {
                formatStr += "    " + parkingLot.viewReport();
            }
        }
        return formatStr;
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
