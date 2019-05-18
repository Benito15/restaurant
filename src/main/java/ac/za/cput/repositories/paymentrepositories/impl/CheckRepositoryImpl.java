package ac.za.cput.repositories.paymentrepositories.impl;

import ac.za.cput.domains.payment.Check;
import ac.za.cput.repositories.paymentrepositories.CheckRepository;

import java.util.*;

public class CheckRepositoryImpl implements CheckRepository {

    private static CheckRepositoryImpl repository = null;
    private Map<String,Check> checks;

    private CheckRepositoryImpl()
    {
        this.checks = new HashMap<>();

    }

    @Override
    public Set<Check> getAll()
    {
        Collection<Check> checks= this.checks.values();
        Set<Check> set = new HashSet<>();
        set.addAll(checks);
        return set;
    }

    @Override
    public Check create(Check check) {
        this.checks.put(check.getBankID(), check);
        return check;
    }

    @Override
    public Check update(Check check) {
        this.checks.replace(check.getBankID(), check);
        return this.checks.get(check.getBankID());
    }

    @Override
    public void delete(String s) {

        this.checks.remove(s);
    }

    @Override
    public Check read(String s) {
        return this.checks.get(s);
    }

//    public Check findID(String s)
//    {
//        return checks.stream().filter(o-> o.getBankID().equals(s))
//                .findFirst().orElse(null);
//    }


}
