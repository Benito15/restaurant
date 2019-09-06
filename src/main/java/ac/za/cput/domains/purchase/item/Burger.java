package ac.za.cput.domains.purchase.item;

public class Burger extends Item {

   private String type;

   public Burger() {
   }

    public Burger(Builder builder) {
       super(builder);
        type = "";
    }

    public String getType() {
        return type;
    }

    public static class Builder extends Item.Builder{

        String type;

        public Builder type(String type)
        {
            this.type = type;
            return this;
        }


        public Burger build() {
            return new Burger(this);
        }

    }

    @Override
    public String toString() {
        return "Burger{" +
                "ItemID='" + itemID + "\n" +
                "Desc='" + desc + "\n" +
                "qty=" + qty + "\n"+
                "type='" + type + "\n" +
                "price=" + price + "\n";
    }
}

