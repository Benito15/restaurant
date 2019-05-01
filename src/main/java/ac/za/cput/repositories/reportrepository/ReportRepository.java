package ac.za.cput.repositories.reportrepository;

import ac.za.cput.domains.report.Report;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface ReportRepository extends IRepository<Report, String> {

    Set<Report> getAll();

}
