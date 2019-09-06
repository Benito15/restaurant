package ac.za.cput.domains.purchase.orderline;



public class OrderLine {
//////////
    private String orderID, itemID, desc;
    private int qty;

    public OrderLine(String orderID, String itemID, String desc, int qty){
        this.orderID = orderID;
        this.itemID = itemID;
        this.desc = desc;
        this.qty = qty;
    }

    public String getItemID() {
        return itemID;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getDesc() {
        return desc;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getQty() {
        return qty;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

//    public static class Builder
//    {
//        private String orderID;
//        private String itemID;
//        private String desc;
//        private int qty;
//
//        public Builder orderID(String orderID){
//            this.orderID= orderID;
//            return this;
//        }
//
//        public Builder itemID(String itemID){
//            this.itemID = itemID;
//            return this;
//
//        }
//
//        public Builder desc (String desc){
//            this.desc = desc;
//            return this;
//
//        }
//
//        public Builder qty (int qty){
//            this.qty = qty;
//            return this;
//        }
//
//        public OrderLine build(){ return new OrderLine(this);}
//
//
//    }

    @Override
    public String toString() {
        return "\n OrderLine{" +
                "orderID= " + orderID + "\n" +
                "itemID= " + itemID + "\n" +
                "Quantity= " + this.qty + "\n" +
                "Description= " + desc + "\n" ;
    }
}
