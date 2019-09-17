package ac.za.cput.repositories.emprepositories.impl;

import ac.za.cput.domains.employee.Manager;
import ac.za.cput.repositories.emprepositories.ManagerRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("ManagerInMemory")
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
        return managers;

    }

    @Override
    public Manager create(Manager manager) {
        this.managers.add(manager);
        return manager;
    }

    @Override
    public Manager update(Manager manager) {
       Manager readManager = repository.read(manager.getEmpid());
       if (this.managers.contains(readManager)){
           this.managers.remove(readManager);
           this.managers.add(manager);
           return manager;
       }

       return null;
    }

    @Override
    public void delete(String manager) {

        Manager deleteManager = read(manager);
        this.managers.remove(deleteManager);
    }

    @Override
    public Manager read(String s)
    {
      return this.managers.stream().filter(thisManager -> thisManager.getEmpid().equalsIgnoreCase(s))
              .findAny().orElse(null);
    }


}
