package ac.za.cput.service.restaurant.impl;

import ac.za.cput.domains.restaurant.Restaurant;
import ac.za.cput.repositories.restaurantrepository.RestaurantRepository;
import ac.za.cput.repositories.restaurantrepository.impl.RestaurantRepositoryImpl;
import ac.za.cput.service.restaurant.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("RestaurantService")
public class RestaurantServiceImpl implements RestaurantService{

    private RestaurantServiceImpl service = null;
    private RestaurantRepository repository;

    private  RestaurantServiceImpl()
    {
        repository = RestaurantRepositoryImpl.getRepository();
    }

    public  RestaurantServiceImpl getService()
    {
        if(service == null)return  new RestaurantServiceImpl();
        return  service;
    }

    @Override
    public Set<Restaurant> getAll() {
        return repository.getAll();
    }

    @Override
    public Restaurant create(Restaurant type) {
        return repository.create(type);
    }

    @Override
    public Restaurant update(Restaurant type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Restaurant read(String s) {
        return this.repository.read(s);
    }
}
