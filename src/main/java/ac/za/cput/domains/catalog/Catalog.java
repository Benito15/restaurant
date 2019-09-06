package ac.za.cput.domains.catalog;

public class Catalog {

    private String itemID;
    private String supID;
    private String description;

    public Catalog(String itemID, String supID, String description){}

//    public Catalog (Builder builder)
//    {
//        this.itemID = builder.itemID;
//        this.supID = builder.supID;
//        this.description = builder.description;
//
//    }


    public String getItemID() {
        return itemID;
    }

    public String getDescription() {
        return description;
    }

    public String getSupID() {
        return supID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setSupID(String supID) {
        this.supID = supID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public static class Builder
//    {
//
//        private String itemID;
//        private String supID;
//        private String description;
//
//        public Builder itemID(String itemID)
//        {
//            this.itemID = itemID;
//            return this;
//
//        }
//
//        public Builder supID(String supID)
//        {
//            this.supID = supID;
//            return this;
//
//        }
//
//        public Builder description(String description)
//        {
//            this.description = description;
//            return this;
//        }
//
//        public Catalog build() {return new Catalog (this);}
//
//    }

    @Override
    public String toString() {
        return "\n Catalog" +
                "ItemID='" + itemID + "\n" +
                "supID='" + supID + "\n" +
                "Description = " + description+ "\n" ;
    }
}
