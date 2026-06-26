package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.enums.PaymentStatus;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/* PaymentRepositoryTest.java
    Paymenet Repository Test class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 26 March 2026
*/

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentRepositoryTest {

    private IPaymentRepository repository = PaymentRepository.getRepository();

    private Payment payment1 = new Payment.Builder()
            .setPaymentID(1001L)
            .setAmount(300.00)
            .setPaymentStatus(PaymentStatus.PAID)
            .setPaymentMethod("EFT")
            .setPaidAt(LocalDateTime.now())
            .setSession(new TutoringSession())
            .build();


    private Payment payment2 = new Payment.Builder()
            .setPaymentID(1002L)
            .setAmount(200.00)
            .setPaymentStatus(PaymentStatus.PAID)
            .setPaymentMethod("Cash")
            .setPaidAt(LocalDateTime.now())
            .setSession(new TutoringSession())
            .build();

    Payment payment3 = new Payment.Builder()
            .setPaymentID(1003L)
            .setAmount(500.00)
            .build();

    @Test
    @Disabled
    void getRepository() {
        assertNotNull(repository);
        System.out.println("Repository instance Exsts");
    }

    @Test
    @Order(1)
    void create() {
        Payment created = repository.create(payment1);

        assertNotNull(created);
        assertEquals(1001L, created.getPaymentID());
        System.out.println("Created Payment: " + created);
    }

    @Test
    @Order(2)
    void read() {
        repository.create(payment2);

        Payment found = repository.read(payment2.getPaymentID());

        assertNotNull(found);
        assertEquals(200.00, found.getAmount());
        System.out.println("Read Payment: " + found);
    }

    @Test
    @Order(3)
    void update() {
        repository.create(payment1);
        Payment updatedPayment = new Payment.Builder()
                .copy(payment1)
                .setAmount(500.00)
                .build();

        assertEquals(500.00, updatedPayment.getAmount());

        Payment updated = repository.update(updatedPayment);
        assertNotNull(updated);

        System.out.println("Updated Payment: " + updated);
    }

    @Test
    @Order(5)
    void delete() {
        repository.create(payment3);

        System.out.println("Deleting Payment: " + payment3);

        boolean deleted = repository.delete(1003L);

        assertTrue(deleted);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println("Get All Payments");

        List<Payment> paymentList = repository.getAll();

        assertNotNull(paymentList);
        System.out.println(paymentList.size());
    }


}
