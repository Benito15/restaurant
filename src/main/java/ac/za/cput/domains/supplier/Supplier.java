package ac.za.cput.domains.supplier;

import java.util.Objects;

public class Supplier {

    private String  supID;
    private String name;
    private String address;

    private Supplier(){}

    public Supplier(Builder builder)
    {
        this.supID = builder.supID;
        this.name = builder.name;
        this.address = builder.address;

    }

    public void setSupID(String supID) {
        this.supID = supID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
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

         public Builder address(String address)
        {
            this.address = address;
            return this;

        }

        public Builder copy(Supplier supplier) {
            this.supID = supplier.supID;
            this.name = supplier.name;
            this.address = supplier.address;
            return this;
        }


 public Supplier build(){return new Supplier(this);}

    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplier ID='" + supID + "\n" +
                ", Name='" + name + "\n" +
                ", Address='" + address + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supplier)) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(getSupID(), supplier.getSupID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSupID());
    }
}
