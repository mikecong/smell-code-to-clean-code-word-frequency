package practice2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ParkingBoyTest {
    @Test
    public void should_park_into_first_parking_lot() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot);
        Car car = new Car();
        parkingBoy.park(car);
        assertEquals(firstParkingLot.isFull(), true);
        assertEquals(secondParkingLot.isFull(), false);
    }

    @Test
    public void should_park_into_second_parking_lot() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot);
        Car car1 = new Car();
        parkingBoy.park(car1);
        Car car2 = new Car();
        parkingBoy.park(car2);
        assertEquals(firstParkingLot.isFull(), true);
        assertEquals(secondParkingLot.isFull(), true);
    }

    @Test
    public void should_throw_full_exception_when_all_parking_lot_full() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot);
        Car car1 = new Car();
        parkingBoy.park(car1);
        Car car2 = new Car();
        parkingBoy.park(car2);
        assertThrows(ParkingLotFullException.class,()-> parkingBoy.park(new Car()));
    }

    @Test
    public void should_pickup_car_from_first_parking_lot_when_parking_in_first_parking_lot() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot);
        Car car1 = new Car();
        Ticket ticket = parkingBoy.park(car1);
        assertEquals(firstParkingLot.isFull(), true);
        assertEquals(car1,parkingBoy.pickUp(ticket));
        assertEquals(firstParkingLot.isFull(), false);
    }
}

