package ac.za.cput.service.table.impl;

import ac.za.cput.domains.table.Table;
import ac.za.cput.repositories.tablerepository.TableRepository;
import ac.za.cput.repositories.tablerepository.TableRepositoryHibernate;
import ac.za.cput.repositories.tablerepository.impl.TableRepositoryImpl;
import ac.za.cput.service.table.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("Table")
public class TableServiceImpl implements TableService {

  private static TableServiceImpl service = null;
  @Autowired
  private TableRepositoryHibernate repository;

  private TableServiceImpl() {
  }

  public static TableServiceImpl getService()
  {
      if(service == null) return new TableServiceImpl();
      return service;

  }

    @Override
    public Set<Table> getAll() {
        return new HashSet<Table>((List<Table>) repository.findAll());
    }

    @Override
    public Table create(Table type) {
        return repository.save(type);
    }

    @Override
    public Table update(Table type) {
        return this.repository.save(type);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);

    }

    @Override
    public Table read(String s) {
        return this.repository.findById(s).orElse(null);
    }
}
