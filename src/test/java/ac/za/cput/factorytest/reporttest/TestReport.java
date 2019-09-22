package ac.za.cput.factorytest.reporttest;

import ac.za.cput.domains.report.Report;
import ac.za.cput.factory.reportfactory.ReportFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class TestReport {

    @Test
    public void reportTest()
    {
        Date dte = new Date();
        String description;
        Report report = ReportFactory.getReport(dte,"Wazzzup",null);
        System.out.println(report);
        Assert.assertNotNull(report);

    }

}
