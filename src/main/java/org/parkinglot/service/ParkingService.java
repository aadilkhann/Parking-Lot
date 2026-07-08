package org.parkinglot.service;

import org.parkinglot.model.VehicleType;
import org.parkinglot.model.*;

import java.util.*;

public class ParkingService {

    Map<String, Ticket> activeTickets;
    ParkingLot parkingLot;

    public ParkingService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.activeTickets = new HashMap<>();
    }

    public Ticket parkVehicle(Vehicle vehicle){
        ParkingSpot spot=getNearestSpot(vehicle.getVehicleType());
        if (spot==null){
            System.out.println("Couldn't find spot or parking is full");
            return null;
        }

        Ticket ticket= new Ticket(vehicle,spot);
        activeTickets.put(vehicle.getVehicleNumber(),ticket);
        return ticket;
    }

    public ParkingSpot getNearestSpot(VehicleType vehicleType){
        for(ParkingFloor floor : parkingLot.getParkingFloors()){
            ParkingSpot allocatedSpot=floor.allocateSpot(vehicleType);
            if (allocatedSpot!=null) return allocatedSpot;
        }
        return null;
    }

    public void unparkVehicle(String vehicleNumber){
        Ticket ticket=activeTickets.get(vehicleNumber);
        ParkingSpot spot=ticket.getSpot();
        ParkingFloor parkingFloor=spot.getParkingFloor();
        parkingFloor.freeSpot(spot);
    }
}
