package ac.za.cput.domains.order;

import java.util.Date;
import java.util.Objects;

public class Order {
///empi
    private String orderID;
    private String guestID;
    private Date dte;
    private double total;

    private Order(){}

    private Order(Builder builder)
    {
        this.orderID =  builder.orderID;
        this.guestID = builder.guestID;
        this.dte = builder.dte;
        this.total = builder.total;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getGuestID() {
        return guestID;
    }

    public Date getDte() {
        return dte;
    }

    public double getTotal() {
        return total;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

    public void setDte(Date dte) {
        this.dte = dte;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public static class Builder
    {
        private String orderID,guestID;
        private Date dte;
        private double total;


        public Builder orderID(String orderID)
        {
            this.orderID = orderID;
            return this;

        }

        public Builder guestID(String guestID)
        {
            this.guestID = guestID;
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
        return "\n"+"orderID= " + orderID + "\n" +
                "Date='" + dte + "\n"+
                "total=" + total  + "\n";
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
