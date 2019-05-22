package ac.za.cput.service.report.impl;

import ac.za.cput.domains.report.Report;
import ac.za.cput.repositories.reportrepository.ReportRepository;
import ac.za.cput.repositories.reportrepository.impl.ReportRepositoryImpl;
import ac.za.cput.service.report.ReportService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ReportService")
public class ReportServiceImpl implements ReportService {

   private ReportServiceImpl service = null;
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
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Report read(String s) {
        return this.repository.read(s);
    }
}
