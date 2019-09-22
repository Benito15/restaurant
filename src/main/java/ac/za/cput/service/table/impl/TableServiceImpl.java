package ac.za.cput.service.table.impl;

import ac.za.cput.domains.table.Table;
import ac.za.cput.repositories.tablerepository.TableRepository;
import ac.za.cput.repositories.tablerepository.impl.TableRepositoryImpl;
import ac.za.cput.service.table.TableService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("Table")
public class TableServiceImpl implements TableService {

  private static TableServiceImpl service = null;
  private TableRepository repository;

  private TableServiceImpl()
  {
      repository = TableRepositoryImpl.getRepository();
  }

  public static TableServiceImpl getService()
  {
      if(service == null) return new TableServiceImpl();
      return service;

  }

    @Override
    public Set<Table> getAll() {
        return repository.getAll();
    }

    @Override
    public Table create(Table type) {
        return repository.create(type);
    }

    @Override
    public Table update(Table type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Table read(String s) {
        return this.repository.read(s);
    }
}
