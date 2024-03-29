package ac.za.cput.domains.inventory;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Inventory {

    @Id
    private String invID;
    private String description;
    private int qty;

    private Inventory(){}

    public Inventory(Builder builder){
        this.invID = builder.invID;
        this.description = builder.description;
        this.qty = builder.qty;
    }

    public String getInvID() {
        return invID;
    }

    public String getDesc() {
        return description;
    }

    public int getQty() {
        return qty;
    }

    public void setInvID(String invID) {
        this.invID = invID;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public static class Builder
   {
       private String invID;
       private String description;
       private int qty;

       public Builder invID(String invID)
       {
           this.invID = invID;
           return this;

       }

       public Builder desc(String description)
       {
           this.description = description;
           return this;

       }

        public Builder qty(int qty)
        {
           this.qty = qty;
           return this;

        }

       public Builder copy(Inventory inventory) {
           this.invID = inventory.invID;
           this.description= inventory.description;
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
                ", desc='" + description + "\n" +
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
