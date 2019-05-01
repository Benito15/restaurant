package domaintest.reporttest;

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

        Report report = ReportFactory.getReport(dte);
        System.out.println(report);
        Assert.assertNotNull(report.getEmpID());

    }

}
