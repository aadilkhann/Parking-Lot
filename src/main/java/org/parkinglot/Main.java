package org.parkinglot;

import org.parkinglot.model.ParkingLot;
import org.parkinglot.model.ParkingSpot;
import org.parkinglot.model.VehicleType;

import java.util.ArrayList;
import java.util.List;

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