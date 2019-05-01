package domaintest.employeetest;

import ac.za.cput.domains.employee.Cheff;
import ac.za.cput.factory.employeefactory.CheffFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestCheff {


    @Test
    public void testCheff() {

        String name = "Lorenxo";
        String surname = "Kriel";
        double salary = 2000;

        Cheff cheff = CheffFactory.getCheff(name,surname,salary);
        Assert.assertNotNull(cheff.getEmpid());
    }


}
