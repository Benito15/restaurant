package ac.za.cput.servicetest.table;

import ac.za.cput.domains.table.Table;
import ac.za.cput.factory.tablefactory.TableFactory;
import ac.za.cput.service.table.impl.TableServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TableServiceImplTest {

 @Autowired
 private TableServiceImpl service;





    @Test
    public void create() {
        Table table = TableFactory.getGuest(2,true);
        this.service.create(table);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);

    }

    @Test
    public void update() {
        int newCapacity = 4;
        Table table = TableFactory.getGuest(2,true);
        Table table2 = TableFactory.getGuest(3,true);
        this.service.create(table);
        this.service.create(table2);
        Table updatedTable = TableFactory.getGuest(newCapacity,table.isIsavailable());
        this.service.update(updatedTable);
        Assert.assertTrue(updatedTable.getCapacity()> table2.getCapacity());


    }

    @Test
    public void delete() {
        Table table = TableFactory.getGuest(2,true);
        Table table2 = TableFactory.getGuest(3,true);
        this.service.create(table);
        this.service.create(table2);
        this.service.delete(table2.getTableID());
        Assert.assertTrue(this.service.getAll().size()>=1);

    }

    @Test
    public void read() {
        Table table = TableFactory.getGuest(2,true);
        Table table2 = TableFactory.getGuest(3,true);
        this.service.create(table);
        this.service.create(table2);
        Table readTable = this.service.read(table.getTableID());
        Assert.assertNotEquals(readTable.getTableID(), table2.getTableID());

    }
}