package ac.za.cput.repositories.tablerepository.impl;

import ac.za.cput.domains.table.Table;
import ac.za.cput.repositories.tablerepository.TableRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("TableInMemory")
public class TableRepositoryImpl implements TableRepository {

    private static TableRepositoryImpl repository = null;
    private Map<String,Table> tables;

    public TableRepositoryImpl()
    {
        this.tables = new HashMap<>();
    }

    public static TableRepositoryImpl getRepository()
    {
        if (repository == null ) repository = new TableRepositoryImpl();
        return repository;
    }






    @Override
    public Set<Table> getAll() {
        Collection<Table> tables = this.tables.values();
        Set<Table> set = new HashSet<>();
        set.addAll(tables);
        return set;
    }

    @Override
    public Table create(Table table) {
        tables.put(table.getTableID(), table);
        return table;
    }

    @Override
    public Table update(Table table) {
        this.tables.replace(table.getTableID(), table);
        return this.tables.get(table.getTableID());
    }

    @Override
    public void delete(String s) {

        //if(table != null)
            this.tables.remove(s);

    }

    @Override
    public Table read(String s) {

        return this.tables.get(s);

    }




}
