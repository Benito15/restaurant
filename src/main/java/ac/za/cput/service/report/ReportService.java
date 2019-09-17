package ac.za.cput.service.report;

import ac.za.cput.domains.report.Report;
import ac.za.cput.service.IService;

import java.util.Set;

public interface ReportService  {
    Report create(Report report);
    Report read(Report report);
    Report update(Report report);
    void delete(Report report);
    Set<Report> getAll();
}
