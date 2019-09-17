package ac.za.cput.repositories.feedback;

import ac.za.cput.domains.feedback.Feedback;
import ac.za.cput.factory.feedbackfactory.FeedbackFactory;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface FeedbackRepository  {


        Feedback create(Feedback feedback);
        Feedback read(Feedback feedback);
        Feedback update(Feedback feedback);
        void delete(Feedback feedback);

        Set<Feedback> getAll();



}
