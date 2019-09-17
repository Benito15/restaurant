package ac.za.cput.repositories.emprepositories.impl;

import ac.za.cput.domains.employee.Waiter;
import ac.za.cput.repositories.emprepositories.WaiterRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("WaiterInMemory")
public class WaiterRepositoryImpl implements WaiterRepository {

    private static WaiterRepositoryImpl repository = null;
    private Set<Waiter> waiters;


    private WaiterRepositoryImpl()
    {
        this.waiters = new HashSet<>();

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
        return waiters;
    }

    @Override
    public Waiter create(Waiter waiter) {
        this.waiters.add(waiter);
        return waiter;

    }

    @Override
    public Waiter update(Waiter waiter) {
        Waiter readWaiter = repository.read(waiter.getEmpid());
        if (this.waiters.contains(readWaiter)){
            this.waiters.remove(readWaiter);
            this.waiters.add(waiter);
            return waiter;
        }
        return null;
    }

    @Override
    public void delete(String  waiter) {
        Waiter deleteWaiter = read(waiter);
        this.waiters.remove(deleteWaiter);
    }

    @Override
    public Waiter read(String s) {
        return this.waiters.stream()
                .filter(thisWaiter -> thisWaiter.getEmpid().equalsIgnoreCase(s)).findAny().orElse(null);

    }
}
