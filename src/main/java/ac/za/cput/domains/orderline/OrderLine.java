package ac.za.cput.domains.orderline;



public class OrderLine {
//////////
    private String orderID;
    private String desc;

    private OrderLine(){}

    private OrderLine(Builder builder)
    {
        this.orderID = builder.orderID;
        this.desc = builder.desc;

    }

    public String getOrderID() {
        return orderID;
    }

    public String getDesc() {
        return desc;
    }

    public static class Builder
    {
        private String orderID;
        private String desc;


        public Builder orderID(String orderID)
        {
            this.orderID= orderID;
            return this;

        }

        public Builder desc (String desc)
        {
            this.desc = desc;
            return this;

        }

        public OrderLine build(){ return new OrderLine(this);}


    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "orderID='" + orderID + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
