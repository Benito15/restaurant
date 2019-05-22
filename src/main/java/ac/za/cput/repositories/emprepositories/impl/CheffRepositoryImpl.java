package ac.za.cput.repositories.emprepositories.impl;

import ac.za.cput.domains.employee.Cheff;
import ac.za.cput.repositories.emprepositories.CheffRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("CheffInMemory")
public class CheffRepositoryImpl implements CheffRepository {

    private static CheffRepositoryImpl repository = null;
    private Map<String, Cheff> cheffs;

    private CheffRepositoryImpl()
    {
        this.cheffs = new HashMap<>();
    }

    public static CheffRepositoryImpl getRepository()
    {
        if(repository == null)
            repository = new CheffRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Cheff> getAll() {
        Collection<Cheff> cheffs = this.cheffs.values();
        Set<Cheff> set = new HashSet<>();
        set.addAll(cheffs);
        return set;
    }

    @Override
    public Cheff create(Cheff cheff) {
        this.cheffs.put(cheff.getEmpid(),cheff);
        return cheff;
    }
////////////
    @Override
    public Cheff update(Cheff cheff) {
        this.cheffs.replace(cheff.getEmpid(), cheff);
        return this.cheffs.get(cheff.getEmpid());

    }

    @Override
    public void delete(String s) {
        this.cheffs.remove(s);

    }

    @Override
    public Cheff read(String s) {
        return this.cheffs.get(s);
    }

//    public Cheff findID(String s)
//    {
//        return cheffs.stream().filter(o -> o.getEmpid().equals(s))
//                .findFirst().orElse(null);
//
//    }

}
