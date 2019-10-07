package ac.za.cput.repositories.reportrepository;

import ac.za.cput.domains.report.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepositoryHibernate extends CrudRepository<Report, String> {
}
