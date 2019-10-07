package ac.za.cput.repositories.emprepositories;

import ac.za.cput.domains.employee.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepositoryHibernate extends CrudRepository<Manager, String > {

}
