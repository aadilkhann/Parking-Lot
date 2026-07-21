package org.parkinglot.service;

import org.parkinglot.model.enums.ParkingType;
import org.parkinglot.model.*;
import org.parkinglot.model.enums.PaymentMethod;
import org.parkinglot.model.enums.PaymentStatus;
import org.parkinglot.service.parkingstrategy.ParkingStrategyFactory;

import java.util.*;

public class ParkingService {

    final private Map<String, Ticket> activeTickets;
    final private Map<String, Ticket> archivedTickets;
    final private ParkingLot parkingLot;
    final private ParkingStrategyFactory parkingStrategyFactory;
    final private PaymentService paymentService;
    final private FareCalculator fareCalculator;

    public ParkingService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.activeTickets = new HashMap<>();
        this.archivedTickets = new HashMap<>();
        this.parkingStrategyFactory=new ParkingStrategyFactory();
        this.paymentService = new PaymentService();
        this.fareCalculator = new FareCalculator();
    }

    public Ticket parkVehicle(Vehicle vehicle, ParkingType parkingType){
        if(parkingType==null){
            return null;
        }
        ParkingSpot spot=parkingStrategyFactory.getParkingStrategy(parkingType).findSpot(parkingLot,vehicle.getVehicleType());

        if (spot==null){
            System.out.println("Couldn't find spot or parking is full");
            return null;
        }

        ParkingFloor parkingFloor=spot.getParkingFloor();
        parkingFloor.allocateSpot(spot);
        Ticket ticket= new Ticket(vehicle,spot);
        activeTickets.put(vehicle.getVehicleNumber(),ticket);
        return ticket;
    }

    public void exitVehicle(String vehicleNumber){
        Ticket ticket=activeTickets.get(vehicleNumber);
        if (ticket==null){
            System.out.println("Vehicle "+vehicleNumber+" not found");
            return;
        }
        ParkingSpot spot=ticket.getSpot();
        ParkingFloor parkingFloor=spot.getParkingFloor();

        //Calculate fare
        double totalFare = fareCalculator.calculateFare(ticket);

        //Make Payment
        Payment paymentReceipt = paymentService.processPayment(totalFare, PaymentMethod.UPI);
        if (paymentReceipt.getPaymentStatus()!= PaymentStatus.SUCCESS){
            System.out.println("Payment failed or pending retry again");
            return;
        }
        ticket.setPaymentRecipt(paymentReceipt);
        //Finally release spot
        parkingFloor.freeSpot(spot);

        archivedTickets.put(vehicleNumber,ticket);
        activeTickets.remove(vehicleNumber);
    }

//    public void unparkVehicle(String vehicleNumber){
//        Ticket ticket=activeTickets.get(vehicleNumber);
//        if (ticket==null){
//            System.out.println("Vehicle "+vehicleNumber+" not found");
//            return;
//        }
//        ParkingSpot spot=ticket.getSpot();
//        ParkingFloor parkingFloor=spot.getParkingFloor();
//        parkingFloor.freeSpot(spot);
//    }
}