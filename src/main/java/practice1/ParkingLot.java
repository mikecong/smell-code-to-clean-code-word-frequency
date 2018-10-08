package practice1;

import java.util.HashMap;

public class ParkingLot {
    private final int capacity;
    private final HashMap<Ticket, Car> ticketCarHashMap = new HashMap<>();
    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car) {
        if (capacity == ticketCarHashMap.size()) {
            throw new ParkingLotFullException();
        }
        Ticket ticket = new Ticket();
        ticketCarHashMap.put(ticket, car);
        return ticket;
    }

    public Car pickUp(Ticket ticket) {
        Car car = ticketCarHashMap.get(ticket);
        ticketCarHashMap.remove(ticket);
        return car;
    }
}
