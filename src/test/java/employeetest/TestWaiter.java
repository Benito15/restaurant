package employeetest;

import ac.za.cput.domains.employee.Waiter;
import ac.za.cput.factories.employeefactory.WaiterFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestWaiter {

    @Test
    public void testWaiter() {

        String name = "Berenice";
        String surname = "Swarcl";
        double salary = 20000;

        Waiter waiter = WaiterFactory.getWaiter(name,surname,salary);
        Assert.assertNotNull(waiter.getEmpid());
    }

}
