package ac.za.cput.factory.feedbackfactory;

import ac.za.cput.domains.feedback.Feedback;
import ac.za.cput.util.Misc;

import java.util.Date;

public class FeedbackFactory {




    public static Feedback getFeedback(String desc, Date dte)
    {
        return new Feedback.Builder().desc(desc)
                .dte(dte)
                .guestID(Misc.generateId())
                .build();

    }


}
