package ac.za.cput.repositories.emprepositories.impl;

import ac.za.cput.domains.employee.Waiter;
import ac.za.cput.repositories.emprepositories.WaiterRepository;

import java.util.HashSet;
import java.util.Set;

public class WaiterRepositoryImpl implements WaiterRepository {

    private static WaiterRepositoryImpl repository = null;
    private Set<Waiter> waiters;


    private WaiterRepositoryImpl()
    {
        this.waiters = new HashSet();

    }

    @Override
    public Set<Waiter> getAll() {
        return this.waiters;
    }

    @Override
    public Waiter create(Waiter waiter) {
        this.waiters.add(waiter);
        return waiter;
    }

    @Override
    public Waiter update(Waiter waiter) {
        return null;
    }

    @Override
    public void delete(String s) {
        Waiter waiter = findID(s);
        this.waiters.remove(waiter);
    }

    @Override
    public Waiter read(String s) {
        Waiter waiter = findID(s);
        if(waiter.equals(s))
            return waiter;
        else return null;
    }

    public Waiter findID(String s)
    {
        return waiters.stream().filter(o -> o.getEmpid().equals(s))
                .findFirst().orElse(null);

    }
}
