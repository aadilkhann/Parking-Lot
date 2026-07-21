package org.parkinglot.service.parkingstrategy;

import org.parkinglot.model.ParkingLot;
import org.parkinglot.model.ParkingSpot;
import org.parkinglot.model.enums.VehicleType;

public interface ParkingStrategy {
    ParkingSpot findSpot(ParkingLot lot, VehicleType vehicleType);
}
