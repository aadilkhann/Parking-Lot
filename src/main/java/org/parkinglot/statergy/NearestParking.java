package org.parkinglot.statergy;

import org.parkinglot.model.*;

import java.util.Map;
import java.util.Queue;

public class NearestParking implements ParkingStatergy {

    @Override
    public ParkingSpot findSpot(ParkingLot lot, Vehicle vehicle) {
        for (ParkingFloor floor:lot.getParkingFloors()){
            Map<VehicleType, Queue<ParkingSpot>> freeParkingSpots = floor.getFreeParkingSpots();
            Queue<ParkingSpot> spots = freeParkingSpots.get(vehicle.getVehicleType());
            if (spots!=null && !spots.isEmpty()) return spots.peek();

        }
        return null;
    }
}
