package ac.za.cput.repositories.paymentrepositories.impl;

import ac.za.cput.domains.proofofpayment.payment.Credit;
import ac.za.cput.repositories.paymentrepositories.CreditRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("CreditInMemory")
public class CreditRepositoryImpl implements CreditRepository {

    private static CreditRepositoryImpl repository = null;
    private Map<String, Credit> credits;

    private CreditRepositoryImpl()
    {
        credits = new HashMap();
    }

    public static CreditRepository getRepository()
    {
        if(repository == null) repository = new CreditRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Credit> getAll() {
        Collection<Credit> credits = this.credits.values();
        Set<Credit> set = new HashSet<>();
        set.addAll(credits);
        return set;
    }

    @Override
    public Credit create(Credit credit) {
        this.credits.put(credit.getCardID(), credit);
        return credit;
    }

    @Override
    public Credit update(Credit credit) {
        this.credits.replace(credit.getCardID(), credit);
        return this.credits.get(credit.getCardID());
    }

    @Override
    public void delete(String s) {

        this.credits.remove(s);

    }

    @Override
    public Credit read(String s) {
        return this.credits.get(s);

    }


//    public Credit findID(String s)
//    {
//        return credits.stream().filter(credit -> credit.getCardID().equals(s))
//                .findAny().orElse(null);
//
//    }
}
