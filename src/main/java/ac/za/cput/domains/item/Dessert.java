package ac.za.cput.domains.item;

public class Dessert extends Item {


    private String type;


    public Dessert(Builder builder)
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
        return "Dessert{" +
                "desc='" + desc + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
