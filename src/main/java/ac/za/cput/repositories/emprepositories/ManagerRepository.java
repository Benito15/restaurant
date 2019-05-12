package ac.za.cput.repositories.emprepositories;

import ac.za.cput.domains.employee.Manager;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface ManagerRepository extends IRepository<Manager,String> {
    Set<Manager> getAll();
}
