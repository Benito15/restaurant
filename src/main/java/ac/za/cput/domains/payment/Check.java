package ac.za.cput.domains.payment;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Check extends Payment {

 private String bankID, name;


    public Check( String orderID, double amount, String bankID,String name){
        super(orderID,amount);
        this.bankID= bankID;
        this.name = name;
    }



    public String getBankID() {
        return bankID;
    }

    public String getName() {
        return name;
    }


    public void setBankID(String bankID) {
        this.bankID = bankID;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public Date dte() {
//        return dte();
//    }

//    @Override
//    public double payAmount() {
//        return 0;
//    }



////    public static class Builder extends Payment.Builder
////    {
////        private String bankID;
////        private String name;
////
////
////        public Builder(){
////            super();
////        }
////
////        public Builder bankID(String bankID)
////        {
////            this.bankID = bankID;
////            return this;
////
////        }
////
////        public Builder name(String name)
////        {
////            this.name = name;
////            return this;
////
////        }
////
//////        public Payment.Builder copy(Payment payment) {
//////            this.paymentID = payment.paymentID;
//////            this.orderID = payment.orderID;
//////            this.description = payment.description;
//////            this.amount = payment.amount;
//////            return this;
//////        }
////
////
////
////
////        public Check build()
////        {return new Check(this) {
////        };}
//
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Check check = (Check) o;
        return Objects.equals(bankID, check.bankID) &&
                Objects.equals(name, check.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bankID, name);
    }

    @Override
    public String toString() {
        return "\n Check{" +
                "bankID='" + bankID + "\n" +
                "name='" + name + "\n"+
                '}';
    }
}
