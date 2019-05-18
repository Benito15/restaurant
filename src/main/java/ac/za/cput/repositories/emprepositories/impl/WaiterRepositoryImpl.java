package ac.za.cput.repositories.emprepositories.impl;

import ac.za.cput.domains.employee.Waiter;
import ac.za.cput.repositories.emprepositories.WaiterRepository;

import java.util.*;

public class WaiterRepositoryImpl implements WaiterRepository {

    private static WaiterRepositoryImpl repository = null;
    private Map<String,Waiter> waiters;


    private WaiterRepositoryImpl()
    {
        this.waiters = new HashMap<>();

    }

    public static WaiterRepositoryImpl getRepository()
    {
        if(repository == null)
            repository = new WaiterRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Waiter> getAll()
    {
        Collection<Waiter> waiters= this.waiters.values();
        Set<Waiter> set = new HashSet<>();
        set.addAll(waiters);
        return set;
    }

    @Override
    public Waiter create(Waiter waiter) {
        this.waiters.put(waiter.getEmpid(),waiter);
        return waiter;
    }

    @Override
    public Waiter update(Waiter waiter) {
        this.waiters.replace(waiter.getEmpid(), waiter);
        return this.waiters.get(waiter.getEmpid());
    }

    @Override
    public void delete(String s) {

        this.waiters.remove(s);
    }

    @Override
    public Waiter read(String s) {

        return this.waiters.get(s);


//        Waiter waiter = findID(s);
//        if(waiter.equals(s))
//            return waiter;
//        else return null;
    }

//    public Waiter findID(String s)
//    {
//        return waiters.stream().filter(o -> o.getEmpid().equals(s))
//                .findFirst().orElse(null);
//
//    }
}
