package org.parkinglot.strategy;

import org.parkinglot.model.ParkingType;

import java.util.HashMap;
import java.util.Map;

public class ParkingStrategyFactory {
    final Map<ParkingType,ParkingStrategy> parkingStrategies=new HashMap<>();

    public ParkingStrategyFactory() {
        parkingStrategies.put(ParkingType.DISABLE_PARKING,new DisableParking());
        parkingStrategies.put(ParkingType.EV_PARKING,new EVParking());
        parkingStrategies.put(ParkingType.NEAREST_PARKING,new NearestParking());
        parkingStrategies.put(ParkingType.VIP_PARKING,new VIPParking());
    }

    public ParkingStrategy getParkingStrategy(ParkingType parkingType) {
        return parkingStrategies.get(parkingType);
    }
}
