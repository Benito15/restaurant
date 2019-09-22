package ac.za.cput.repositorytest.reporttest;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.domains.employee.Manager;
import ac.za.cput.domains.report.Report;
import ac.za.cput.factory.employeefactory.ManagerFactory;
import ac.za.cput.factory.reportfactory.ReportFactory;
import ac.za.cput.repositories.reportrepository.impl.ReportRepositoryImpl;
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
public class ReportRepositoryImplTest {


    @Autowired
    private ReportRepositoryImpl repository = null;
    Date date;
    Employee manager;
    Report report;

    @Before
    public void setUp() throws Exception {
        this.repository = ReportRepositoryImpl.getRepository();
        this.date = new Date();
        manager = ManagerFactory.getManager("Manager", "Employee", 0);
        report = ReportFactory.getReport(null, "This is report", manager.getEmpid());
    }


    @Test
    public void getAll() {
        Set<Report> getAllReports = this.repository.getAll();
        System.out.println("Get all Reports: " + this.repository.getAll().size());
        Assert.assertNotNull("Report Repository: ", repository.getAll());
    }

    @Test
    public void create() {
        Report createReport = this.repository.create(report);
        Assert.assertNotNull(createReport);

    }

    @Test
    public void update() {
        String newReport = "reportNew";
        Report createReport = this.repository.create(report);
        Report readReport = this.repository.read(createReport);
        Report updateReport = new Report.Builder().copy(readReport).description("UpdatedReport").build();
        this.repository.update(updateReport);
        Assert.assertNotNull(updateReport);


    }

    @Test
    public void delete() {
        Report createReport = this.repository.create(report);
        this.repository.delete(createReport);
        Report deleteReport = this.repository.read(createReport);
        Assert.assertNotNull(createReport);

    }

    @Test
    public void read() {
        Report createReport = this.repository.create(report);
        Report readReport = this.repository.read(createReport);
        Assert.assertNotNull(readReport);

    }



}