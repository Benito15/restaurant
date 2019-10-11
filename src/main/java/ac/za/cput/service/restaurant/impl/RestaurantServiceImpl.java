package ac.za.cput.service.restaurant.impl;

import ac.za.cput.domains.restaurant.Restaurant;
import ac.za.cput.repositories.restaurantrepository.RestaurantRepository;
import ac.za.cput.repositories.restaurantrepository.RestaurantRepositoryHibernate;
import ac.za.cput.repositories.restaurantrepository.impl.RestaurantRepositoryImpl;
import ac.za.cput.service.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("RestaurantService")
public class RestaurantServiceImpl implements RestaurantService{

    private RestaurantServiceImpl service = null;
    @Autowired
    private RestaurantRepositoryHibernate repository;

    private  RestaurantServiceImpl()
    {

    }

    public  RestaurantServiceImpl getService()
    {
        if(service == null)return  new RestaurantServiceImpl();
        return  service;
    }

    @Override
    public Set<Restaurant> getAll() {
        return new HashSet<Restaurant>((List<Restaurant>)repository.findAll());
    }

    @Override
    public Restaurant create(Restaurant type) {
        return repository.save(type);
    }

    @Override
    public Restaurant update(Restaurant type) {
        return this.repository.save(type);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);

    }

    @Override
    public Restaurant read(String s) {
        return this.repository.findById(s).orElse(null);
    }
}
