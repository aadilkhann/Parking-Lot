package org.parkinglot.model;

import org.parkinglot.model.enums.VehicleType;

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

    public Iterable<ParkingSpot> getFreeParkingSpots(VehicleType vehicleType) {
        Queue<ParkingSpot> parkingSpots = freeParkingSpots.get(vehicleType);

        if (parkingSpots==null) return Collections.emptyList();
        return Collections.unmodifiableCollection(parkingSpots);
    }

    public void addParkingSpot(List<ParkingSpot> allParkingSpot) {
        for (ParkingSpot parkingSpot : allParkingSpot) {
            parkingSpot.setParkingFloor(this);
        }
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
            return null;
        }

        ParkingSpot spot = spots.poll();
        if (spot==null || spot.isOccupied()) return null;
        spot.changeOccupancy(true);
        return spot;
    }

    public ParkingSpot allocateSpot(ParkingSpot parkingSpot){
        Queue<ParkingSpot> spots =
                freeParkingSpots.get(parkingSpot.getSpotType());

        if (spots == null || spots.isEmpty()) {
            return null;
        }
        boolean removed=spots.remove(parkingSpot);

        if (!removed) return null;
        parkingSpot.changeOccupancy(true);
        return parkingSpot;
    }

    public void freeSpot(ParkingSpot parkingSpot){
        parkingSpot.changeOccupancy(false);
        freeParkingSpots.get(parkingSpot.getSpotType()).offer(parkingSpot);
    }

    public List<ParkingSpot> getAllParkingSpot() {
        return allParkingSpot;
    }

    public synchronized boolean tryAllocate(ParkingSpot spot) {
        Queue<ParkingSpot> spots =
                freeParkingSpots.get(spot.getSpotType());

        if (spots == null || spots.isEmpty()) {
            return false;
        }
        boolean removed=spots.remove(spot);

        if (!removed) return false;
        spot.changeOccupancy(true);
        return true;
    }

}
