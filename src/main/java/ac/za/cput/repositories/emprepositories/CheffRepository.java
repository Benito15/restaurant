package ac.za.cput.repositories.emprepositories;

import ac.za.cput.domains.employee.Cheff;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface CheffRepository extends IRepository<Cheff,String> {

    Set<Cheff> getAll();

}
