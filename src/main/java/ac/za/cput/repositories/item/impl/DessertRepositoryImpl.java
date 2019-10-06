package ac.za.cput.repositories.item.impl;

import ac.za.cput.domains.purchase.item.Dessert;
import ac.za.cput.repositories.item.DessertRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("DessertInMemory")
public class DessertRepositoryImpl  implements DessertRepository {

    private static DessertRepositoryImpl repository = null;
    private Set<Dessert> desserts;

    public DessertRepositoryImpl()
    {
        this.desserts = new HashSet<>();

    }

    public static DessertRepositoryImpl getRepository()
    {
        if(repository == null) repository = new DessertRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Dessert> getAll() {

        return desserts;
    }

    @Override
    public Dessert create(Dessert dessert) {
        this.desserts.add(dessert);
        return dessert;
    }

    @Override
    public Dessert update(Dessert dessert) {
        Dessert deleteDessert = read(dessert.getItemID());
        if(desserts.contains(deleteDessert )){
            desserts.remove(deleteDessert );
            desserts.add(dessert );
            return dessert ;
        }

        return null;


    }

    @Override
    public void delete(String s) {
        Dessert deleteDessert = read(s);
        desserts.remove(deleteDessert);

    }

    @Override
    public Dessert read(String s) {
        return this.desserts.stream().filter(dessert -> dessert.getItemID().equalsIgnoreCase(s))
                .findAny().orElse(null);

    }
}
