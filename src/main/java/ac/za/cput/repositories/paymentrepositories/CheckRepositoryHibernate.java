package ac.za.cput.repositories.paymentrepositories;

import ac.za.cput.domains.payment.Check;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckRepositoryHibernate extends CrudRepository<Check, String> {
}
