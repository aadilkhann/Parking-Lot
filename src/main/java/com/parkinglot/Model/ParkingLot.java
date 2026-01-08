package com.parkinglot.Model;

import java.util.List;

public class ParkingLot {
    String lotName;
    List<ParkingFloor> parkingFloors;

    public ParkingLot(String lotName, List<ParkingFloor> parkingFloors) {
        this.lotName = lotName;
        this.parkingFloors = parkingFloors;
    }

    public void parkVehicle(Vehicle vehicle){
        for(ParkingFloor floor:parkingFloors){
            for(ParkingSpot spot:floor.getParkingSpots()){
                if(spot.canFit(vehicle)){
                    spot.assignVehicle(vehicle);
                    System.out.println("Vehicle parked successfully");
                    //can add ticket generation logic here and return Ticket.
                    return;
                }
                else{
                    System.out.println("Spot not available");
                }
            }
        }
    }
    public void unparkVehicle(){

    }
}
