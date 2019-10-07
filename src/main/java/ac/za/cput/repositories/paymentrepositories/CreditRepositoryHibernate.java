package ac.za.cput.repositories.paymentrepositories;

import ac.za.cput.domains.payment.Credit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepositoryHibernate extends CrudRepository<Credit, String> {
}
