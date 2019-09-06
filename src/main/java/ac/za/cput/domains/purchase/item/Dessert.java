package ac.za.cput.domains.purchase.item;

public class Dessert extends Item {

    private String type;

    private Dessert(){}

    private Dessert(Builder builder)
    {
        super(builder);
        type="";
    }

    public String getType() {
        return type;
    }

    public static class Builder extends Item.Builder
    {

       String type;

        public Builder type(String type)
        {
            this.type = type;
            return this;
        }

        public Dessert build()
        {
            return new Dessert(this);
        }

    }

    @Override
    public String toString() {
        return "\n Dessert{" +
                "Desc='" + desc + "\n"+
                "qty=" + qty + "\n" +
                "Price=" + price + "\n";
    }
}
