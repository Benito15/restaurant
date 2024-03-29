package ac.za.cput.domains.payment;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Payment {

    @Id
    protected String orderID;
    protected double amount;


    public Payment() {
    }

    public Payment(String orderID, double amount) {

        this.orderID = orderID;
        this.amount = amount;

    }


//    protected Payment(Builder builder) {
//         this.paymentID = builder.paymentID;
//         this.orderID = builder.orderID;
//        this.description = builder.description;
//        this.amount = builder.amount;
//    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Payment copy(Payment payment) {

        this.orderID = payment.orderID;
        this.amount = payment.amount;
        return this;
    }

    protected static abstract class Builder {
        String paymentID, orderID, description;
        private double amount;

        public Builder paymentID(String paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder orderID(String orderID) {
            this.orderID = orderID;
            return this;

        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }

//        public Builder copy(Payment payment) {
//            this.paymentID = payment.paymentID;
//            this.orderID = payment.orderID;
//            this.description = payment.description;
//            this.amount = payment.amount;
//            return this;
//        }

        public abstract Payment build();


    }

}




