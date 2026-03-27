package za.ac.cput.factory;


import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.enums.PaymentStatus;

import java.time.LocalDateTime;

class PaymentFactoryTest {

    private Payment payment = new Payment.Builder()
            .setAmount(25000.00)
            .setPaymentStatus(PaymentStatus.PENDING)
            .setPaymentMethod("EFT")
            .setPaidAt(LocalDateTime.of(2026, 3, 26, 0, 0))  // LocalDateTime
            .setPaymentID(1L)
            .setSession(new TutoringSession())
            .build();

    @Test
    void createPayment() {
        System.out.println(payment);
    }
}