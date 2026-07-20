package org.parkinglot.strategy;

import org.parkinglot.model.*;

import java.util.Collection;

public class NearestParking implements ParkingStrategy{

    @Override
    public ParkingSpot findSpot(ParkingLot lot, VehicleType vehicleType) {
        for(ParkingFloor floor : lot.getParkingFloors()){
            Iterable<ParkingSpot> availableSpots=floor.getFreeParkingSpots(vehicleType);
            for (ParkingSpot spot: availableSpots){
                return spot;
            }
        }
        return null;
    }
}
