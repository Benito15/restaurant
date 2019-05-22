package ac.za.cput.repositories.restaurantrepository;

import ac.za.cput.domains.restaurant.Restaurant;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface RestaurantRepository extends IRepository<Restaurant, String> {

    Set<Restaurant> getAll();

}
