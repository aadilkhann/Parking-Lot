package org.parkinglot;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Timer;
import java.util.UUID;

public class Ticket {
    private UUID ticketId;
    private Vehicle vehicle;
    private ParkingSpot spot;
    private LocalTime entryTime;
    private LocalDate entryDate;

    public Ticket(Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = UUID.randomUUID();
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalTime.now();
        this.entryDate=LocalDate.now();
    }

    public UUID getTicketId() {
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
