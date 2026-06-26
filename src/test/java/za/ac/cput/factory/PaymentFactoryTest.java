package za.ac.cput.factory;


import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.enums.PaymentStatus;
import java.time.LocalDateTime;

/* PaymentFactoryTest.java
    Paymenet Factory test class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 26 March 2026
*/

class PaymentFactoryTest {

    private Payment payment = new Payment.Builder()
            .setAmount(25000.00)
            .setPaymentStatus(PaymentStatus.PENDING)
            .setPaymentMethod("EFT")
            .setPaidAt(LocalDateTime.now())
            .setPaymentID(1L)
            .setSession(new TutoringSession())
            .build();

    @Test
    void createPayment() {
        System.out.println(payment);
    }
}