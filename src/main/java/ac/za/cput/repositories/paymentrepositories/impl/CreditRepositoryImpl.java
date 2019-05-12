package ac.za.cput.repositories.paymentrepositories.impl;

import ac.za.cput.domains.payment.Credit;
import ac.za.cput.repositories.billrepository.BillRepository;
import ac.za.cput.repositories.paymentrepositories.CreditRepository;

import java.util.HashSet;
import java.util.Set;

public class CreditRepositoryImpl implements CreditRepository {

    private static CreditRepositoryImpl repository = null;
    private Set<Credit>credits;

    private CreditRepositoryImpl()
    {
        credits = new HashSet<>();
    }

    public static CreditRepository getRepository()
    {
        if(repository == null) repository = new CreditRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Credit> getAll() {
        return this.credits;
    }

    @Override
    public Credit create(Credit credit) {
        this.credits.add(credit);
        return credit;
    }

    @Override
    public Credit update(Credit credit) {
        return null;
    }

    @Override
    public void delete(String s) {
        Credit credit = findID(s);
        this.credits.remove(s);

    }

    @Override
    public Credit read(String s) {
        Credit credit = findID(s);
        if(credit.equals(s))
            return credit;
        else return null;
    }


    public Credit findID(String s)
    {
        return credits.stream().filter(credit -> credit.getCardID().equals(s))
                .findAny().orElse(null);

    }
}
