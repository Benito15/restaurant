package ac.za.cput.service.feedback;

import ac.za.cput.domains.feedback.Feedback;
import ac.za.cput.service.IService;

import java.util.Set;

public interface FeedbackService  {
    Feedback create(Feedback feedback);
    Feedback read(Feedback feedback);
    Feedback update(Feedback feedback);
    void delete(Feedback feedback);

    Set<Feedback> getAll();
}
