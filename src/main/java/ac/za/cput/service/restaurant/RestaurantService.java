package ac.za.cput.service.restaurant;

import ac.za.cput.domains.restaurant.Restaurant;
import ac.za.cput.service.IService;

import java.util.Set;

public interface RestaurantService extends IService<Restaurant,String> {
    Set<Restaurant> getAll();

}
