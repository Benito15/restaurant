package factorytest.tabletest;

import ac.za.cput.domains.table.Table;
import ac.za.cput.factory.tablefactory.TableFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestTable {


    @Test
    public void tableTest()
    {
        int capacity = 5;
        boolean isAvailable = false;

        Table table = TableFactory.getGuest(capacity,isAvailable);
        System.out.println(table );
        Assert.assertNotNull(table.getCapacity());

    }


}
