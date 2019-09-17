package ac.za.cput.domains.inventory;

import java.util.Objects;

public class Inventory {

    private String invID;
    private String desc;
    private int qty;

    private Inventory(){}

    public Inventory(Builder builder){
        this.invID = builder.invID;
        this.desc = builder.desc;
        this.qty = builder.qty;
    }

    public String getInvID() {
        return invID;
    }

    public String getDesc() {
        return desc;
    }

    public int getQty() {
        return qty;
    }

    public void setInvID(String invID) {
        this.invID = invID;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public static class Builder
   {
       private String invID;
       private String desc;
       private int qty;

       public Builder invID(String invID)
       {
           this.invID = invID;
           return this;

       }

       public Builder desc(String desc)
       {
           this.desc = desc;
           return this;

       }

        public Builder qty(int qty)
        {
           this.qty = qty;
           return this;

        }

       public Builder copy(Inventory inventory) {
           this.invID = inventory.invID;
           this.desc= inventory.desc;
           this.qty= inventory.qty;
           return this;
       }

       public Inventory build()
       {
           return new Inventory(this);
       }


   }


    @Override
    public String toString() {
        return "Inventory{" +
                "invID='" + invID + "\n" +
                ", desc='" + desc + "\n" +
                ", qty=" + qty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventory)) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(getInvID(), inventory.getInvID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvID());
    }
}
