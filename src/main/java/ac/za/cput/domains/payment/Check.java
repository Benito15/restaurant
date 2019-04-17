package ac.za.cput.domains.payment;

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




    @Override
    public String dte() {
        return null;
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
    public String toString() {
        return "Check{" +
                "bankID='" + bankID + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
