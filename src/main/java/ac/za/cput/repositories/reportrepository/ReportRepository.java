package ac.za.cput.repositories.reportrepository;

import ac.za.cput.domains.report.Report;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface ReportRepository  {


    Report create(Report report);
    Report read(Report report);
    Report update(Report report);
    void delete(Report report);
    Set<Report> getAll();


}
