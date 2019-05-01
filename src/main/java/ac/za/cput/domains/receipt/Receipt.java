package ac.za.cput.domains.receipt;



import java.util.Date;
import java.util.Objects;

public class Receipt {

    private String recID,  desc;
    private Date dte;
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

    public Date getDte() {
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
        private String recID, desc;
        private Date dte;
        private double total;


        public Builder recID(String recID)
        {
            this.recID = recID;
            return this;

        }

        public Builder dte(Date dte)
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
                "ReceiptID='" + recID + '\'' +
                ", Date='" + dte + '\'' +
                ", Description='" + desc + '\'' +
                ", Total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Receipt)) return false;
        Receipt receipt = (Receipt) o;
        return Objects.equals(recID, receipt.recID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recID);
    }
}
