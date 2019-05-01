package repositorytest.restaurantrepository.impl;

import ac.za.cput.domains.restaurant.Restaurant;
import repositorytest.restaurantrepository.RestaurantRepository;

import java.util.HashSet;
import java.util.Set;

public class RestaurantRepositoryImpl implements RestaurantRepository {

    private static RestaurantRepositoryImpl repository = null;
    private Set<Restaurant> restaurants;

    private RestaurantRepositoryImpl()
    {
        this.restaurants = new HashSet<>();
    }

    public static RestaurantRepository getRepository()
    {
        if(repository == null) repository = new RestaurantRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Restaurant> getAll() {
        return this.restaurants;
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        this.restaurants.add(restaurant);
        return restaurant;
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        return null;
    }

    @Override
    public void delete(String s) {
        Restaurant restaurant = findID(s);
        restaurants.remove(restaurant);

    }

    @Override
    public Restaurant read(String s) {
        Restaurant restaurant = findID(s);
        if (restaurants.equals(s))
            return restaurant;
        return null;
    }

    public Restaurant findID(String s)
    {
        return restaurants.stream().filter(p -> p.getResID().equals(s))
                .findFirst().orElse(null);


    }
}
