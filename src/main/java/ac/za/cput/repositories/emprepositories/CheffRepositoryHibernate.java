package ac.za.cput.repositories.emprepositories;

import ac.za.cput.domains.employee.Cheff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheffRepositoryHibernate extends CrudRepository<Cheff, String > {
}
