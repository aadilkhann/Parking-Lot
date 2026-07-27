package org.parkinglot.service;

import org.parkinglot.model.Payment;
import org.parkinglot.model.enums.PaymentMethod;
import org.parkinglot.model.enums.PaymentStatus;
import org.parkinglot.service.paymentmethods.PaymentStrategy;
import org.parkinglot.service.paymentmethods.PaymentModeRegistry;

public class PaymentService {
    final private PaymentModeRegistry paymentModeRegistry;
    public PaymentService() {
        this.paymentModeRegistry = new PaymentModeRegistry();
    }


    public Payment processPayment(double amount, PaymentMethod paymentMethod) {
        //Just a stub to make a payment by assuming that it will always succeed via UPI
        PaymentStrategy paymentMode = paymentModeRegistry.getPaymentMode(paymentMethod);
        if (paymentMode == null) {
            System.out.println("Invalid PaymentMode");
            return new Payment(amount, paymentMethod, PaymentStatus.FAILED);
        }
        paymentMode.pay(amount);
        return new Payment(amount, paymentMethod, PaymentStatus.SUCCESS);
    }
}
