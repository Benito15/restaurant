package ac.za.cput.repositories.paymentrepositories.impl;

import ac.za.cput.domains.payment.Check;
import ac.za.cput.repositories.paymentrepositories.CheckRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("CheckInMemory")
public class CheckRepositoryImpl implements CheckRepository {

    private Set<Check> checks;
    private static CheckRepositoryImpl repository = null;

    private CheckRepositoryImpl()
    {
        this.checks = new HashSet<>();

    }

    public static CheckRepositoryImpl getRepository()
    {
        if(repository == null) repository = new CheckRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Check> getAll()
    {

        return checks;
    }

    @Override
    public Check create(Check check) {
       this.checks.add(check);
        return check;
    }

    @Override
    public Check update(Check check) {
        Check readCheck = repository.read(check.getBankID());
        if (this.checks.contains(readCheck)){
            this.checks.remove(readCheck);
            this.checks.add(check);
            return check;

        }
        return null;
    }
    @Override
    public void delete(String check) {
        Check deleteCheck = read(check);
        this.checks.remove(deleteCheck);
    }

    @Override
    public Check read(String bankID) {
        return this.checks.stream()
                .filter(thisCheck-> thisCheck.getBankID().equalsIgnoreCase(bankID))
                .findAny().orElse(null);
    }

}
