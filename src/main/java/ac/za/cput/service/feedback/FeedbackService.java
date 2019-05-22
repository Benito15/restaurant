package ac.za.cput.service.feedback;

import ac.za.cput.domains.feedback.Feedback;
import ac.za.cput.service.IService;

import java.util.Set;

public interface FeedbackService extends IService<Feedback, String> {
    Set<Feedback> getAll();
}
