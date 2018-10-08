package practice5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingManagerTest {
    private double capacity = 1;
    private List<ParkingBoy> parkingBoyList;
    private List<ParkingLot> parkingLotList;

    @BeforeEach
    public void setUp() {
        this.parkingBoyList = new ArrayList<>();
        this.parkingLotList = new ArrayList<>();
        ParkingLot firstParkingLot = new ParkingLot(capacity);
        ParkingLot secondParkingLot = new ParkingLot(capacity);
        ParkingLot thirdParkingLot = new ParkingLot(capacity);
        ParkingBoy firstParkingBoy = new ParkingBoy(firstParkingLot);
        ParkingBoy secondParkingBoy = new ParkingBoy(secondParkingLot);
        parkingBoyList.add(firstParkingBoy);
        parkingBoyList.add(secondParkingBoy);
        parkingLotList.add(thirdParkingLot);
    }

    @Test
    public void should_park_one_car_success_by_parking_boy() {
        ParkingManager parkingManager = new ParkingManager(parkingBoyList, parkingLotList);
        Car car = new Car();
        Ticket ticket = parkingManager.park(car);
        assertNotNull(ticket);
        assertEquals(parkingManager.getParkingLotList().get(0).isFull(),false);
    }

    @Test
    public void should_park_one_car_success_by_self() {
        ParkingManager parkingManager = new ParkingManager(parkingBoyList, parkingLotList);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Ticket ticket1 = parkingManager.park(car1);
        Ticket ticket2 = parkingManager.park(car2);
        Ticket ticket3 = parkingManager.park(car3);
        assertEquals(parkingManager.emptySelfEmptyParkingLot(), 0);
    }


    @Test
    public void should_pick_one_car_when_parked_by_manager() {
        ParkingManager parkingManager = new ParkingManager(parkingBoyList, parkingLotList);
        Car car1 = new Car();
        Ticket ticket = parkingManager.park(car1);
        Car pickUpCar = parkingManager.pickUp(ticket);
        assertEquals(car1, pickUpCar);
    }


    @Test
    public void should_throw_exception_when_all_parking_lot_parked() {
        ParkingManager parkingManager = new ParkingManager(parkingBoyList, parkingLotList);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Ticket ticket1 = parkingManager.park(car1);
        Ticket ticket2 = parkingManager.park(car2);
        Ticket ticket3 = parkingManager.park(car3);
        assertThrows(ParkingLotFullException.class,new Executable() {
            @Override
            public void execute() throws Throwable {
                parkingManager.park(new Car());
            }
        });
    }
}
