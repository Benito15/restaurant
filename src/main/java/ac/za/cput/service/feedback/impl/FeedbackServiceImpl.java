package ac.za.cput.service.feedback.impl;

import ac.za.cput.domains.feedback.Feedback;
import ac.za.cput.repositories.feedback.FeedbackRepository;
import ac.za.cput.repositories.feedback.FeedbackRepositoryHibernate;
import ac.za.cput.repositories.feedback.impl.FeedbackRepositoryImpl;
import ac.za.cput.service.feedback.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("FeedbackService")
public class FeedbackServiceImpl implements FeedbackService {

    private static FeedbackServiceImpl service = null;
    @Autowired
    private FeedbackRepositoryHibernate repository;

    private FeedbackServiceImpl()
    {

    }

    public static FeedbackServiceImpl getService()
    {
        if(service ==null )
            return new FeedbackServiceImpl();
        return service;
    }

    @Override
    public Set<Feedback> getAll() {
        return new HashSet<Feedback>((List<Feedback>)repository.findAll());
    }

    @Override
    public Feedback create(Feedback type) {
        return this.repository.save(type);
    }

    @Override
    public Feedback update(Feedback type) {
        return this.repository.save(type);
    }

    @Override
    public void delete(String feed) {

        this.repository.deleteById(feed);
    }

    @Override
    public Feedback read(String feed) {
        return this.repository.findById(feed).orElse(null);
    }
}
