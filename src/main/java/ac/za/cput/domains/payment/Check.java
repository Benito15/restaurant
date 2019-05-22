package ac.za.cput.domains.payment;

import java.util.Date;
import java.util.Objects;

public class Check implements Payment {

 private String bankID, name;

 private Check(){}

 private Check(Builder builder)
 {
    this.bankID = bankID;
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

    @Override
    public Date dte() {
        return dte();
    }

    @Override
    public double payAmount() {
        return 0;
    }



    public static class Builder
    {
        private String bankID;
        private String name;


        public Builder bankID(String bankID)
        {
            this.bankID = bankID;
            return this;

        }

        public Builder name(String name)
        {
            this.name = name;
            return this;

        }

        public Check build() {return new Check(this);}

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Check)) return false;
        Check check = (Check) o;
        return Objects.equals(getBankID(), check.getBankID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBankID());
    }

    @Override
    public String toString() {
        return "\n Check{" +
                "bankID='" + bankID + "\n" +
                "name='" + name + "\n"+
                '}';
    }
}
