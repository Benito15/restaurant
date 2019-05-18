package ac.za.cput.repositories.item.impl;

import ac.za.cput.domains.item.Burger;
import ac.za.cput.repositories.item.BurgerRepository;

import java.util.*;

public class BurgerRepositoryImpl implements BurgerRepository {

    private static BurgerRepositoryImpl repository = null;
    private Map<String,Burger> burgers;

    private BurgerRepositoryImpl()
    {
        this.burgers = new HashMap<>();

    }

    public static BurgerRepositoryImpl getRepository()
    {
        if(repository == null) repository = new BurgerRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Burger> getAll() {
        Collection<Burger> burgers = this.burgers.values();
        Set<Burger> set = new HashSet<>();
        set.addAll(burgers);
        return set;
    }

    @Override
    public Burger create(Burger burger) {
        this.burgers.put(burger.getItemID(),burger);
        return burger;
    }

    @Override
    public Burger update(Burger burger) {
        this.burgers.replace(burger.getItemID(),burger);
        return this.burgers.get(burger.getItemID());
    }

    @Override
    public void delete(String s) {

        this.burgers.remove(s);


    }

    @Override
    public Burger read(String s) {
        return this.burgers.get(s);
    }
}
