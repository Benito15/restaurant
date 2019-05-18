package ac.za.cput.repositories.reportrepository.impl;

import ac.za.cput.domains.report.Report;
import ac.za.cput.repositories.reportrepository.ReportRepository;

import java.util.*;

public class ReportRepositoryImpl implements ReportRepository {

    private static ReportRepositoryImpl repository = null;
    private Map<String,Report> reports;


    private ReportRepositoryImpl()
    {
        this.reports = new HashMap<>();

    }

    public static ReportRepositoryImpl getRepository()
    {
        if(repository == null) repository = new ReportRepositoryImpl();
        return repository;
    }



    @Override
    public Set<Report> getAll() {
        Collection<Report> reports = this.reports.values();
        Set<Report> set = new HashSet<>();
        set.addAll(reports);
        return set;
    }

    @Override
    public Report create(Report report) {
        this.reports.put(report.getRepID(), report);
        return report;
    }

    //// implementation still needs to be done!!
    @Override
    public Report update(Report report) {
        this.reports.replace(report.getRepID(), report);
        return this.reports.get(report.getRepID());
    }

    @Override
    public void delete(String s) {

        reports.remove(s);
    }

    @Override
    public Report read(String s) {
        return this.reports.get(s);
    }

//    public Report findID(String s)
//    {
//        return reports.stream().filter(report -> report.getRepID().equals(s))
//                .findAny().orElse(null);
//    }

}
