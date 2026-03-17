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
    private TutoringSession session;
    //private Long sessionID
    //private Long finalAmount;


    //Constructor
    private Payment(Builder builder) {
        this.paymentID = builder.paymentID;
        this.amount = builder.amount;
        this.paymentStatus = builder.paymentStatus;
        this.paymentDate = builder.paymentDate;
        this.session = builder.session;
    }

    //Payment processing method
    public void processPayment() {

    }

    //Getter methods
    public Long getPaymentID() {
        return paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public TutoringSession getSession() {
        return session;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID=" + paymentID +
                ", amount=" + amount +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", paymentDate=" + paymentDate +
                ", session=" + session +
                '}';
    }

    //Builder class
    public static class Builder {
        private Long paymentID;
        private double amount;
        private String paymentStatus;
        private LocalDateTime paymentDate;
        private TutoringSession session;


        //Builder setters
        public Builder setPaymentID(Long paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Builder setPaymentDate(LocalDateTime paymentDate) {
            this.paymentDate = paymentDate;
            return this;

        }

        public Builder setSession(TutoringSession session) {
            this.session = session;
            return this;

        }


        //Builder copy
        public Builder copy(Payment pay) {
            this.paymentID = pay.paymentID;
            this.amount = pay.amount;
            this.paymentStatus = pay.paymentStatus;
            this.paymentDate = pay.paymentDate;
            this.session = pay.session;
            return this;
        }

        public Payment build() {

            return new Payment(this);
        }
    }


}


