package ac.za.cput.domains.payment;

public class Credit implements Payment {

    private String cardID;
    private String name;

    private Credit(){}

    private Credit(Builder builder)
    {
        this.cardID = builder.cardID;
        this.name = builder.name;

    }

    public String getCardID() {
        return cardID;
    }

    public String getName() {
        return name;
    }

    public static class Builder
    {
        String cardID, name;

        public Builder cardID(String cardID)
        {
            this.cardID = cardID;
            return this;
        }

        public Builder name(String name)
        {
            this.name = name;
            return this;
        }

        public Credit build(){return new Credit(this);}
    }


    @Override
    public String dte() {
        return null;
    }

    @Override
    public double payAmount() {
        return 0;
    }


    @Override
    public String toString() {
        return "Credit{" +
                "cardID='" + cardID + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
