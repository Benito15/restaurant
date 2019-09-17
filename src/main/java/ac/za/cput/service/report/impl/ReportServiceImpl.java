package ac.za.cput.service.report.impl;

import ac.za.cput.domains.report.Report;
import ac.za.cput.repositories.reportrepository.ReportRepository;
import ac.za.cput.repositories.reportrepository.impl.ReportRepositoryImpl;
import ac.za.cput.service.report.ReportService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ReportService")
public class ReportServiceImpl implements ReportService {

   private static ReportServiceImpl service = null;
   private ReportRepository repository;

   private ReportServiceImpl()
   {
       repository = ReportRepositoryImpl.getRepository();
   }

    public  ReportServiceImpl getService()
    {
        if(service == null)return  new ReportServiceImpl();
        return  service;
    }


    @Override
    public Set<Report> getAll() {
        return repository.getAll();
    }

    @Override
    public Report create(Report type) {
        return repository.create(type);
    }

    @Override
    public Report update(Report type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(Report report) {
        this.repository.delete(report);

    }

    @Override
    public Report read(Report report) {
        return this.repository.read(report);
    }
}
