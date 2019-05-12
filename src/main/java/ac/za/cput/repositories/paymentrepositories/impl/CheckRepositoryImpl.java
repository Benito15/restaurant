package ac.za.cput.repositories.paymentrepositories.impl;

import ac.za.cput.domains.payment.Check;
import ac.za.cput.repositories.paymentrepositories.CheckRepository;

import java.util.HashSet;
import java.util.Set;

public class CheckRepositoryImpl implements CheckRepository {

    private static CheckRepositoryImpl repository = null;
    private Set<Check> checks;

    private CheckRepositoryImpl()
    {
        this.checks = new HashSet<>();

    }

    @Override
    public Set<Check> getAll() {
        return this.checks;
    }

    @Override
    public Check create(Check check) {
        this.checks.add(check);
        return check;
    }

    @Override
    public Check update(Check check) {
        return null;
    }

    @Override
    public void delete(String s) {
        Check check = findID(s);
        this.checks.remove(check);
    }

    @Override
    public Check read(String s) {
        Check check = findID(s);
        if(check.equals(s))
            return check;
        else return null;
    }

    public Check findID(String s)
    {
        return checks.stream().filter(o-> o.getBankID().equals(s))
                .findFirst().orElse(null);
    }


}
