package com.parkinglot.Model;

import java.util.List;

public class ParkingLot {
    String lotName;
    List<ParkingFloor> parkingFloors;

    public ParkingLot(String lotName, List<ParkingFloor> parkingFloors) {
        this.lotName = lotName;
        this.parkingFloors = parkingFloors;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : parkingFloors) {
            for (ParkingSpot spot : floor.getParkingSpots()) {
                if (spot.canFit(vehicle)) {
                    spot.assignVehicle(vehicle);
                    System.out.println("Vehicle parked successfully");
                    return new Ticket(floor.getFloorNo() + spot.getSpotId(), vehicle.getVehicleType(), 30,
                            floor.getFloorNo(), spot.getSpotId());
                }
            }
        }
        System.out.println("Spot not available");
        return null;
    }

    public void unparkVehicle(Ticket ticket) {
        //can add payment logic
        parkingFloors.get(ticket.getFloor())
                .getParkingSpots()
                .remove(ticket.getSpot_id());
    }
}
