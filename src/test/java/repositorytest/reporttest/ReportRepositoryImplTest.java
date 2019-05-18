package repositorytest.reporttest;

import ac.za.cput.domains.report.Report;
import ac.za.cput.factory.reportfactory.ReportFactory;
import ac.za.cput.repositories.reportrepository.impl.ReportRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;

public class ReportRepositoryImplTest {

    private ReportRepositoryImpl repository = null;
    Date date;


    @Before
    public void setUp() throws Exception {
        this.repository = ReportRepositoryImpl.getRepository();
        this.date = new Date();
    }


    @Test
    public void getAll() {
        Set<Report> getAllReports = this.repository.getAll();
        System.out.println("Get all Reports: " + this.repository.getAll().size());
        Assert.assertNotNull("Report Repository: ", repository.getAll());
    }

    @Test
    public void create() {
        Report report= ReportFactory.getReport(date,"Report 1");
        this.repository.create(report);
        int size = this.repository.getAll().size();
        System.out.println(size);
        Assert.assertTrue("This repository is not 0", this.repository.getAll().size() >0);

    }

    @Test
    public void update() {
        String newReport = "reportNew";
        Report report = ReportFactory.getReport(date,"Report1");

        repository.create(report);
        System.out.println("Report 1: \n" + this.repository.getAll());
        System.out.println("----------------------------------------");
        report.setDescription(newReport);

        this.repository.update(report);
        System.out.println("After address update---------------------------");
        System.out.println(this.repository.getAll());
        Assert.assertEquals(newReport, report.getDescription());

    }

    @Test
    public void delete() {
        System.out.println(this.repository.getAll().size());
        System.out.println("--------------------------------");
        Report report = ReportFactory.getReport(date,"Report1");
        Report report2 = ReportFactory.getReport(date,"Report2");

        this.repository.create(report);
        this.repository.create(report2);
        System.out.println(this.repository.getAll().size());

        this.repository.delete(report.getRepID());
        System.out.println("After Delete");
        System.out.println(this.repository.getAll().size());
        Assert.assertNotNull(this.repository);
    }

    @Test
    public void read() {
        Report report = ReportFactory.getReport(date,"Report1");
        Report report2 = ReportFactory.getReport(date,"Report2");
        this.repository.create(report);
        this.repository.create(report2);
        System.out.println("Size after creating Objects->");
        System.out.println(this.repository.getAll().size());
        System.out.println("-------------------------------");
        Report readReport = this.repository.read(report.getRepID());
        System.out.println("Reading Object into new Object of type Supplier");
        System.out.println(readReport.getRepID());
        System.out.println("-----------------------------------");

        Assert.assertNotEquals(report2.getRepID(), readReport.getRepID());

    }



}