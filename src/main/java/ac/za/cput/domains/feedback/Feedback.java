package ac.za.cput.domains.feedback;



import java.util.Date;
import java.util.Objects;

    public class Feedback {


        private String guestID, desc;
        private Date dte;

        private Feedback(){}

        private Feedback(Builder builder)
        {
            this.guestID = builder.guestID;
            this.dte = builder.dte;
            this.desc = builder.desc;

        }

        public String getGuestID() {
            return guestID;
        }

        public String getDesc() {
            return desc;
        }

        public Date getDte() {
            return dte;
        }

        public void setGuestID(String guestID) {
            this.guestID = guestID;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setDte(Date dte) {
            this.dte = dte;
        }

        public static class Builder
        {
            private String guestID,desc;
            private Date dte;

            public Builder guestID(String guestID)
            {
                this.guestID = guestID;
                return this;
            }



            public Builder desc(String desc)
            {
                this.desc=desc;
                return this;
            }

            public Builder dte(Date dte)
            {
                this.dte = dte;
                return this;
            }

            public Feedback build(){return new Feedback(this);}
        }

        @Override
        public String toString() {
            return "Feedback{" +"\n" +
                    "GuestID= " + guestID + "\n"  +
                    "Desciption = " + desc + "\n" +
                    "Date= " + dte +"\n"  +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Feedback)) return false;
            Feedback feedback = (Feedback) o;
            return Objects.equals(guestID, feedback.guestID);
        }

        @Override
        public int hashCode() {
            return Objects.hash(guestID);
        }
    }



