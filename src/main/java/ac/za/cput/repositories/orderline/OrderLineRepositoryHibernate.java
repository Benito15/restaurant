package ac.za.cput.repositories.orderline;

import ac.za.cput.domains.purchase.orderline.OrderLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepositoryHibernate extends CrudRepository <OrderLine,String> {

}
