package ac.za.cput.domains.reservation;

import java.util.Objects;

public class Reservation {

    private String guestID,tableID;

    private int totGuest;

    private Reservation()
    {}

    private Reservation(Builder builder)
    {

        this.guestID= builder.guestID;
        this.tableID = builder.tableID;
        this.totGuest=builder.totGuest;
    }

    public String getGuestID() {
        return guestID;
    }

    public String getTableID() {
        return tableID;
    }

    public int getTotGuest() {
        return totGuest;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

    public void setTableID(String tableID) {
        this.tableID = tableID;
    }

    public void setTotGuest(int totGuest) {
        this.totGuest = totGuest;
    }

    public static class Builder
    {
        private String guestID,tableID;
        private int totGuest;

        public Builder guestID(String guestID)
        {
            this.guestID = guestID;
            return this;

        }

        public Builder tableID(String tableID)
        {
            this.tableID = tableID;
            return this;
        }

        public Builder totGuest(int totGuest)
        {
            this.totGuest = totGuest;
            return this;

        }

        public Reservation build(){return  new Reservation(this);}

    }

    @Override
    public String toString() {
        return " \n Reservation{" +
                "resID= " + guestID + "\n" +
                "TableID= " + this.tableID+ "\n" +
                ", totGuest=" + totGuest + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(guestID, that.guestID) &&
                Objects.equals(getTableID(), that.getTableID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestID, getTableID());
    }
}
