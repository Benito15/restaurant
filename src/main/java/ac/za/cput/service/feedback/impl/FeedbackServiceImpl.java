package ac.za.cput.service.feedback.impl;

import ac.za.cput.domains.feedback.Feedback;
import ac.za.cput.repositories.feedback.FeedbackRepository;
import ac.za.cput.repositories.feedback.impl.FeedbackRepositoryImpl;
import ac.za.cput.service.feedback.FeedbackService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("FeedbackService")
public class FeedbackServiceImpl implements FeedbackService {

    private FeedbackServiceImpl service = null;
    private FeedbackRepository repository;

    private FeedbackServiceImpl()
    {
        repository = FeedbackRepositoryImpl.getRepository();
    }

    public  FeedbackServiceImpl getService()
    {
        if(service ==null )
            return new FeedbackServiceImpl();
        return service;
    }

    @Override
    public Set<Feedback> getAll() {
        return repository.getAll();
    }

    @Override
    public Feedback create(Feedback type) {
        return this.repository.create(type);
    }

    @Override
    public Feedback update(Feedback type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {

        this.repository.delete(s);
    }

    @Override
    public Feedback read(String s) {
        return this.repository.read(s);
    }
}
