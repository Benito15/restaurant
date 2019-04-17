package ac.za.cput.domains.inventory;

public class Inventory {
    private String invID;
    private String desc;
    private int qty;


    public Inventory(){}

    public Inventory(Builder builder)
    {
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

       public Inventory build()
       {
           return new Inventory(this);
       }


   }


    @Override
    public String toString() {
        return "Inventory{" +
                "invID='" + invID + '\'' +
                ", desc='" + desc + '\'' +
                ", qty=" + qty +
                '}';
    }
}
