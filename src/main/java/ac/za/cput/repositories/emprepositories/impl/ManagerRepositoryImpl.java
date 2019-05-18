package ac.za.cput.repositories.emprepositories.impl;

import ac.za.cput.domains.employee.Manager;
import ac.za.cput.repositories.emprepositories.ManagerRepository;

import java.util.*;

public class ManagerRepositoryImpl implements ManagerRepository {

   private static ManagerRepositoryImpl repository = null;
   private Map<String,Manager> managers;

   private ManagerRepositoryImpl()
   {
       this.managers = new HashMap<>();

   }

   public static  ManagerRepository getRepository()
   {
       if(repository == null) repository = new ManagerRepositoryImpl();
       return repository;

   }

    @Override
    public Set<Manager> getAll() {
        Collection<Manager> managers = this.managers.values();
        Set<Manager> set = new HashSet<>();
        set.addAll(managers);
        return set;

    }

    @Override
    public Manager create(Manager manager) {
        this.managers.put(manager.getEmpid(), manager);
        return manager;
    }

    @Override
    public Manager update(Manager manager) {
        this.managers.replace(manager.getEmpid(), manager);
        return this.managers.get(manager.getEmpid());
    }

    @Override
    public void delete(String s) {

        this.managers.remove(s);

    }

    @Override
    public Manager read(String s) {
      return this.managers.get(s);
    }


}
