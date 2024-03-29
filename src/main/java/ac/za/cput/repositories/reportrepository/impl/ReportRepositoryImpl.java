package ac.za.cput.repositories.reportrepository.impl;

import ac.za.cput.domains.report.Report;
import ac.za.cput.repositories.reportrepository.ReportRepository;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository("ReportInMemory")
public class ReportRepositoryImpl implements ReportRepository {

    private static ReportRepositoryImpl repository = null;
    private Set<Report> reports;


    public ReportRepositoryImpl()
    {
        this.reports = new HashSet<>();

    }

    public static ReportRepositoryImpl getRepository()
    {
        if(repository == null) repository = new ReportRepositoryImpl();
        return repository;
    }



    @Override
    public Set<Report> getAll() {


        return this.reports;
    }

    @Override
    public Report create(Report report) {
        this.reports.add(report);
        return report;
    }

    //// implementation still needs to be done!!
    @Override
    public Report update(Report report) {
        Report readReport = repository.read(report.getRepID());
        if (this.reports.contains(readReport)){
            this.reports.remove(readReport);
            this.reports.add(report);
            return report;

        }
        return null;
    }

    @Override
    public void delete(String report) {
        Report deleteReport = read(report);
        this.reports.remove(deleteReport);
    }

    @Override
    public Report read(String report) {
        return this.reports.stream()
                .filter(thisReport-> thisReport.getRepID().equalsIgnoreCase(report)
                        && thisReport.getEmpID().equalsIgnoreCase(report))
                .findAny().orElse(null);
    }




}
