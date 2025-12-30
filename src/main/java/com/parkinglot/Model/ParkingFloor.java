package com.parkinglot.Model;

import java.util.List;

public class ParkingFloor {
    int floorNo;
    List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNo, List<ParkingSpot> parkingSpots) {
        this.floorNo = floorNo;
        this.parkingSpots = parkingSpots;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
