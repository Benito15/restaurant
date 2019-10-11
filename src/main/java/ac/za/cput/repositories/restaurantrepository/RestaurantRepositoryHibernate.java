package ac.za.cput.repositories.restaurantrepository;

import ac.za.cput.domains.restaurant.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepositoryHibernate extends CrudRepository<Restaurant,String> {
}
