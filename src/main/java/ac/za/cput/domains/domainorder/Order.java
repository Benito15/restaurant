package ac.za.cput.domains.domainorder;

public class Order {
///empi
    private String orderID;
    private String dte;
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

    public String getDte() {
        return dte;
    }

    public double getTotal() {
        return total;
    }

    public static class Builder
    {
        private String orderID, dte;
        private double total;


        public Builder orderID(String orderID)
        {
            this.orderID = orderID;
            return this;

        }

        public Builder dte(String dte)
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
                ", dte='" + dte + '\'' +
                ", total=" + total +
                '}';
    }
}
