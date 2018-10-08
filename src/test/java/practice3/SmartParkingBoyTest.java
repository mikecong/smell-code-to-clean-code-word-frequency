package practice3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartParkingBoyTest {
    @Test
    public void should_park_in_first_parking_lot_when_first_parking_lot_has_more_empty_room() {
        //given
        int capacity=1;
        ParkingLot firstParkingLot = new ParkingLot(capacity);
        ParkingLot secondParkingLot = new ParkingLot(capacity);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(firstParkingLot,secondParkingLot);
        Car car = new Car();
        //when
        smartParkingBoy.park(car);
        //then
        assertEquals(firstParkingLot.isFull(), true);
        assertEquals(secondParkingLot.isFull(), false);

    }

    @Test
    public void should_park_in_second_parking_lot_when_second_parking_lot_has_more_empty_room() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(firstParkingLot,secondParkingLot);
        Car car = new Car();
        //when
        smartParkingBoy.park(car);
        //then
        assertEquals(firstParkingLot.isFull(), false);
        assertEquals(secondParkingLot.emptyParkingRoom(), 1);

    }

    @Test
    public void should_throw_exception_when_all_room_parked() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(firstParkingLot,secondParkingLot);
        Car car1 = new Car();
        //when
        smartParkingBoy.park(car1);
        Car car2 = new Car();
        smartParkingBoy.park(car2);
        //then
        assertThrows(ParkingLotFullException.class, () -> smartParkingBoy.park(new Car()));

    }

    @Test
    public void should_pick_up_car_when_this_car_is_parked_by_boy() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(firstParkingLot);
        Car car1 = new Car();
        //when
        Ticket ticket = smartParkingBoy.park(car1);
        Car pickUpCar = smartParkingBoy.pickUp(ticket);
        //then
        assertEquals(car1, pickUpCar);
    }

}
