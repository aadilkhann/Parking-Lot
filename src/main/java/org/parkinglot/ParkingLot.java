package org.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> parkingFloor;

    public ParkingLot() {
        this.parkingFloor = new ArrayList<>();
    }

    public List<ParkingFloor> getParkingFloor() {
        return parkingFloor;
    }
}
