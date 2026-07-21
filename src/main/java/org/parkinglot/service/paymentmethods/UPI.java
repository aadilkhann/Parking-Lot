package org.parkinglot.service.paymentmethods;

public class UPI implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + "via UPI");
    }
}
