package ac.za.cput.servicetest.report;

import ac.za.cput.domains.report.Report;
import ac.za.cput.factory.reportfactory.ReportFactory;
import ac.za.cput.service.report.impl.ReportServiceImpl;
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
public class ReportServiceImplTest {

    @Autowired
    private ReportServiceImpl service;


    @Test
    public void create() {
        Report report= ReportFactory.getReport(null,"REPORT");
        this.service.create(report);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);


    }

    @Test
    public void update() {
        String updateDescription = "Updated Description";
        Report report= ReportFactory.getReport(null,"REPORT");
        this.service.create(report);
        Report updateReport = ReportFactory.getReport(null, updateDescription);
        this.service.update(updateReport);
        Assert.assertTrue(updateReport.getDescription().contains(updateDescription));

    }

    @Test
    public void delete() {
        Report report= ReportFactory.getReport(null,"REPORT");
        Report report2= ReportFactory.getReport(null,"2 report");
        this.service.create(report);
        this.service.create(report2);
        this.service.delete(report2.getRepID());
        Assert.assertTrue(this.service.getAll().size()>=1);

    }

    @Test
    public void read() {
        Report report= ReportFactory.getReport(null,"REPORT");
        Report report2= ReportFactory.getReport(null,"2 report");
        this.service.create(report);
        this.service.create(report2);
        Report readReport = this.service.read(report.getRepID());
        Assert.assertNotEquals(readReport.getDescription(), report2.getDescription());

    }
}