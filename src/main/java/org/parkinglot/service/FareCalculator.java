package org.parkinglot.service;

import org.parkinglot.model.Ticket;
import org.parkinglot.model.enums.VehicleType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class FareCalculator {
    public double calculateFare(Ticket ticket) { //May need to change param to pass min data. like vehicle type and entry time or a FareCalculation Strategy Type

        //Extreme Basic Fare Calculation without considering time and events just based on Vehicle Type
        VehicleType spotType = ticket.getVehicle().getVehicleType();

        if (spotType == VehicleType.CAR) {
            setExitTime(ticket);
            return 50;
        }
        else if (spotType == VehicleType.BIKE) {
            setExitTime(ticket);
            return 30;
        } else if (spotType == VehicleType.TRUCK) {
            setExitTime(ticket);
            return 100;
        }
        return 0;
    }

    public void setExitTime(Ticket ticket) {
        ticket.setExitDate(LocalDate.now());
        ticket.setExitTime(LocalTime.now());
    }
}
