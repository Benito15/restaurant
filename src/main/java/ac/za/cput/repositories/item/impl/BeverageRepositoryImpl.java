package ac.za.cput.repositories.item.impl;

import ac.za.cput.domains.item.Beverage;
import ac.za.cput.repositories.item.BeverageRepository;

import java.util.*;

public class BeverageRepositoryImpl implements BeverageRepository {

    private static BeverageRepositoryImpl repository = null;
    private Map<String,Beverage> beverages;

    private BeverageRepositoryImpl()
    {
        this.beverages = new HashMap<>();

    }

    public static BeverageRepositoryImpl getRepository()
    {
        if(repository == null) repository = new BeverageRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Beverage> getAll() {

        Collection<Beverage> beverages= this.beverages.values();
        Set<Beverage> set = new HashSet<>();
        set.addAll(beverages);
        return set;
    }

    @Override
    public Beverage create(Beverage beverage) {
        this.beverages.put(beverage.getItemID(),beverage);
        return beverage;    }

    @Override
    public Beverage update(Beverage beverage) {
        this.beverages.replace(beverage.getItemID(),beverage);
        return this.beverages.get(beverage.getItemID());
    }

    @Override
    public void delete(String s) {
        this.beverages.remove(s);

    }

    @Override
    public Beverage read(String s) {
        return this.beverages.get(s);

    }
}
