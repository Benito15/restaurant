package ac.za.cput.service.employee;

import ac.za.cput.domains.employee.Cheff;
import ac.za.cput.service.IService;

import java.util.Set;

public interface CheffService extends IService <Cheff,String> {
    Set<Cheff> getAll();
}
