package ac.za.cput.repositories.tablerepository;

import ac.za.cput.domains.table.Table;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface TableRepository extends IRepository<Table, String> {

    Set<Table> getAll();



}
