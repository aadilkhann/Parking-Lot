package com.parkinglot.Model;

import java.util.List;

public class ParkingLot {
    String lotName;
    List<ParkingFloor> parkingFloors;

    public ParkingLot(String lotName, List<ParkingFloor> parkingFloors) {
        this.lotName = lotName;
        this.parkingFloors = parkingFloors;
    }

    public String getLotName() {
        return lotName;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }
}
