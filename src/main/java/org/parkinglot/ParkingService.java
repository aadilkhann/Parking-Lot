package org.parkinglot;

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
        if (spot==null) throw new RuntimeException("Couldn't find spot or parking is full");

        Ticket ticket= new Ticket(vehicle,spot);

        activeTickets.put(vehicle.getVehicleNumber(),ticket);
        return ticket;
    }

    public ParkingSpot getNearestSpot(VehicleType vehicleType){
        for(ParkingFloor floor : parkingLot.getParkingFloors()){
            ParkingSpot allocatedSpot=floor.allocateSpot(vehicleType);
            if (allocatedSpot!=null) return allocatedSpot;
        }
        throw new RuntimeException("Couldn't find spot or parking is full");
    }

//    unparkVehicle(String vehicleNumber)
}
