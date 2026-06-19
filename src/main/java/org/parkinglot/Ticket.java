package org.parkinglot;

import java.time.LocalTime;
import java.util.Timer;

public class Ticket {
    private int ticketId;
    private Vehicle vehicle;
    private ParkingSpot spot;
    private LocalTime entryTime;

    public Ticket(int ticketId, Vehicle vehicle, ParkingSpot spot, LocalTime entryTime) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = entryTime;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }
}
