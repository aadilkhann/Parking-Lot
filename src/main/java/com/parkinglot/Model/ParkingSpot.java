package com.parkinglot.Model;

import com.parkinglot.Model.Constants.Spot;
import com.parkinglot.Model.Constants.VehicleType;

public class ParkingSpot {
    private int spotId;
    private VehicleType supportedVehicleType;
    private Spot spot;
    private Vehicle vehicle;

    public ParkingSpot(int spotId, VehicleType supportedVehicleType, Spot spot, Vehicle vehicle) {
        this.spotId = spotId;
        this.supportedVehicleType = supportedVehicleType;
        this.spot = spot;
        this.vehicle = vehicle;
    }

    public int assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.spot=Spot.OCCUPIED;
        return spotId;
    }

    public void releaseVehicle(){
        this.vehicle=null;
        this.spot=Spot.FREE;
    }

    public boolean canFit(Vehicle vehicle) {
        VehicleType vehicleType = vehicle.getVehicleType();

        return switch (vehicleType) {
            case BIKE -> true; // bike fits anywhere
            case CAR -> supportedVehicleType == VehicleType.CAR
                    || supportedVehicleType == VehicleType.TRUCK;
            case TRUCK -> supportedVehicleType == VehicleType.TRUCK;
        };
    }

}
