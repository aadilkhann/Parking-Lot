package org.parkinglot;

import java.util.*;

public class ParkingFloor {
    private int floor;
    private List<ParkingSpot> allParkingSpot;
    private Map<VehicleType, Queue<ParkingSpot>> freeParkingSpots;

    public ParkingFloor(int floor) {
        this.floor = floor;
        this.allParkingSpot = new ArrayList<>();
        this.freeParkingSpots = new HashMap<>();
    }

    public int getFloor() {
        return floor;
    }

    public void addParkingSpot(List<ParkingSpot> allParkingSpot) {
        this.allParkingSpot.addAll(allParkingSpot);
        syncParkingSpot(allParkingSpot);
    }

    public void syncParkingSpot(List<ParkingSpot> allParkingSpot) {
        freeParkingSpots.clear();

        if (allParkingSpot == null) {
            return;
        }

        for (ParkingSpot parkingSpot : allParkingSpot) {
            if (parkingSpot == null) {
                continue;
            }

            freeParkingSpots
                    .computeIfAbsent(parkingSpot.getSpotType(), k -> new LinkedList<>())
                    .offer(parkingSpot);
        }
    }

    public ParkingSpot allocateSpot(VehicleType vehicleType){
        Queue<ParkingSpot> spots =
                freeParkingSpots.get(vehicleType);

        if (spots == null || spots.isEmpty()) {
            throw new RuntimeException(
                    "No available spots for vehicle type: "
                            + vehicleType);
        }

        ParkingSpot spot = spots.poll();

        if (spot==null) throw new RuntimeException("Parking Full");
        else if (spot.isOccupied()) throw new RuntimeException("Inconsistent state :: Spot is already occupied");

        spot.changeOccupancy(true);
        return spot;
    }

    public void freeSpot(ParkingSpot parkingSpot){
        parkingSpot.changeOccupancy(false);
        freeParkingSpots.get(parkingSpot.getSpotType()).offer(parkingSpot);
    }
}
