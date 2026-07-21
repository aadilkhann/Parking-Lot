package org.parkinglot.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Ticket {
    private UUID ticketId;
    private Vehicle vehicle;
    private ParkingSpot spot;
    private LocalTime entryTime;
    private LocalDate entryDate;
    private LocalTime exitTime;
    private LocalDate exitDate;
    private Payment paymentRecipt;

    public Ticket(Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = UUID.randomUUID();
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalTime.now();
        this.entryDate=LocalDate.now();
        this.paymentRecipt=null;
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

    public void setPaymentRecipt(Payment paymentRecipt) {
        this.paymentRecipt = paymentRecipt;
    }

    public LocalTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalTime exitTime) {
        this.exitTime = exitTime;
    }

    public LocalDate getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDate exitDate) {
        this.exitDate = exitDate;
    }
}
