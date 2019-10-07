package ac.za.cput.repositories.feedback;

import ac.za.cput.domains.feedback.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepositoryHibernate extends CrudRepository<Feedback, String > {
}
