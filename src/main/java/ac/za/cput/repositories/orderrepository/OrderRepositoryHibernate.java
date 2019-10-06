package ac.za.cput.repositories.orderrepository;

import ac.za.cput.domains.purchase.order.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryHibernate extends CrudRepository<Order, String> {

}
