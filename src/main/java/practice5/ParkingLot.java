package practice5;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final double capacity;
    private final Map<Ticket, Car> ticketCarMap = new HashMap<>();

    public ParkingLot(double capacity) {
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

    public BigDecimal parkingRoomVacancyRate() {
        double emptyParkingRoom = capacity - ticketCarMap.size();
        BigDecimal vacancyRate = new BigDecimal(emptyParkingRoom / capacity);
        return vacancyRate;
    }

    public Map<Ticket, Car> getTicketCarMap() {
        return ticketCarMap;
    }

    public double emptyParkingRoom() {
        return capacity - ticketCarMap.size();
    }
}
