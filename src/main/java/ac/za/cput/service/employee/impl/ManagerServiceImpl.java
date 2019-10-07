package ac.za.cput.service.employee.impl;

import ac.za.cput.domains.employee.Manager;
import ac.za.cput.repositories.emprepositories.ManagerRepository;
import ac.za.cput.repositories.emprepositories.ManagerRepositoryHibernate;
import ac.za.cput.repositories.emprepositories.impl.ManagerRepositoryImpl;
import ac.za.cput.service.employee.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("ManagerService")
public class ManagerServiceImpl implements ManagerService {
  private ManagerServiceImpl service = null;
  @Autowired
  private ManagerRepositoryHibernate repository;

  private ManagerServiceImpl()
  {

  }

    public ManagerServiceImpl getService()
  {
      if(service == null)return  new ManagerServiceImpl();
      return  service;
  }


    @Override
    public Set<Manager> getAll() {
        return new HashSet<Manager>((List<Manager>)repository.findAll());
    }

    @Override
    public Manager create(Manager type) {
        return repository.save(type);
    }

    @Override
    public Manager update(Manager type) {
        return this.repository.save(type);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);

    }

    @Override
    public Manager read(String s) {
        return this.repository.findById(s).orElse(null);
    }
}
