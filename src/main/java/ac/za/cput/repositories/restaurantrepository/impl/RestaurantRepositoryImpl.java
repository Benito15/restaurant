package ac.za.cput.repositories.restaurantrepository.impl;

import ac.za.cput.domains.restaurant.Restaurant;
import ac.za.cput.repositories.restaurantrepository.RestaurantRepository;
import org.springframework.stereotype.Repository;


import java.util.*;

@Repository("RestaurantInMemory")
public class RestaurantRepositoryImpl implements RestaurantRepository {

    private static RestaurantRepositoryImpl repository = null;
    private Set<Restaurant> restaurants;

    private RestaurantRepositoryImpl()
    {
        this.restaurants = new HashSet<>();
    }

    public static RestaurantRepositoryImpl getRepository()
    {
        if(repository == null) repository = new RestaurantRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Restaurant> getAll() {

        return restaurants;
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        this.restaurants.add(restaurant);
        return restaurant;
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        Restaurant deleterestaurant= read(restaurant.getResID());
        if(restaurants.contains(deleterestaurant)){
            restaurants.remove(deleterestaurant);
            restaurants.add(restaurant);
            return restaurant;
        }

        return null;
    }

    @Override
    public void delete(String s) {

        Restaurant restaurant = read(s);
        this.restaurants.remove(restaurant);

    }

    @Override
    public Restaurant read(String s) {
        return this.restaurants.stream().
                filter(res -> res.getResID().equalsIgnoreCase(s))
                .findAny().orElse(null);

    }


}
