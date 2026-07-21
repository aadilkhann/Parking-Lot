package org.parkinglot.service.paymentmethods;

public interface PaymentStrategy {
    public void pay(double amount); //TODO: SHould return some insight something like PaymentResult pay(double amount);
}
