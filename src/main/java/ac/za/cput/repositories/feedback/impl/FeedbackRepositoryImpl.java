package ac.za.cput.repositories.feedback.impl;



import ac.za.cput.domains.feedback.Feedback;
import ac.za.cput.repositories.feedback.FeedbackRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("FeedbackInMemory")
public class FeedbackRepositoryImpl implements FeedbackRepository {

    private static FeedbackRepositoryImpl repository = null;
    private Set<Feedback> feedbacks;

    private FeedbackRepositoryImpl()
    {
        this.feedbacks = new HashSet<>();

    }

    public static FeedbackRepositoryImpl getRepository()
    {
        if(repository == null) repository = new FeedbackRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Feedback> getAll() {

        return feedbacks;
    }

    @Override
    public Feedback create(Feedback feedback) {
        this.feedbacks.add(feedback);
        return feedback;
    }

    @Override
    public Feedback update(Feedback feedback) {
        Feedback readFeadback = repository.read(feedback);
        if(this.feedbacks.contains(readFeadback)){
            this.feedbacks.remove(readFeadback);
            this.feedbacks.add(feedback);
            return feedback;
        }
        return null;
    }

    @Override
    public void delete(Feedback feedback) {
        Feedback deleteFeedback = read(feedback);
        this.feedbacks.remove(deleteFeedback);

    }

    @Override
    public Feedback read(Feedback feedback) {
        return this.feedbacks.stream()
                .filter(thisFeedback -> thisFeedback.getFeedbackID().equalsIgnoreCase(feedback.getFeedbackID())
                && thisFeedback.getGuestID().equalsIgnoreCase(feedback.getGuestID())).findAny().orElse(null);

    }



}
