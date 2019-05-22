package ac.za.cput.service.report;

import ac.za.cput.domains.report.Report;
import ac.za.cput.service.IService;

import java.util.Set;

public interface ReportService extends IService<Report,String> {
    Set<Report> getAll();
}
