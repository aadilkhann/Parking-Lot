package org.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot=new ParkingLot();
        parkingLot.addParkingFloors(0);
        parkingLot.addParkingFloors(1);

        ParkingSpot parkingSpot=new ParkingSpot(VehicleType.CAR);
        ParkingSpot parkingSpot1=new ParkingSpot(VehicleType.BIKE);
        ParkingSpot parkingSpot2=new ParkingSpot(VehicleType.TRUCK);
        List<ParkingSpot> parkingSpots=new ArrayList<>();
        parkingSpots.add(parkingSpot);
        parkingSpots.add(parkingSpot1);
        parkingSpots.add(parkingSpot2);

        parkingLot.getParkingFloor(0).addParkingSpot(parkingSpots);




    }
}