package org.parkinglot.service.parkingstrategy;

import org.parkinglot.model.*;
import org.parkinglot.model.enums.VehicleType;

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
