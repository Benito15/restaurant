package ac.za.cput.servicetest.restaurant;

import ac.za.cput.domains.restaurant.Restaurant;
import ac.za.cput.factory.restaurantfactory.RestaurantFactory;
import ac.za.cput.service.restaurant.impl.RestaurantServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantServiceImplTest {

    @Autowired
  private RestaurantServiceImpl service;


    @Test
    public void create() {
        Restaurant res = RestaurantFactory.getRestaurant("BONG",35);
        this.service.create(res);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);


    }

    @Test
    public void update() {
        int updatetotalEmp = 40;
        Restaurant res = RestaurantFactory.getRestaurant("BONG",35);
        this.service.create(res);
        Restaurant updatedRes = RestaurantFactory.getRestaurant(res.getName(), updatetotalEmp);
        this.service.update(updatedRes);
        Assert.assertTrue(updatedRes.getTotEmployees()> res.getTotEmployees());


    }

    @Test
    public void delete() {
        Restaurant res = RestaurantFactory.getRestaurant("BONG",35);
        Restaurant res2 = RestaurantFactory.getRestaurant("ZENGNG",40);
        this.service.create(res);
        this.service.create(res2);
        this.service.delete(res2.getResID());
        Assert.assertTrue(this.service.getAll().size()>=1);

    }

    @Test
    public void read() {
        Restaurant res = RestaurantFactory.getRestaurant("BONG",35);
        Restaurant res2 = RestaurantFactory.getRestaurant("ZENGNG",40);
        this.service.create(res);
        this.service.create(res2);
        Restaurant readRes = this.service.read(res.getResID());
        Assert.assertNotEquals(readRes.getResID(), res2.getResID());

    }
}