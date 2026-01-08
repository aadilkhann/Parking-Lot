package com.parkinglot.Model;

import com.parkinglot.Model.Constants.VehicleType;

public class Ticket {
    private int ticketId;
    private VehicleType vehichle;
    private int price;
    private int floor;
    private int spot_id;

    public Ticket(int ticketId, VehicleType vehichle, int price, int floor, int spot_id) {
        this.ticketId = ticketId;
        this.vehichle = vehichle;
        this.price = price;
        this.floor = floor;
        this.spot_id = spot_id;
    }

    public int getTicketId() {
        return ticketId;
    }

    public VehicleType getVehichle() {
        return vehichle;
    }

    public int getPrice() {
        return price;
    }

    public int getFloor() {
        return floor;
    }

    public int getSpot_id() {
        return spot_id;
    }
}
