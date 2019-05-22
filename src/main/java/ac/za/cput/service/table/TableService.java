package ac.za.cput.service.table;

import ac.za.cput.domains.table.Table;
import ac.za.cput.service.IService;

import java.util.Set;

public interface TableService extends IService <Table,String>{
    Set<Table> getAll();
}
