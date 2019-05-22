package ac.za.cput.service.employee;

import ac.za.cput.domains.employee.Manager;
import ac.za.cput.service.IService;

import java.util.Set;

public interface ManagerService extends IService<Manager,String> {
    Set<Manager>getAll();
}
