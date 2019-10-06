package ac.za.cput.repositories.emprepositories;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.domains.employee.Waiter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaiterRepositoryHibernate extends CrudRepository <Waiter, String>{
}
