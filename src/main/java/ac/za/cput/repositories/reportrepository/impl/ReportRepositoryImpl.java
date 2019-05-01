package ac.za.cput.repositories.reportrepository.impl;

import ac.za.cput.domains.report.Report;
import ac.za.cput.repositories.reportrepository.ReportRepository;

import java.util.HashSet;
import java.util.Set;

public class ReportRepositoryImpl implements ReportRepository {

    private static ReportRepositoryImpl repository = null;
    private Set<Report> reports;


    private ReportRepositoryImpl()
    {
        this.reports = new HashSet<>();

    }

    public static ReportRepository getRepository()
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
        return null;
    }

    @Override
    public void delete(String s) {
        Report report = findID(s);
        reports.remove(report);
    }

    @Override
    public Report read(String s) {
        Report report = findID(s);
        if (report.equals(s))
            return report;
        return null;
    }

    public Report findID(String s)
    {
        return reports.stream().filter(p -> p.getEmpID().equals(s))
                .findFirst().orElse(null);


    }




}
