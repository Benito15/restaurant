package ac.za.cput.repositorytest.restauranttest;

import ac.za.cput.domains.restaurant.Restaurant;
import ac.za.cput.factory.restaurantfactory.RestaurantFactory;
import ac.za.cput.repositories.restaurantrepository.RestaurantRepository;
import ac.za.cput.repositories.restaurantrepository.impl.RestaurantRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantRepositoryImplTest {

    @Autowired
    private RestaurantRepositoryImpl repository = null;
    private Set<Restaurant> restaurants;

    @Before
    public void setUp() throws Exception {
        this.repository = RestaurantRepositoryImpl.getRepository();
    }

    @Test
    public void getAll() {
        Set<Restaurant> getAllRestaurant = this.repository.getAll();
        System.out.println("Get all Restaurant: " + this.repository.getAll().size());
        Assert.assertNotNull("Restaurant Repository: ", repository.getAll());
    }

    @Test
    public void create() {
        Restaurant restaurant = RestaurantFactory.getRestaurant("Bennies Burger_Palace", 30);
        this.repository.create(restaurant);
        int size = this.repository.getAll().size();
        System.out.println(size);
        Assert.assertTrue("This repository is not 0", this.repository.getAll().size() >0);
    }

    @Test
    public void update() {
        String newName = "Beeee";
        Restaurant restaurant = RestaurantFactory.getRestaurant("Bennies Burger_Palace", 30);

        repository.create(restaurant);
        System.out.println("Restaurant 1: \n" + this.repository.getAll());
        System.out.println("----------------------------------------");
        restaurant.setName(newName);

        this.repository.update(restaurant);
        System.out.println("After name update---------------------------");
        System.out.println(this.repository.getAll());
        Assert.assertEquals(newName, restaurant.getName());

    }

    @Test
    public void delete() {
        System.out.println(this.repository.getAll().size());
        System.out.println("--------------------------------");
        Restaurant restaurant = RestaurantFactory.getRestaurant("Bennies Burger_Palace", 30);
        Restaurant restaurant2 = RestaurantFactory.getRestaurant("Lorenzo Gatsby", 12);
        this.repository.create(restaurant);
        this.repository.create(restaurant2);
        System.out.println(this.repository.getAll().size());

        this.repository.delete(restaurant.getResID());
        System.out.println("After Delete");
        System.out.println(this.repository.getAll().size());
        Assert.assertNotNull(this.repository);

    }

    @Test
    public void read() {
        Restaurant restaurant = RestaurantFactory.getRestaurant("Bennies Burger_Palace", 30);
        Restaurant restaurant2 = RestaurantFactory.getRestaurant("Lorenzo Wrap", 20);
        this.repository.create(restaurant);
        this.repository.create(restaurant2);
        System.out.println("Size after creating Objects->");
        System.out.println(this.repository.getAll().size());
        System.out.println("-------------------------------");
        Restaurant readRes = this.repository.read(restaurant.getResID());
        System.out.println("Reading Object into new Object of type Restaurant");
        System.out.println(readRes.getResID());
        System.out.println("-----------------------------------");

        Assert.assertNotEquals(restaurant2.getResID(), readRes.getResID());
    }



}