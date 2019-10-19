package ac.za.cput.domains.purchase.item;


import ac.za.cput.domains.proofofpayment.bill.Bill;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class Item {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    protected String itemID;
    protected String description;
    protected int qty;
    protected double price;

    public Item(){}

    protected Item(Builder builder)
    {
        this.itemID = builder.itemID;
        this.description = builder.description;
        this.qty = builder.qty;
        this.price = builder.price;

    }

    public String getItemID() {
        return itemID;
    }

    public String getDesc() {
        return description;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setDesc(String description) {
        this.description = description;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static abstract class Builder
    {

        private String itemID, description;
        private double price;
        private int qty;


        public Builder itemID(String itemID)
        {
            this.itemID = itemID;
            return this;

        }

        public Builder description(String description)
        {
            this.description = description;
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
        public Builder copy(Item item) {
            this.itemID = item.itemID;
            this.description = item.description;
            this.qty = item.qty;
            this.price = item.price;
            return this;
        }

        public abstract Item build();

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(getItemID(), item.getItemID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemID());
    }

    @Override
    public String toString() {
        return "\n Item{" +
                "ItemID= " + itemID + "\n" +
                "desc= " + description + "\n"+
                "qty= " + qty + "\n"+
                "Price= " + price +"\n";
    }
}
