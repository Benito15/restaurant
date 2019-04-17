package ac.za.cput.domains.catalog;

public class Catalog {

    private String itemID;
    private String supID;

    private Catalog(){}

    private Catalog (Builder builder)
    {
        this.itemID = itemID;
        this.supID = supID;

    }

    public String getItemID() {
        return itemID;
    }

    public String getSupID() {
        return supID;
    }

    public static class Builder
    {

        private String itemID;
        private String supID;

        public Builder itemID(String itemID)
        {
            this.itemID = itemID;
            return this;

        }

        public Builder supID(String supID)
        {
            this.supID = supID;
            return this;

        }

        public Catalog build() {return new Catalog (this);}

    }

    @Override
    public String toString() {
        return "Catalog{" +
                "itemID='" + itemID + '\'' +
                ", supID='" + supID + '\'' +
                '}';
    }
}
