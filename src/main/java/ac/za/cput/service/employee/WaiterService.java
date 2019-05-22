package ac.za.cput.service.employee;

import ac.za.cput.domains.employee.Waiter;
import ac.za.cput.service.IService;

import java.util.Set;

public interface WaiterService extends IService<Waiter,String> {

    Set<Waiter> getAll();
}
