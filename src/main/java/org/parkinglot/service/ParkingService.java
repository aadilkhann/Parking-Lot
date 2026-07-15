package org.parkinglot.service;

import org.parkinglot.model.VehicleType;
import org.parkinglot.model.*;
import org.parkinglot.strategy.NearestParking;
import org.parkinglot.strategy.ParkingStrategy;

import java.util.*;

public class ParkingService {

    Map<String, Ticket> activeTickets;
    ParkingLot parkingLot;
    ParkingStrategy nearestparkingStrategy;

    public ParkingService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.activeTickets = new HashMap<>();
        this.nearestparkingStrategy=new NearestParking();
    }

    public Ticket parkVehicle(Vehicle vehicle, String parkingType){
        ParkingSpot spot;
        switch (parkingType) {
            case "NEARESTPARKING":
                spot=getNearestSpot(vehicle.getVehicleType());
                break;

            default:
                return null;
        }
//        ParkingSpot spot=getNearestSpot(vehicle.getVehicleType());
        if (spot==null){
            System.out.println("Couldn't find spot or parking is full");
            return null;
        }
        ParkingFloor parkingFloor=spot.getParkingFloor();
        parkingFloor.allocateSpot(spot);
        Ticket ticket= new Ticket(vehicle,spot);
        activeTickets.put(vehicle.getVehicleNumber(),ticket);
        return ticket;
    }

    public ParkingSpot getNearestSpot(VehicleType vehicleType){
        return nearestparkingStrategy.findSpot(parkingLot,vehicleType);
    }

    public void unparkVehicle(String vehicleNumber){
        Ticket ticket=activeTickets.get(vehicleNumber);
        ParkingSpot spot=ticket.getSpot();
        ParkingFloor parkingFloor=spot.getParkingFloor();
        parkingFloor.freeSpot(spot);
    }
}
