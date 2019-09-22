package ac.za.cput.repositorytest.tabletest;

import ac.za.cput.domains.table.Table;
import ac.za.cput.factory.tablefactory.TableFactory;
import ac.za.cput.repositories.tablerepository.TableRepository;
import ac.za.cput.repositories.tablerepository.impl.TableRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TableRepositoryImplTest {

    @Autowired
    private TableRepository tablerepository;


    @Before
    public void setUp() throws Exception {
        this.tablerepository = TableRepositoryImpl.getRepository();

    }

    @Test
    public void getAll() {
        Set<Table> getAllTables = this.tablerepository.getAll();
        System.out.println("In getAll Tables, all = " + ((Set) getAllTables).size());
        Assert.assertNotNull(tablerepository.getAll());

    }

    @Test
    public void create() {
        Table table = TableFactory.getTable(4,true);
        this.tablerepository.create(table);
        int size = this.tablerepository.getAll().size();
        System.out.println(size);
        Assert.assertTrue("this repository is not 0", this.tablerepository.getAll().size()>0);
    }

    @Test
    public void update() {
        boolean updateTable = true;
        Table table = TableFactory.getTable(4,false);
        Table table2 = TableFactory.getTable(2,true);

        tablerepository.create(table);
        tablerepository.create(table2);
        table.setIsavailable(updateTable);

        this.tablerepository.update(table);

        Table readUpdatedTable = this.tablerepository.read(table.getTableID());
        //System.out.println(readUpdatedTable);
        System.out.println(this.tablerepository.getAll());
        Assert.assertEquals(table, readUpdatedTable);

    }

    @Test
    public void delete() {
        System.out.println(this.tablerepository.getAll().size());
        System.out.println("------------------------------------");
        Table table = TableFactory.getTable(4,false);
        Table table2 = TableFactory.getTable(2,true);
        tablerepository.create(table);
        tablerepository.create(table2);
        System.out.println(this.tablerepository.getAll().size());

        tablerepository.delete(table2.getTableID());
        System.out.println("After Delete");
        System.out.println(this.tablerepository.getAll().size());
        //System.out.println(this.tablerepository.getAll());
        Assert.assertNotNull(this.tablerepository);
    }

    @Test
    public void read() {
        Table table = TableFactory.getTable(4,false);
        Table table2 = TableFactory.getTable(4,true);
        this.tablerepository.create(table);
        this.tablerepository.create(table2);
        Table readtable = this.tablerepository.read(table.getTableID());

        System.out.println("---------------");
        System.out.println(readtable.getTableID());

      //  this.tablerepository.create(readtable2);
        System.out.println("----Object in the repository-----");
        System.out.println(this.tablerepository.getAll().size());

        Assert.assertNotEquals(readtable.getTableID(),table2.getTableID());

    }


}