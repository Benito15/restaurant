package factorytest.employeetest;

import ac.za.cput.domains.employee.Manager;
import ac.za.cput.factory.employeefactory.ManagerFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestManager {

    @Test
    public void testManager() {

        String name = "Lorenxo";
        String surname = "Kriel";
        double salary = 2000;

        Manager manager = ManagerFactory.getManager(name,surname,salary);
        Assert.assertNotNull(manager.getEmpid());
    }
}
