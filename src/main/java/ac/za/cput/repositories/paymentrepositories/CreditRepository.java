package ac.za.cput.repositories.paymentrepositories;

import ac.za.cput.domains.proofofpayment.payment.Credit;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface CreditRepository extends IRepository<Credit, String>{
//    Credit create(Credit credit);
//    Credit read(Credit credit);
//    Credit update(Credit credit);
//    void delete(Credit credit);
    Set<Credit> getAll();
}
