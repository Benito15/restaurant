package ac.za.cput.domains.proofofpayment.bill;

import java.util.Date;
import java.util.Objects;

public class Bill {


    private String billID, desc;
    private String orderID;
    private Date dte;
    private double total;

    private Bill(){

    }

    public Bill(Builder builder)
    {
        this.billID = builder.billID;
        this.orderID = builder.billID;
        this.dte = builder.dte;
        this.desc = builder.desc;
        this.total = builder.total;

    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
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


    public static class Builder
    {
        private String billID,  desc;
        private String orderID;
        private Date dte;
        private double total;


        public Builder orderID(String orderID){
            this.orderID = orderID;
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

        public Builder copy(Bill bill) {
            this.billID = bill.billID;
            this.orderID = bill.billID;
            this.dte = bill.dte;
            this.desc = bill.desc;
            this.total = bill.total;
            return this;
        }
        public Bill build(){return new Bill(this);}

    }

    @Override
    public String toString() {
        return "Bill{" +
                " BillID='" + billID + '\'' +
                ", Date='" + dte + '\'' +
                ", Description='" + desc + '\'' +
                ", Total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bill)) return false;
        Bill bill = (Bill) o;
        return Objects.equals(getBillID(), bill.getBillID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBillID());
    }
}
