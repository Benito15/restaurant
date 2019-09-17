package ac.za.cput.factory.feedbackfactory;

import ac.za.cput.domains.feedback.Feedback;
import ac.za.cput.util.Misc;

import java.util.Date;

public class FeedbackFactory {

    public static Feedback getFeedback(String desc, Date dte, String guestID)
    {
        return new Feedback.Builder().desc(desc)
                .dte(dte)
                .guestID(guestID)
                .feedbackID(Misc.generateId())
                .build();

    }


}
