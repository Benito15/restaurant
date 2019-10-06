package ac.za.cput.repositories.item.impl;

import ac.za.cput.domains.purchase.item.Beverage;
import ac.za.cput.repositories.item.BeverageRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("BeverageInMemory")
public class BeverageRepositoryImpl implements BeverageRepository {

    private static BeverageRepositoryImpl repository = null;
    private Set<Beverage> beverages;

    public BeverageRepositoryImpl()
    {
            this.beverages = new HashSet<>();

    }

    public static BeverageRepositoryImpl getRepository()
    {
        if(repository == null) repository = new BeverageRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Beverage> getAll() {
        return beverages;
    }

    @Override
    public Beverage create(Beverage beverage) {
        this.beverages.add(beverage);
        return beverage;
    }

    @Override
    public Beverage update(Beverage beverage) {
        Beverage readBeverage= repository.read(beverage.getItemID());
        if (this.beverages.contains(readBeverage)) {
            this.beverages.remove(readBeverage);
            this.beverages.add(beverage);
            return beverage;

        }
        return null;

    }

    @Override
    public void delete(String s) {
        this.beverages.remove(s);

    }

    @Override
    public Beverage read(String s) {
        return this.beverages.stream()
                .filter(thisGuest -> thisGuest.getItemID().equalsIgnoreCase(s))
                .findAny().orElse(null);

    }
}
