package org.parkinglot.strategy;

import org.parkinglot.model.ParkingLot;
import org.parkinglot.model.ParkingSpot;
import org.parkinglot.model.VehicleType;

public class VIPParking implements ParkingStrategy{
    @Override
    public ParkingSpot findSpot(ParkingLot lot, VehicleType vehicleType) {
        return null;
    }
}
