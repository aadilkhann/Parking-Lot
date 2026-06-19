package org.parkinglot;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class ParkingFloor {
    private int floor;
    private Map<VehicleType, Queue<ParkingSpot>> freeParkingSpots;

    public ParkingFloor(int floor) {
        this.floor = floor;
        this.freeParkingSpots = new HashMap<>();
    }

    public int getFloor() {
        return floor;
    }

    public Map<VehicleType, Queue<ParkingSpot>> getFreeParkingSpots() {
        return freeParkingSpots;
    }

    public boolean addNewFreeParkingSpots(VehicleType vehicleType, int spotQuantity) {
        try {
            Queue<ParkingSpot> currentspots=freeParkingSpots.get(vehicleType);
            if (currentspots==null){
                Queue<ParkingSpot> newSpots=new ArrayDeque<>();
                for(int i=0;i<spotQuantity;i++){
                    newSpots.offer(new ParkingSpot(vehicleType));
                }
                freeParkingSpots.put(vehicleType,newSpots);
                return true;
            }
            else{
                //Handle to add new spot when already spots are available.
            }
            return false;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
