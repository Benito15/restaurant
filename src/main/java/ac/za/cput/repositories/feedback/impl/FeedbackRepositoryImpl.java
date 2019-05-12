package ac.za.cput.repositories.feedback.impl;

import ac.za.cput.domains.feedback.Feedback;
import ac.za.cput.repositories.feedback.FeedbackRepository;

import java.util.HashSet;
import java.util.Set;

public class FeedbackRepositoryImpl implements FeedbackRepository {

    private static FeedbackRepositoryImpl repository = null;
    private Set<Feedback> feedbacks;

    private FeedbackRepositoryImpl()
    {
        this.feedbacks = new HashSet<>();

    }

    public static FeedbackRepository getRepository()
    {
        if(repository == null) repository = new FeedbackRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Feedback> getAll() {
        return this.feedbacks;
    }

    @Override
    public Feedback create(Feedback feedback) {
        this.feedbacks.add(feedback);
        return feedback;
    }

    @Override
    public Feedback update(Feedback feedback) {

        Feedback feedbackUpdate = findID(feedback.getGuestID());
        if (feedbackUpdate != null)
        {
            this.feedbacks.remove(feedbackUpdate);
            return create(feedback);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Feedback feedback = findID(s);
        this.feedbacks.remove(s);
    }

    @Override
    public Feedback read(String s) {
       Feedback feedback = findID(s);
        if(feedbacks.equals(s))
            return feedback;
        return null;
    }

    public Feedback findID(String s)
    {
        return feedbacks.stream().filter(o -> o.getGuestID().equals(s))
                .findAny().orElse(null);
    }
}
