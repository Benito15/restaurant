package ac.za.cput.domains.proofofpayment.payment;

import java.util.Date;

public class Credit implements Payment {

    private String cardID;
    private String name;

    private Credit(){}

    public Credit(Builder builder)
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

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public void setName(String name) {
        this.name = name;
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
    public Date dte() {
        return dte();
    }

    @Override
    public double payAmount() {
        return 0;
    }


    @Override
    public String toString() {
        return "\n Credit{" +
                "cardID='" + cardID + "\n"+
                ", name='" + name + "\n" +
                '}';
    }
}
