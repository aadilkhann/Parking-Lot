package com.parkinglot.Model;

import com.parkinglot.Model.Constants.VehicleType;

public class Vehicle {
    private String vehicleNum;
    private VehicleType vehicleType;

    public Vehicle(String vehicleNum, VehicleType vehicleType) {
        this.vehicleNum = vehicleNum;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
