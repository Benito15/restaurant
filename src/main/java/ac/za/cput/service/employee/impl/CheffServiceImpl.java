package ac.za.cput.service.employee.impl;

import ac.za.cput.domains.employee.Cheff;
import ac.za.cput.repositories.emprepositories.CheffRepository;
import ac.za.cput.repositories.emprepositories.CheffRepositoryHibernate;
import ac.za.cput.repositories.emprepositories.impl.CheffRepositoryImpl;

import ac.za.cput.service.employee.CheffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("CheffService")
public class CheffServiceImpl implements CheffService {

   private CheffServiceImpl service = null;
   @Autowired
   private CheffRepositoryHibernate repository;

   private CheffServiceImpl()
   {
   }

   public CheffServiceImpl getService()
   {
       if(service == null) return new CheffServiceImpl();
       return service;
   }

    @Override
    public Set<Cheff> getAll() {
        return new HashSet<Cheff>((List<Cheff>)repository.findAll());
    }

    @Override
    public Cheff create(Cheff type) {
        return repository.save(type);
    }

    @Override
    public Cheff update(Cheff type) {
        return this.repository.save(type);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);

    }

    @Override
    public Cheff read(String s) {
        return this.repository.findById(s).orElse(null);
    }
}
