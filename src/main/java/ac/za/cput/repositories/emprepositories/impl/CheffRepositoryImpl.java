package ac.za.cput.repositories.emprepositories.impl;

import ac.za.cput.domains.employee.Cheff;
import ac.za.cput.repositories.emprepositories.CheffRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("CheffInMemory")
public class CheffRepositoryImpl implements CheffRepository {

    private static CheffRepositoryImpl repository = null;
    private Set<Cheff> cheffs;

    public CheffRepositoryImpl()
    {
        this.cheffs = new HashSet<>();
    }

    public static CheffRepositoryImpl getRepository()
    {
        if(repository == null)
            repository = new CheffRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Cheff> getAll() {
       return cheffs;
    }

    @Override
    public Cheff create(Cheff cheff) {
        this.cheffs.add(cheff);
        return cheff;
    }
////////////
    @Override
    public Cheff update(Cheff cheff) {
       Cheff readcheff = repository.read(cheff.getEmpid());
       if (this.cheffs.contains(readcheff)){
           this.cheffs.remove(readcheff);
           this.cheffs.add(cheff);
           return cheff;
       }

       return null;

    }

    @Override
    public void delete(String s) {

        Cheff deleteCheff = read(s);
        this.cheffs.remove(deleteCheff);

    }

    @Override
    public Cheff read(String s) {
        return this.cheffs.stream().filter(
                thisCheff -> thisCheff.getEmpid().equalsIgnoreCase(s)).
                findAny().orElse(null);
    }



}
