package ac.za.cput.repositories.restaurantrepository.impl;

import ac.za.cput.domains.restaurant.Restaurant;
import repositorytest.restaurantrepository.RestaurantRepository;

import java.util.*;

public class RestaurantRepositoryImpl implements RestaurantRepository {

    private static RestaurantRepositoryImpl repository = null;
    private Map<String,Restaurant> restaurants;

    private RestaurantRepositoryImpl()
    {
        this.restaurants = new HashMap<>();
    }

    public static RestaurantRepositoryImpl getRepository()
    {
        if(repository == null) repository = new RestaurantRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Restaurant> getAll() {
        Collection<Restaurant> restaurants = this.restaurants.values();
        Set<Restaurant> set = new HashSet<>();
        set.addAll(restaurants);
        return set;
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        this.restaurants.put(restaurant.getResID(), restaurant);
        return restaurant;
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        this.restaurants.replace(restaurant.getResID(), restaurant);
        return this.restaurants.get(restaurant.getResID());
    }

    @Override
    public void delete(String s) {

        restaurants.remove(s);

    }

    @Override
    public Restaurant read(String s) {
        return this.restaurants.get(s);

    }

//    public Restaurant findID(String s)
//    {
//        return restaurants.stream().filter(restaurant-> restaurant.getResID().equals(s))
//                .findAny().orElse(null);
//
//
//    }
}
