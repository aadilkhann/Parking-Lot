package org.parkinglot.model;

import org.parkinglot.model.enums.PaymentMethod;
import org.parkinglot.model.enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {
    UUID paymentId;
    double paymentAmount;
    PaymentMethod paymentMethod;
    PaymentStatus paymentStatus;
    LocalDateTime timestamp;

    public Payment(double paymentAmount, PaymentMethod paymentMethod, PaymentStatus paymentStatus) {
        this.paymentId = UUID.randomUUID();
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.timestamp = LocalDateTime.now();
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
