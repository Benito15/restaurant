package ac.za.cput.domains.domainorder;

import java.util.Date;
import java.util.Objects;

public class Order {
///empi
    private String orderID;
    private Date dte;
    private double total;

    private Order(){}

    public Order(Builder builder)
    {
        this.orderID =  builder.orderID;
        this.dte = builder.dte;
        this.total = builder.total;
    }

    public String getOrderID() {
        return orderID;
    }

    public Date getDte() {
        return dte;
    }

    public double getTotal() {
        return total;
    }

    public static class Builder
    {
        private String orderID;
        private Date dte;
        private double total;


        public Builder orderID(String orderID)
        {
            this.orderID = orderID;
            return this;

        }

        public Builder dte(Date dte)
        {

             this.dte = dte;
             return this;


        }

        public Builder total(double total)
        {
            this.total = total;
            return this;

        }


        public Order build(){return new Order(this);}

    }


    @Override
    public String toString() {
        return "ord{" +
                "orderID='" + orderID + '\'' +
                ", Date='" + dte + '\'' +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getOrderID(), order.getOrderID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderID());
    }
}
