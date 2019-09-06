package ac.za.cput.repositories.item.impl;

import ac.za.cput.domains.purchase.item.Dessert;
import ac.za.cput.repositories.item.DessertRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("DessertInMemory")
public class DessertRepositoryImpl  implements DessertRepository {

    private static DessertRepositoryImpl repository = null;
    private Map<String,Dessert> desserts;

    private DessertRepositoryImpl()
    {
        this.desserts = new HashMap<>();

    }

    public static DessertRepositoryImpl getRepository()
    {
        if(repository == null) repository = new DessertRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Dessert> getAll() {
        Collection<Dessert> desserts = this.desserts.values();
        Set<Dessert> set = new HashSet<>();
        set.addAll(desserts);
        return set;
    }

    @Override
    public Dessert create(Dessert dessert) {
        this.desserts.put(dessert.getItemID(),dessert);
        return dessert;
    }

    @Override
    public Dessert update(Dessert dessert) {
        this.desserts.replace(dessert.getItemID(),dessert);
        return this.desserts.get(dessert.getItemID());
    }

    @Override
    public void delete(String s) {
        this.desserts.remove(s);


    }

    @Override
    public Dessert read(String s) {
        return this.desserts.get(s);

    }
}
