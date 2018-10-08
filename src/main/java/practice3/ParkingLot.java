package practice3;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private final Map<Ticket, Car> ticketCarMap = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket, car);
        return ticket;
    }

    public Car pickUp(Ticket ticket) {
        Car car = new Car();
        return car;
    }

    public boolean isFull() {
        return capacity - ticketCarMap.size() == 0;
    }

    public int emptyParkingRoom() {
        return capacity - ticketCarMap.size();
    }

    public Map<Ticket, Car> getTicketCarMap() {
        return ticketCarMap;
    }
}
