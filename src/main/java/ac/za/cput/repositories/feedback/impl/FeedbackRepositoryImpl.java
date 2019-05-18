package ac.za.cput.repositories.feedback.impl;

import ac.za.cput.domains.feedback.Feedback;
import ac.za.cput.repositories.feedback.FeedbackRepository;

import java.util.*;

public class FeedbackRepositoryImpl implements FeedbackRepository {

    private static FeedbackRepositoryImpl repository = null;
    private Map<String,Feedback> feedbacks;

    private FeedbackRepositoryImpl()
    {
        this.feedbacks = new HashMap<>();

    }

    public static FeedbackRepositoryImpl getRepository()
    {
        if(repository == null) repository = new FeedbackRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Feedback> getAll() {
        Collection<Feedback> feedbacks = this.feedbacks.values();
        Set<Feedback> set = new HashSet<>();
        set.addAll(feedbacks);
        return set;
    }

    @Override
    public Feedback create(Feedback feedback) {
        this.feedbacks.put(feedback.getGuestID(),feedback);
        return feedback;
    }

    @Override
    public Feedback update(Feedback feedback) {
        this.feedbacks.replace(feedback.getGuestID(),feedback);
        return this.feedbacks.get(feedback.getGuestID());

    }

    @Override
    public void delete(String s) {

        this.feedbacks.remove(s);
    }

    @Override
    public Feedback read(String s) {
        return this.feedbacks.get(s);

    }

//    public Feedback findID(String s)
//    {
//        return feedbacks.stream().filter(o -> o.getGuestID().equals(s))
//                .findAny().orElse(null);
//    }
}
