package org.parkinglot.strategy;

import org.parkinglot.model.ParkingFloor;
import org.parkinglot.model.ParkingLot;
import org.parkinglot.model.ParkingSpot;
import org.parkinglot.model.Vehicle;

public class NearestParking implements ParkingStrategy{

    @Override
    public ParkingSpot findSpot(ParkingLot lot, Vehicle vehicle) {
        for(ParkingFloor floor : lot.getParkingFloors()){
            ParkingSpot allocatedSpot=floor.allocateSpot(vehicle.getVehicleType());
            if (allocatedSpot!=null) return allocatedSpot;
        }
        return null;
    }
}
