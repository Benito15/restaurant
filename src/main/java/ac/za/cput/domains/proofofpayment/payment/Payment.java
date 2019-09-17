package ac.za.cput.domains.proofofpayment.payment;

import java.util.Date;

public abstract class Payment {


     protected String orderID;
     protected String paymentID;
     protected String description;
     protected double amount;

     private Payment(){}

    protected Payment(Builder builder) {
         this.paymentID = builder.paymentID;
         this.orderID = builder.orderID;
        this.description = builder.description;
        this.amount = builder.amount;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static abstract class Builder{
         private String paymentID,orderID, description;
         private double amount;

         public Builder paymentID(String paymentID){
             this.paymentID = paymentID;
             return this;
         }

         public Builder orderID(String orderID){
             this.orderID = orderID;
             return this;

         }

         public Builder description(String description)
         {
             this.description = description;
             return this;
         }

         public Builder amount(double amount)
         {
             this.amount = amount;
             return this;
         }

        public Builder copy(Payment payment) {
            this.paymentID = payment.paymentID;
            this.orderID = payment.orderID;
            this.description = payment.description;
            this.amount = payment.amount;
            return this;
        }

         public abstract Payment build();

    }



}
