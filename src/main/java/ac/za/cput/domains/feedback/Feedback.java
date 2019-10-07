package ac.za.cput.domains.feedback;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "feedbacks", schema = "restaurant")
public class Feedback {

        @Id
        private String feedbackID;
        private String guestID;
        private String description;
        private String dte;

        public Feedback(){}

        public Feedback(Builder builder)
        {
            this.feedbackID = builder.feedbackID;
            this.guestID = builder.guestID;
            this.dte = builder.dte;
            this.description = builder.description;

        }

    public String getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(String feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getGuestID() {
            return guestID;
        }

        public String getDesc() {
            return description;
        }

        public String getDte() {
            return dte;
        }

        public void setGuestID(String guestID) {
            this.guestID = guestID;
        }

        public void setDesc(String description) {
            this.description = description;
        }

        public void setDte(String dte) {
            this.dte = dte;
        }

    public static class Builder
    {
        private String feedbackID,guestID,description;
        private String dte;

        public Builder guestID(String guestID)
        {
            this.guestID = guestID;
            return this;
        }

        public Builder feedbackID(String feedbackID)
        {
            this.feedbackID = feedbackID;
            return this;
        }


        public Builder desc(String description)
        {
            this.description=description;
            return this;
        }

        public Builder dte(String dte)
        {
            this.dte = dte;
            return this;
        }

        public Builder copy(Feedback feedback) {
            this.feedbackID = feedback.feedbackID;
            this.guestID = feedback.guestID;
            this.description = feedback.description;
            this.dte = feedback.dte;
            return this;
        }

        public Feedback build(){return new Feedback(this);}
    }

        @Override
        public String toString() {
            return "Feedback{" +"\n" +
                    "GuestID= " + guestID + "\n"  +
                    "Desciption = " + description + "\n" +
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



