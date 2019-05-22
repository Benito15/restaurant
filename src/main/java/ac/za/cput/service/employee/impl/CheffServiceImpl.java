package ac.za.cput.service.employee.impl;

import ac.za.cput.domains.employee.Cheff;
import ac.za.cput.repositories.emprepositories.CheffRepository;
import ac.za.cput.repositories.emprepositories.impl.CheffRepositoryImpl;

import ac.za.cput.service.employee.CheffService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("CheffService")
public class CheffServiceImpl implements CheffService {

   private CheffServiceImpl service = null;
   private CheffRepository repository;

   private CheffServiceImpl()
   {
       this.repository = CheffRepositoryImpl.getRepository();
   }

   public CheffServiceImpl getService()
   {
       if(service == null) return new CheffServiceImpl();
       return service;
   }

    @Override
    public Set<Cheff> getAll() {
        return repository.getAll();
    }

    @Override
    public Cheff create(Cheff type) {
        return repository.create(type);
    }

    @Override
    public Cheff update(Cheff type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Cheff read(String s) {
        return this.repository.read(s);
    }
}
