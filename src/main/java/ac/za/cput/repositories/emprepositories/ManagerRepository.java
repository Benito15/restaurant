package ac.za.cput.repositories.emprepositories;

import ac.za.cput.domains.employee.Manager;
import ac.za.cput.repositories.IRepository;


import java.util.Set;

public interface ManagerRepository extends IRepository<Manager,String> {
//    Manager create(Manager manager);
//    Manager read(Manager manager);
//    Manager update(Manager manager);
//    void delete(Manager manager);
    Set<Manager> getAll();


}
