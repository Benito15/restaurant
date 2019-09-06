package ac.za.cput.service.payment;

import ac.za.cput.domains.proofofpayment.payment.Credit;
import ac.za.cput.service.IService;

import java.util.Set;

public interface CreditService extends IService<Credit,String> {
    Set<Credit> getAll();
}
