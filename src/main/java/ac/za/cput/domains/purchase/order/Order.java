package ac.za.cput.domains.purchase.order;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Orders", schema = "restaurant")
public class Order {
///empi
    @Id
    private String orderID;
    @Column(name = "guestID" )
    private String guestID;
    @Column(name = "employeeID" )
    private String empID;
    @Column(name = "date" )
    private String dte;
    @Column(name = "Total" )
    private double total;

    public Order(){}

    public Order(Builder builder)
    {
        this.orderID =  builder.orderID;
        this.guestID = builder.guestID;
        this.empID = builder.empID;
        this.dte = builder.dte;
        this.total = builder.total;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getGuestID() {
        return guestID;
    }

    public String getDte() {
        return dte;
    }

    public double getTotal() {
        return total;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

    public void setDte(String dte) {
        this.dte = dte;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public static class Builder
    {
        private String orderID,guestID, empID;
        private String dte;
        private double total;

        public Builder empID(String empID){
            this.empID=empID;
            return this;

        }

        public Builder orderID(String orderID)
        {
            this.orderID = orderID;
            return this;

        }

        public Builder guestID(String guestID)
        {
            this.guestID = guestID;
            return this;

        }

        public Builder dte(String dte)
        {
            this.dte = dte;
             return this;
        }

        public Builder total(double total)
        {
            this.total = total;
            return this;

        }

        public Builder copy(Order order) {
            this.orderID =  order.orderID;
            this.guestID = order.guestID;
            this.empID = order.empID;
            this.dte = order.dte;
            this.total = order.total;
            return this;
        }

        public Order build(){return new Order(this);}

    }


    @Override
    public String toString() {
        return "\n"+"orderID= " + orderID + "\n" +
                "Date='" + dte + "\n"+
                "total=" + total  + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getOrderID(), order.getOrderID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderID());
    }
}
