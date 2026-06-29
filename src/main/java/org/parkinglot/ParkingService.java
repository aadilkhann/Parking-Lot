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
        findAndFreeSpot(spot);
    }
    public void findAndFreeSpot(ParkingSpot parkingSpot){
        for(ParkingFloor floor : parkingLot.getParkingFloors()){
            List<ParkingSpot> parkingSpotsList=floor.getAllParkingSpot();
            for (ParkingSpot spot: parkingSpotsList){
                if(spot.equals(parkingSpot)){
                    floor.freeSpot(parkingSpot);
                    return;
                }
            }
        }
        System.out.println("No Spot or Vehicle Found:: Invalid Ticket");
    }
}
