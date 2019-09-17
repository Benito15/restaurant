package ac.za.cput.repositories.paymentrepositories;

import ac.za.cput.domains.proofofpayment.payment.Check;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface CheckRepository extends IRepository <Check, String >{

//    Check create(Check check);
//    Check read(Check check);
//    Check update(Check check);
//    void delete(Check check);
    Set<Check> getAll();

}
