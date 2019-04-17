package reporttest;

import ac.za.cput.domains.report.Report;
import ac.za.cput.factories.reportfactory.ReportFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestReport {

    @Test
    public void reportTest()
    {
        String dte = "17/04/2019";

        Report report = ReportFactory.getReport(dte);
        System.out.println(report);
        Assert.assertNotNull(report.getEmpID());

    }

}
