package ac.za.cput.domains.bill;

public class Bill {


    private String billID, dte, desc;
    private double total;

    private Bill(){}

    private Bill(Builder builder)
    {
        this.billID = builder.billID;
        this.dte = builder.dte;
        this.desc = builder.desc;
        this.total = builder.total;

    }

    public String getBillID() {
        return billID;
    }

    public String getDte() {
        return dte;
    }

    public String getDesc() {
        return desc;
    }

    public double getTotal() {
        return total;
    }


    public static class Builder
    {
        private String billID, dte, desc;
        private double total;


        public Builder billID(String billID)
        {
            this.billID = billID;
            return this;

        }

        public Builder dte(String dte)
        {
            this.dte = dte;
            return this;

        }

        public Builder desc(String desc)
        {
            this.desc = desc;
            return this;

        }


        public Builder total(double total)
        {
            this.total = total;
            return this;

        }

        public Bill build(){return new Bill(this);}

    }

    @Override
    public String toString() {
        return "Bill{" +
                "billID='" + billID + '\'' +
                ", dte='" + dte + '\'' +
                ", desc='" + desc + '\'' +
                ", total=" + total +
                '}';
    }
}
