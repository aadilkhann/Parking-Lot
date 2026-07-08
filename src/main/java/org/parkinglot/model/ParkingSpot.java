package org.parkinglot.model;

import java.util.Objects;
import java.util.UUID;

public class ParkingSpot {
    private UUID spotId;
    private VehicleType spotType;
    private boolean isOccupied;
    private ParkingFloor parkingFloor;

    public ParkingSpot(VehicleType spotType) {
        this.spotId = UUID.randomUUID();
        this.spotType = spotType;
        this.isOccupied = false;
    }

    public UUID getSpotId() {
        return spotId;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void changeOccupancy(boolean occupied) {
        isOccupied = occupied;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSpot that = (ParkingSpot) o;
        return Objects.equals(spotId, that.spotId) && spotType == that.spotType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(spotId, spotType, isOccupied);
    }
}
