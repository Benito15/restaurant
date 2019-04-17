package ac.za.cput.domains.item;

import org.apache.maven.model.Build;

public class Item {
  /////////////////////

   private String itemID;
    private String desc;

    private int qty;
    private double price;



    private Item(Builder builder)
    {
        this.itemID = builder.itemID;
        this.desc = builder.desc;
        this.qty = builder.qty;
        this.price = builder.price;

    }

    public String getItemID() {
        return itemID;
    }

    public String getDesc() {
        return desc;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public static class Builder
    {

        private String itemID, desc;
        private double price;
        private int qty;


        public Builder itemID(String itemID)
        {
            this.itemID = itemID;
            return this;

        }

        public Builder desc(String desc)
        {
            this.desc = desc;
            return this;

        }

        public Builder price(double price)
        {
            this.price = price;
            return this;

        }

        public Builder qty(int qty)
        {
            this.qty = qty;
            return this;

        }
        public Item build()
        {
            return new Item(this);
        }

    }




}
