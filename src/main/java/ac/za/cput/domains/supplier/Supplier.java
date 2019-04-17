package ac.za.cput.domains.supplier;

public class Supplier {

    private String  supID;
    private String name;
    private String address;

    private Supplier(){}

    private Supplier(Builder builder)
    {
        this.supID = builder.supID;
        this.name = builder.name;
        this.address = builder.address;

    }

    public String getSupID() {
        return supID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder
    {
        private String supID, name, address;

        public Builder supID(String supID)
        {
            this.supID = supID;
            return this;

        }

        public Builder name(String name)
        {
            this.name = name;
            return this;

        }

         public Builder address(String name)
        {
            this.address = address;
            return this;

        }


 public Supplier build(){return new Supplier(this);}

    }

}
