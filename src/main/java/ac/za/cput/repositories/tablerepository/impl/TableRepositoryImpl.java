package ac.za.cput.repositories.tablerepository.impl;

import ac.za.cput.domains.table.Table;
import ac.za.cput.repositories.tablerepository.TableRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("TableInMemory")
public class TableRepositoryImpl implements TableRepository {

    private static TableRepositoryImpl repository = null;
    private Set<Table> tables;

    public TableRepositoryImpl()
    {
        this.tables = new HashSet<>();
    }

    public static TableRepositoryImpl getRepository()
    {
        if (repository == null ) repository = new TableRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Table> getAll() {

        return tables;
    }

    @Override
    public Table create(Table table) {
        tables.add(table);
        return table;
    }

    @Override
    public Table update(Table table) {
        Table inDB = read(table.getTableID());

        if(tables.contains(inDB)){
            tables.remove(inDB);
            tables.add(table);
            return table;
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Table toDelete = read(s);
        if (toDelete != null) {
            this.tables.remove(toDelete);
        }
    }

    @Override
    public Table read(String s) {

        return this.tables.stream().filter(table -> table.getTableID().equalsIgnoreCase(s)).findAny().orElse(null);

    }


}
