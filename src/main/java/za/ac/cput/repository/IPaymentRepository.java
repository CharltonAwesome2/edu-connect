package za.ac.cput.repository;

import za.ac.cput.domain.Payment;

import java.util.List;
/* IPaymentRepository.java
    Paymenet Repository interface
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 24 March 2026
*/
public interface IPaymentRepository extends IRepositry<Payment, Long> {
    List<Payment> getAll();


}

