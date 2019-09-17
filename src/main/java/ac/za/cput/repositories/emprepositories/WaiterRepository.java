package ac.za.cput.repositories.emprepositories;

import ac.za.cput.domains.employee.Waiter;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface WaiterRepository  extends IRepository<Waiter,String >{

//    Waiter create(Waiter waiter);
//    Waiter read(Waiter waiter);
//    Waiter update(Waiter waiter);
//    void delete(Waiter waiter);

    Set<Waiter> getAll();
}
