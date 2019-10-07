package ac.za.cput.domains.purchase.item;

import javax.persistence.Entity;

@Entity
public class Dessert extends Item {

    private String type;

    private Dessert(){}

    private Dessert(Builder builder)
    {
        super(builder);
        this.type = builder.type;
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
                "Desc='" + description + "\n"+
                "qty=" + qty + "\n" +
                "Price=" + price + "\n";
    }
}
