package za.ac.cput.domain;

import java.time.LocalDateTime;

import za.ac.cput.enums.PaymentStatus;

/* Payment.java
Payment domain model class
Author: Ayabonga Jervasio Yawa (221241558)
Date: 11 March 2026
*/

public class Payment {
    private Long paymentID;
    private double amount;
    private LocalDateTime paidAt;
    private String paymentMethod;
    private PaymentStatus status;
    private TutoringSession session;
    //private Long sessionID
    //private Long finalAmount;

    //Constructor
    private Payment(Builder builder) {
        this.paymentID = builder.paymentID;
        this.amount = builder.amount;
        this.paidAt = builder.paidAt;
        this.paymentMethod = builder.paymentMethod;
        this.status = builder.status;
        this.session = builder.session;
    }

    //Getter methods
    public Long getPaymentID() {
        return paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public TutoringSession getSession() {
        return session;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID=" + paymentID +
                ", amount=" + amount +
                ", paidAt='" + paidAt + '\'' +
                ", paymentStatus='" + paymentMethod + '\'' +
                ", status=" + status +
                ", session=" + session +
                '}';
    }

    //Builder class
    public static class Builder {
        private Long paymentID;
        private double amount;
        private LocalDateTime paidAt;
        private String paymentMethod;
        private PaymentStatus status;
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

        public Builder setPaidAt(LocalDateTime paidAt) {
            this.paidAt = paidAt;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setPaymentStatus(PaymentStatus status) {
            this.status = status;
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
            this.paidAt = pay.paidAt;
            this.paymentMethod = pay.paymentMethod;
            this.status = pay.status;
            this.session = pay.session;
            return this;
        }

        public Payment build() {

            return new Payment(this);
        }
    }

}
