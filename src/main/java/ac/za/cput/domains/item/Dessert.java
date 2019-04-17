package ac.za.cput.domains.item;

public class Dessert {

    private String desc;
    private int qty;
    private double price;

    private Dessert(){}

    private Dessert(Builder builder)
    {
        this.desc = builder.desc;
        this.qty = builder.qty;
        this.price = builder.price;

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
        private String desc;
        private int qty;
        private double price;

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

        public Builder price(double price)
        {
            this.price = price;
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
