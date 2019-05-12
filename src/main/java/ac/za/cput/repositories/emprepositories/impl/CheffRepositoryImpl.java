package ac.za.cput.repositories.emprepositories.impl;

import ac.za.cput.domains.employee.Cheff;
import ac.za.cput.repositories.emprepositories.CheffRepository;

import java.util.HashSet;
import java.util.Set;

public class CheffRepositoryImpl implements CheffRepository {

    private static CheffRepositoryImpl repository = null;
    private Set<Cheff> cheffs;

    private CheffRepositoryImpl()
    {
        this.cheffs = new HashSet<>();
    }

    public static CheffRepository getRepository()
    {
        if(repository == null)
            repository = new CheffRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Cheff> getAll() {
        return this.cheffs;
    }

    @Override
    public Cheff create(Cheff cheff) {
        this.cheffs.add(cheff);
        return cheff;
    }
////////////
    @Override
    public Cheff update(Cheff cheff) {
        return null;
    }

    @Override
    public void delete(String s) {
        Cheff cheff = findID(s);
        cheffs.remove(cheff);
    }

    @Override
    public Cheff read(String s) {
        Cheff cheff = findID(s);
        if(cheff.equals(s))
            return cheff;
        return null;
    }

    public Cheff findID(String s)
    {
        return cheffs.stream().filter(o -> o.getEmpid().equals(s))
                .findFirst().orElse(null);

    }

}
