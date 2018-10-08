package practice1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    public void should_return_a_ticket_when_park_a_car() {
        int capacity = 1;
        ParkingLot parkingLot = new ParkingLot(capacity);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        assertNotNull(ticket);
    }

    @Test
    public void should_throw_parking_full_exception_when_parking_lot_is_full() {
        int capacity = 1;
        ParkingLot parkingLot = new ParkingLot(capacity);
        Car car = new Car();
        parkingLot.park(car);
        assertThrows(ParkingLotFullException.class,
                () -> parkingLot.park(new Car())
        );

    }

    @Test
    public void should_pickup_a_car_when_car_in_parking_lot() {
        int capacity = 1;
        ParkingLot parkingLot = new ParkingLot(capacity);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        Car pickUpCar = parkingLot.pickUp(ticket);
        assertEquals(car, pickUpCar);
    }

}