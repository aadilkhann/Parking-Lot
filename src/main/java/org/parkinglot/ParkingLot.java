package org.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> parkingFloors;

    public ParkingLot() {
        this.parkingFloors = new ArrayList<>();
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public ParkingFloor getParkingFloor(int floorNum){
        return parkingFloors.get(floorNum);
    }

    public void addParkingFloors(int floorNum) {
        //Add a check if same floor already exists then proceed further
        this.parkingFloors.add(new ParkingFloor(floorNum));
    }
}
