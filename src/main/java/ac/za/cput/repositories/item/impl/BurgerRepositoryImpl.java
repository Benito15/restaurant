package ac.za.cput.repositories.item.impl;

import ac.za.cput.domains.purchase.item.Burger;
import ac.za.cput.repositories.item.BurgerRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("BurgerInMemory")
public class BurgerRepositoryImpl implements BurgerRepository {

    private static BurgerRepositoryImpl repository = null;
    private Set<Burger> burgers;

    private BurgerRepositoryImpl()
    {
        this.burgers = new HashSet<>();

    }

    public static BurgerRepositoryImpl getRepository()
    {
        if(repository == null) repository = new BurgerRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Burger> getAll() {

        return burgers;
    }

    @Override
    public Burger create(Burger burger) {
        this.burgers.add(burger);
        return burger;
    }

    @Override
    public Burger update(Burger burger) {
        Burger deleteBurger= read(burger.getItemID());
        if(burgers.contains(deleteBurger )){
            burgers.remove(deleteBurger );
            burgers.add(burger );
            return burger ;
        }

        return null;

    }

    @Override
    public void delete(String s) {
        Burger deleteDessert = read(s);
        burgers.remove(deleteDessert);


    }

    @Override
    public Burger read(String s) {
        return this.burgers.stream().filter(burger -> burger.getItemID().equalsIgnoreCase(s))
                .findAny().orElse(null);
    }
}
