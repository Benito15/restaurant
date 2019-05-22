package ac.za.cput.service.payment;

import ac.za.cput.domains.payment.Check;
import ac.za.cput.service.IService;

import java.util.Set;

public interface CheckService extends IService<Check,String> {
    Set<Check> getAll();
}
