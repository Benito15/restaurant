package ac.za.cput.service.report.impl;

import ac.za.cput.domains.report.Report;
import ac.za.cput.repositories.reportrepository.ReportRepository;
import ac.za.cput.repositories.reportrepository.ReportRepositoryHibernate;
import ac.za.cput.repositories.reportrepository.impl.ReportRepositoryImpl;
import ac.za.cput.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("ReportService")
public class ReportServiceImpl implements ReportService {

   private static ReportServiceImpl service = null;
   @Autowired
   private ReportRepositoryHibernate repository;

   private ReportServiceImpl()
   {

    }

    public static ReportServiceImpl getService()
    {
        if(service == null)return  new ReportServiceImpl();
        return  service;
    }


    @Override
    public Set<Report> getAll() {
        return new HashSet<Report>((List<Report>)repository.findAll());
    }

    @Override
    public Report create(Report type) {
        return repository.save(type);
    }

    @Override
    public Report update(Report type) {
        return this.repository.save(type);
    }

    @Override
    public void delete(String report) {
        Report deleteReport = read(report);
        this.repository.delete(deleteReport);
    }

    @Override
    public Report read(String report) {
        return getAll().stream()
                .filter(thisReport-> thisReport.getRepID().equalsIgnoreCase(report)
                        && thisReport.getEmpID().equalsIgnoreCase(report))
                .findAny().orElse(null);
    }

}
