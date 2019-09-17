package ac.za.cput.repositories.paymentrepositories.impl;

import ac.za.cput.domains.proofofpayment.payment.Credit;
import ac.za.cput.repositories.paymentrepositories.CreditRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("CreditInMemory")
public class CreditRepositoryImpl implements CreditRepository {

    private static CreditRepositoryImpl repository = null;
    private Set<Credit> credits;

    private CreditRepositoryImpl()
    {
        credits = new HashSet();
    }

    public static CreditRepository getRepository()
    {
        if(repository == null) repository = new CreditRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Credit> getAll() {

        return credits;
    }

    @Override
    public Credit create(Credit credit) {
        this.credits.add(credit);
        return credit;
    }

    @Override
    public Credit update(Credit credit) {
        Credit readCredit = repository.read(credit.getCardID());
        if (this.credits.contains(readCredit)){
            this.credits.remove(readCredit);
            this.credits.add(credit);
            return credit;

        }
        return null;
    }

    @Override
    public void delete(String credit) {
        Credit deleteCredit = read(credit);
        this.credits.remove(deleteCredit);

    }

    @Override
    public Credit read(String credit) {
    return this.credits.stream()
        .filter(thisCredits -> thisCredits.getCardID().equalsIgnoreCase(credit))
        .findAny().orElse(null);


    }

}
