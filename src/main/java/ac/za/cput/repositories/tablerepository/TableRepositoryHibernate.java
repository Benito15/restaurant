package ac.za.cput.repositories.tablerepository;

import ac.za.cput.domains.table.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepositoryHibernate extends CrudRepository<Table,String> {
}
