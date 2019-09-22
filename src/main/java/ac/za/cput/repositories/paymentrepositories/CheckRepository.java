package ac.za.cput.repositories.paymentrepositories;

import ac.za.cput.domains.payment.Check;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface CheckRepository extends IRepository <Check, String >{


//    Check create(Check feedback);
//    Check read( feedback);
//    Check update(Check feedback);
//    void delete(Check feedback);
    Set<Check> getAll();

}
