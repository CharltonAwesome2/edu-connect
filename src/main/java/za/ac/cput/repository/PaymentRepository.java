package za.ac.cput.repository;

import za.ac.cput.domain.Payment;

import java.util.ArrayList;
import java.util.List;
/* PaymentRepository.java
    Paymenet Repository class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 24 March 2026
*/
public class PaymentRepository implements IPaymentRepository {
    private static IPaymentRepository repository = null;
    private List<Payment> paymentList;

    private PaymentRepository(){
        paymentList = new ArrayList<>();
    }
    public static IPaymentRepository getRepository(){
        if (repository == null){
            repository = new PaymentRepository();
        }
        return repository;
    }

    @Override
    public Payment create(Payment payment) {
        boolean successfull = paymentList.add(payment);
        if(successfull){
            return payment;
        }
        return null;
    }

    @Override
    public Payment read(Long id) {
        for(Payment payment : paymentList){
            if (payment.getPaymentID().equals(id)){
                return payment;
            }
        }
        return null;
    }

    @Override
    public Payment update(Payment payment) {
        Payment oldPayment = read(payment.getPaymentID());
        if(oldPayment == null){
            return null;
        }
        paymentList.remove(oldPayment);
        paymentList.add(payment);
        return payment;
    }

    @Override
    public boolean delete(Long id) {
        Payment payment = read(id);
        if (payment == null){
            return false;
        }
        return paymentList.remove(payment);
    }

    @Override
    public List<Payment> getAll() {
        return paymentList;
    }
}

