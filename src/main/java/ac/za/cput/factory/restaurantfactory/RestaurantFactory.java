package ac.za.cput.factory.restaurantfactory;

import ac.za.cput.domains.restaurant.Restaurant;
import ac.za.cput.util.Misc;

public class RestaurantFactory {


    public static Restaurant getRestaurant(String name, int totEmployees)
    {
        return new Restaurant.Builder().name(name)
                .totEmployees(totEmployees)
                .resID(Misc.generateId())
                .build();


    }

}
