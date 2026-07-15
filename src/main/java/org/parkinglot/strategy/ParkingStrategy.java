package org.parkinglot.strategy;

import org.parkinglot.model.ParkingLot;
import org.parkinglot.model.ParkingSpot;
import org.parkinglot.model.Vehicle;
import org.parkinglot.model.VehicleType;

public interface ParkingStrategy {
    ParkingSpot findSpot(ParkingLot lot, VehicleType vehicleType);
}
