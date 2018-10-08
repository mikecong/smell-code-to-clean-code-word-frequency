package practice4;

import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SuperParkingBoyTest {
    @Test
    public void should_park_in_first_parking_lot_when_first_parking_lot_has_higher_vacancy_rate() {
        //given
        int capacity=1;
        ParkingLot firstParkingLot = new ParkingLot(capacity);
        ParkingLot secondParkingLot = new ParkingLot(capacity);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(firstParkingLot,secondParkingLot);
        Car car = new Car();
        //when
        superParkingBoy.park(car);
        //then
        assertEquals(firstParkingLot.isFull(), true);
        assertEquals(secondParkingLot.isFull(), false);

    }

    @Test
    public void should_park_in_second_parking_lot_when_second_parking_lot_has_higher_vacancy_rate() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(firstParkingLot,secondParkingLot);
        Car car = new Car();
        //when
        superParkingBoy.park(car);
        superParkingBoy.park(new Car());
        //then
        assertEquals(firstParkingLot.isFull(), true);
        assertEquals(secondParkingLot.parkingRoomVacancyRate(), new BigDecimal(0.5));

    }

    @Test
    public void should_throw_exception_when_all_room_parked() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(firstParkingLot,secondParkingLot);
        Car car1 = new Car();
        //when
        superParkingBoy.park(car1);
        Car car2 = new Car();
        superParkingBoy.park(car2);
        //then
        assertThrows(ParkingLotFullException.class, () -> superParkingBoy.park(new Car()));

    }

    @Test
    public void should_pick_up_car_when_this_car_is_parked_by_boy() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(firstParkingLot);
        Car car1 = new Car();
        //when
        Ticket ticket = superParkingBoy.park(car1);
        Car pickUpCar = superParkingBoy.pickUp(ticket);
        //then
        assertEquals(car1, pickUpCar);
    }



}
