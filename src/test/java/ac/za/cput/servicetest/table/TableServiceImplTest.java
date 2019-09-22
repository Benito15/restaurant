package ac.za.cput.servicetest.table;

import ac.za.cput.domains.table.Table;
import ac.za.cput.factory.tablefactory.TableFactory;
import ac.za.cput.repositories.tablerepository.impl.TableRepositoryImpl;
import ac.za.cput.service.table.impl.TableServiceImpl;
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
public class TableServiceImplTest {

 @Autowired
 private TableServiceImpl service;

    @Before
    public void setUp() throws Exception {
        this.service = TableServiceImpl.getService();

    }

    @Test
    public void getAll() {
        Set<Table> getAllTables = this.service.getAll();
        System.out.println("In getAll Tables, all = " + ((Set) getAllTables).size());
        Assert.assertNotNull(service.getAll());

    }


    @Test
    public void create() {
        Table table = TableFactory.getTable(4,true);
        this.service.create(table);
        int size = this.service.getAll().size();
        System.out.println(size);
        Assert.assertTrue("this repository is not 0", this.service.getAll().size()>0);

    }

    @Test
    public void update() {
        boolean updateTable = true;
        Table table = TableFactory.getTable(4,false);
        Table table2 = TableFactory.getTable(2,true);

        service.create(table);
        service.create(table2);
        table.setIsavailable(updateTable);

        this.service.update(table);

        Table readUpdatedTable = this.service.read(table.getTableID());
        //System.out.println(readUpdatedTable);
        System.out.println(this.service.getAll());
        Assert.assertEquals(table, readUpdatedTable);


    }

    @Test
    public void delete() {
        System.out.println(this.service.getAll().size());
        System.out.println("------------------------------------");
        Table table = TableFactory.getTable(4,false);
        Table table2 = TableFactory.getTable(2,true);
        service.create(table);
        service.create(table2);
        System.out.println(this.service.getAll().size());

        service.delete(table2.getTableID());
        System.out.println("After Delete");
        System.out.println(this.service.getAll().size());
        //System.out.println(this.tablerepository.getAll());
        Assert.assertNotNull(this.service);

    }

    @Test
    public void read() {
        Table table = TableFactory.getTable(4,false);
        Table table2 = TableFactory.getTable(4,true);
        this.service.create(table);
        this.service.create(table2);
        Table readtable = this.service.read(table.getTableID());

        System.out.println("---------------");
        System.out.println(readtable.getTableID());

        //  this.tablerepository.create(readtable2);
        System.out.println("----Object in the repository-----");
        System.out.println(this.service.getAll().size());

        Assert.assertNotEquals(readtable.getTableID(),table2.getTableID());

    }
}