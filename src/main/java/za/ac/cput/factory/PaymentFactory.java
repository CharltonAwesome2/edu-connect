package za.ac.cput.factory;

import za.ac.cput.domain.Payment;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.enums.PaymentStatus;
import za.ac.cput.util.HelperUtil;

import java.time.LocalDateTime;

/*
    PaymentFactory.java
    Factory class for Payment domain
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 19 March 2026
*/
public class PaymentFactory {

    public static Payment createPayment(Double amount, PaymentStatus status,
            String method, LocalDateTime paidAt, TutoringSession session) {

        Long paymentID = HelperUtil.generateId();

        if (amount == null || amount <= 0
                || paidAt == null
                || HelperUtil.isNullorEmpty(method)
                || status == null
                || session == null) {
            return null;
        }

        return new Payment.Builder()
                .setPaymentID(paymentID)
                .setAmount(amount)
                .setPaidAt(paidAt)
                .setPaymentMethod(method)
                .setPaymentStatus(status)
                .setSession(session)
                .build();

    }
}
