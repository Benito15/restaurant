package ac.za.cput.repositories.emprepositories;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface EmployeeRepository extends IRepository<Employee,String> {
    Set<Employee> getAll();
}
