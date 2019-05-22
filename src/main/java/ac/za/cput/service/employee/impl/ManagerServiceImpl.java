package ac.za.cput.service.employee.impl;

import ac.za.cput.domains.employee.Manager;
import ac.za.cput.repositories.emprepositories.ManagerRepository;
import ac.za.cput.repositories.emprepositories.impl.ManagerRepositoryImpl;
import ac.za.cput.service.employee.ManagerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ManagerService")
public class ManagerServiceImpl implements ManagerService {
  private ManagerServiceImpl service = null;
  private ManagerRepository repository;

  private ManagerServiceImpl()
  {
      repository = ManagerRepositoryImpl.getRepository();
  }

  private ManagerServiceImpl getService()
  {
      if(service == null)return  new ManagerServiceImpl();
      return  service;
  }


    @Override
    public Set<Manager> getAll() {
        return repository.getAll();
    }

    @Override
    public Manager create(Manager type) {
        return repository.create(type);
    }

    @Override
    public Manager update(Manager type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Manager read(String s) {
        return this.repository.read(s);
    }
}
