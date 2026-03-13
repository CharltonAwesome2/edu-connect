package za.ac.cput.domain;

import java.time.LocalDateTime;

/* Payment.java
Payment domain model class
Author: Ayabonga Jervasio Yawa (221241558)
Date: 11 March 2026
*/


public class Payment {
    private Long paymentID;

    private double amount;
    private String paymentStatus;
    private LocalDateTime paymentDate;
    //private TutoringSession session;
    //private Long sessionID
    //private Long finalAmount;


    public Payment() {
    }

    //Constructor
    public Payment(Builder builder) {
        this.paymentID = builder.paymentID;
        this.amount = builder.amount;
        this.paymentStatus = builder.paymentStatus;
        this.paymentDate = builder.paymentDate;
    }

    //Payment processing method
    public void paymentProcess() {

    }

    //Getter methods
    public Long getPaymentID() {
        return paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public String getPayments() {
        return paymentStatus;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID=" + paymentID +
                ", amount=" + amount +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", paymentDate=" + paymentDate +
                '}';
    }

    //Builder class
    public static class Builder {
        private Long paymentID;
        private double amount;
        private String paymentStatus;
        private LocalDateTime paymentDate;
        //private TutoringSession session;


        //Builder setters
        public Builder setpaymentId(Long paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder setamount(Long amount) {
            this.amount = amount;
            return this;
        }

        public Builder setpaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Builder setpaymentDate(LocalDateTime paymentDate) {
            this.paymentDate = paymentDate;
            return this;

        }

        //Builder copy
        public Builder copy(Payment pay){
            this.paymentID = pay.paymentID;
            this.amount = pay.amount;
            this.paymentStatus = pay.paymentStatus;
            this.paymentDate = pay.paymentDate;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }


}


