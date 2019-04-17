package ac.za.cput.domains.receipt;

import org.apache.maven.model.Build;

public class Receipt {

    private String recID, dte, desc;
    private double total;

    private Receipt(){}

    private Receipt(Builder builder)
    {
        this.recID = builder.recID;
        this.dte = builder.dte;
        this.desc = builder.desc;
        this.total = builder.total;

    }

    public String getBillID() {
        return recID;
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
        private String recID, dte, desc;
        private double total;


        public Builder recID(String recID)
        {
            this.recID = recID;
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

        public Receipt build(){return new Receipt(this);}

    }


    @Override
    public String toString() {
        return "receipt{" +
                "recID='" + recID + '\'' +
                ", dte='" + dte + '\'' +
                ", desc='" + desc + '\'' +
                ", total=" + total +
                '}';
    }
}
