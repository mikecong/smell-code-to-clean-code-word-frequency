package practice6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ParkingDirectorTest {
     private  ParkingDirector parkingDirector;

    @BeforeEach
    public void setUp() {
        ParkingLot firstParkingLot = new ParkingLot(3);
        ParkingLot secondParkingLot = new ParkingLot(2);
        secondParkingLot.park(new Car());
        ParkingBoy firstParkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot);

        ParkingLot thirdParkingLot = new ParkingLot(5);
        thirdParkingLot.park(new Car());
        thirdParkingLot.park(new Car());
        ParkingBoy secondParkingBoy = new ParkingBoy(thirdParkingLot);

        ParkingLot fourthParkingLot = new ParkingLot(10);
        fourthParkingLot.park(new Car());
        fourthParkingLot.park(new Car());

        List<ParkingBoy> parkingBoyList = new ArrayList<>();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingBoyList.add(secondParkingBoy);
        parkingBoyList.add(firstParkingBoy);
        parkingLotList.add(fourthParkingLot);

        ParkingManager parkingManager = new ParkingManager(parkingBoyList, parkingLotList);
        List<ParkingManager> parkingManagerList = new ArrayList<>();
        parkingManagerList.add(parkingManager);
        parkingDirector = new ParkingDirector(parkingManagerList);
    }

    @Test
    public void viewReport() {
        System.out.println(parkingDirector.viewReport());
    }
}