package za.ac.cput.factory;

import za.ac.cput.domain.Payment;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

public class PaymentFactory {

    public static Payment createPayment(Long paymentID, Double amount, String paymentStatus,
                                        LocalDateTime paymentDate, TutoringSession session) {
//        if (paymentID == null ||
//                amount == null ||
//                amount < 0 ||
//                paymentStatus == null ||
//                paymentDate == null ||
//                session == null
//        ) {
//            return null;
//        }
     if(Helper.isObjectNull(paymentID)
     || Helper.isEmptyOrNull(paymentStatus)
     || Helper.isObjectNull(paymentDate)
     || Helper.isObjectNull(session)){
         return null;
     }

     if (Helper.isObjectNull(amount)
             || amount <= 0){
         return null;
     }




        return new Payment.Builder()
                .setPaymentID(paymentID)
                .setAmount(amount)
                .setPaymentStatus(paymentStatus)
                .setPaymentDate(paymentDate)
                .setSession(session)
                .build();
    }
}
