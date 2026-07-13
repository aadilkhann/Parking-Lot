package org.parkinglot.statergy;

import org.parkinglot.model.ParkingLot;
import org.parkinglot.model.ParkingSpot;
import org.parkinglot.model.Vehicle;

public interface ParkingStatergy {
    ParkingSpot findSpot(ParkingLot lot, Vehicle vehicle);
}
