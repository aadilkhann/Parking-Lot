package org.parkinglot.service.paymentmethods;

import org.parkinglot.model.enums.PaymentMethod;

import java.util.HashMap;
import java.util.Map;

public class PaymentModeRegistry {
    final private Map<PaymentMethod, PaymentStrategy> paymentModes = new HashMap<>();

    public PaymentModeRegistry() {
        paymentModes.put(PaymentMethod.CASH,new Cash());
        paymentModes.put(PaymentMethod.DEBIT_CARD,new DebitCard());
        paymentModes.put(PaymentMethod.CREDIT_CARD,new CreditCard());
        paymentModes.put(PaymentMethod.UPI,new UPI());
    }

    public PaymentStrategy getPaymentMode(PaymentMethod paymentMethod) {
        return paymentModes.get(paymentMethod);
    }
}
