package ac.za.cput.repositories.item;

import ac.za.cput.domains.purchase.item.Dessert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DessertRepositoryHibernate extends CrudRepository <Dessert, String > {
}
