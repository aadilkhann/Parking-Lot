package org.parkinglot;

import java.util.UUID;

public class ParkingSpot {
    private UUID spotId;
    private VehicleType spotType;
    private Vehicle parkedVehicle;

    public ParkingSpot(VehicleType spotType) {
        this.spotId = UUID.randomUUID();
        this.spotType = spotType;
        this.parkedVehicle = null;
    }

    public UUID getSpotId() {
        return spotId;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void parkVehicle(Vehicle parkedVehicle) {
        if (parkedVehicle==null){
            this.parkedVehicle = parkedVehicle;
        }
        else{
            throw new RuntimeException("Vehicle already parked in the spot");
        }
    }

    public boolean unParkVehicle() {
        this.parkedVehicle = null;
        return true;
    }
}
