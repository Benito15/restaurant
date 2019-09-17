package ac.za.cput.domains.proofofpayment.receipt;



import java.util.Date;
import java.util.Objects;

public class Receipt {

    private String recID, billID,  desc;
    private Date dte;
    private double total;

    private Receipt(){}

    public Receipt(Builder builder)
    {
        this.recID = builder.recID;
        this.billID = builder.billID;
        this.dte = builder.dte;
        this.desc = builder.desc;
        this.total = builder.total;

    }

    public String getRecID() {
        return recID;
    }

    public String getBillID() {
        return billID;
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

    public void setRecID(String recID) {
        this.recID = recID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDte(Date dte) {
        this.dte = dte;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public static class Builder
    {
        private String recID,billID, desc;
        private Date dte;
        private double total;


        public Builder recID(String recID)
        {
            this.recID = recID;
            return this;

        }

        public Builder billID(String billID)
        {
            this.billID = billID;
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

        public Builder copy(Receipt receipt) {
            this.billID = receipt.billID;
            this.recID = receipt.billID;
            this.dte = receipt.dte;
            this.desc = receipt.desc;
            this.total = receipt.total;
            return this;
        }

        public Receipt build(){return new Receipt(this);}

    }


    @Override
    public String toString() {
        return "receipt{" +
                "ReceiptID='" + recID + "\n" +
                "billID= " + billID + "\n"  +
                ", Date='" + dte + "\n"  +
                ", Description='" + desc + "\n"  +
                ", Total=" + total+ "\n"  ;
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
