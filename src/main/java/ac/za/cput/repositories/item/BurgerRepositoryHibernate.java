package ac.za.cput.repositories.item;

import ac.za.cput.domains.purchase.item.Burger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BurgerRepositoryHibernate extends CrudRepository<Burger, String> {

}
