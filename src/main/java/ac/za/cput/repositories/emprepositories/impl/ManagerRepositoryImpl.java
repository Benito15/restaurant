package ac.za.cput.repositories.emprepositories.impl;

import ac.za.cput.domains.employee.Manager;
import ac.za.cput.repositories.emprepositories.ManagerRepository;

import java.util.HashSet;
import java.util.Set;

public class ManagerRepositoryImpl implements ManagerRepository {

   private static ManagerRepositoryImpl repository = null;
   private Set<Manager> managers;

   private ManagerRepositoryImpl()
   {
       this.managers = new HashSet<>();

   }

   public static  ManagerRepository getRepository()
   {
       if(repository == null) repository = new ManagerRepositoryImpl();
       return repository;

   }

    @Override
    public Set<Manager> getAll() {
        return this.managers;
    }

    @Override
    public Manager create(Manager manager) {
        this.managers.add(manager);
        return manager;
    }

    @Override
    public Manager update(Manager manager) {
        return null;
    }

    @Override
    public void delete(String s) {
        Manager manager = findID(s);
        this.managers.remove(manager);

    }

    @Override
    public Manager read(String s) {
        Manager manager = findID(s);
        if(manager.equals(s))
            return manager;
        else return null;
    }

    public Manager findID(String s)
    {
        return managers.stream().filter(o -> o.getEmpid().equals(s))
                .findFirst().orElse(null);
    }
}
