package ac.za.cput.repositories.tablerepository.impl;

import ac.za.cput.domains.table.Table;
import ac.za.cput.repositories.tablerepository.TableRepository;

import java.util.HashSet;
import java.util.Set;

public class TableRepositoryImpl implements TableRepository {

    private static TableRepositoryImpl repository = null;
    private Set<Table> tables;

    private TableRepositoryImpl()
    {this.tables = new HashSet<>();
    }

    private static TableRepository getRepository()
    {
        if (repository == null ) repository = new TableRepositoryImpl();
        return repository;
    }





    @Override
    public Set<Table> getAll() {
        return this.tables;
    }

    @Override
    public Table create(Table table) {
        tables.add(table);
        return table;
    }

    @Override
    public Table update(Table table) {
        return null;
    }

    @Override
    public void delete(String s) {
        Table table = findID(s);
        this.tables.remove(table);
    }

    @Override
    public Table read(String s) {
        Table table = findID(s);
        if(table.equals(s))
            return table;
        return null;
    }


    public Table findID(String s)
    {
        return tables.stream().filter(p -> p.getTableID().equals(s))
                .findFirst().orElse(null);


    }

}
