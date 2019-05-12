package ac.za.cput.repositories.emprepositories;

import ac.za.cput.domains.employee.Waiter;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface WaiterRepository extends IRepository<Waiter,String> {

    Set<Waiter> getAll();

}
