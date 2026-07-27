package org.parkinglot.service.paymentmethods;

public interface PaymentStrategy {
    public void pay(double amount); //TODO: Should return some insight something like PaymentResult pay(double amount);
}
