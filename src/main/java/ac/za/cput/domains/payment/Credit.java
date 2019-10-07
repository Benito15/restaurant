package ac.za.cput.domains.payment;

import javax.persistence.Entity;

@Entity
public class Credit extends Payment {

    private String cardID;
    private String name;



    public Credit( String orderID, double amount, String cardID,String name)
    {
        super(orderID,amount);
        this.cardID = cardID;
        this.name = name;

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

//    public static class Builder extends Payment.Builder
//    {
//        String cardID, name;
//
//        public Builder(){
//            super();
//        }
//        public Builder cardID(String cardID)
//        {
//            this.cardID = cardID;
//            return this;
//        }
//
//        public Builder name(String name)
//        {
//            this.name = name;
//            return this;
//        }
//
//        public Payment build(){return new Credit(this);}
//    }


    @Override
    public String toString() {
        return "\n Credit{" +
                "cardID='" + cardID + "\n"+
                ", name='" + name + "\n" +
                '}';
    }
}
