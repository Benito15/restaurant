package ac.za.cput.repositories.item;

import ac.za.cput.domains.purchase.item.Beverage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeverageRepositoryHibernate extends CrudRepository <Beverage, String> {
}
