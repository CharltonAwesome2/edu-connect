package za.ac.cput.factory;

import za.ac.cput.domain.Payment;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.enums.PaymentStatus;
import za.ac.cput.util.Helper;
import za.ac.cput.util.HelperUtil;

import java.time.LocalDateTime;
/*
    PaymentFactory.java
    Factory class for Payment domain
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 19 March 2026
*/
public class PaymentFactory {

    public static Payment createPayment(Long paymentID, Double amount, PaymentStatus status,
                                        String method, LocalDateTime paidAt, TutoringSession session) {



        if(HelperUtil.isObjectNull(paymentID)
        ||HelperUtil.isObjectNull(status)
        ||HelperUtil.isObjectNull(paidAt)
        ||HelperUtil.isObjectNull(session)
        )

            if (Helper.isObjectNull(amount)
                    || amount <= 0){
                return null;
            }

        return new Payment.Builder()
                .setPaymentID(paymentID)
                .setAmount(amount)
                .setPaymentStatus(status)
                .setPaymentMethod(method)
                .setPaidAt(paidAt)
                .setSession(session)
                .build();

    }
}
