package ac.za.cput.domains.domainreservation;

public class Reservation {

    private String resID;
    private int totGuest;

    public Reservation()
    {}

    public Reservation(Builder build)
    {

        this.resID= build.resID;
        this.totGuest=build.totGuest;
    }

    public String getResID() {
        return resID;
    }

    public int getTotGuest() {
        return totGuest;
    }

    public static class Builder
    {
        private String resID;
        private int totGuest;

        public Builder resID(String resID)
        {
            this.resID = resID;
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
        return "Reservation{" +
                "resID='" + resID + '\'' +
                ", totGuest=" + totGuest +
                '}';
    }
}
