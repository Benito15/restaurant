package ac.za.cput.servicetest.report;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.domains.report.Report;
import ac.za.cput.factory.employeefactory.ManagerFactory;
import ac.za.cput.factory.reportfactory.ReportFactory;
import ac.za.cput.service.report.ReportService;
import ac.za.cput.service.report.impl.ReportServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportServiceImplTest {

    @Autowired
    private ReportService service;
    Date date;
    Employee manager;
    Report report;

    @Before
    public void setUp() throws Exception {
        this.service= ReportServiceImpl.getService();
        this.date = new Date();
        manager = ManagerFactory.getManager("Manager", "Employee", 0);
        report = ReportFactory.getReport(null, "This is report", manager.getEmpid());
    }

    @Test
    public void getAll() {
        Set<Report> getAllReports = this.service.getAll();
        System.out.println("Get all Reports: " + this.service.getAll().size());
        Assert.assertNotNull("Report service: ", service.getAll());
    }
    @Test
    public void create() {
        Report createReport = this.service.create(report);
        Assert.assertNotNull(createReport);

    }

    @Test
    public void update() {
        String newReport = "reportNew";
        Report createReport = this.service.create(report);
        Report readReport = this.service.read(createReport);
        Report updateReport = new Report.Builder().copy(readReport).description("UpdatedReport").build();
        this.service.update(updateReport);
        Assert.assertNotNull(updateReport);

    }

    @Test
    public void delete() {
        Report createReport = this.service.create(report);
        this.service.delete(createReport);
        Report deleteReport = this.service.read(createReport);
        Assert.assertNotNull(createReport);

    }

    @Test
    public void read() {
        Report createReport = this.service.create(report);
        Report readReport = this.service.read(createReport);
        Assert.assertNotNull(readReport);
    }
}