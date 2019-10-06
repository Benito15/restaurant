package ac.za.cput.repositories.emprepositories.impl;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.repositories.emprepositories.EmployeeRepository;

import java.util.*;

public class EmployeeRepositoryImpl implements EmployeeRepository
{

    private static EmployeeRepositoryImpl repository = null;
    private Map<String,Employee> employees;

    public EmployeeRepositoryImpl()
    {
        this.employees = new HashMap<>();
    }


    public static EmployeeRepository getRepository()
    {
        if(repository ==null) repository = new EmployeeRepositoryImpl();
        return repository;
    }





    @Override
    public Set<Employee> getAll() {
        Collection<Employee> employees = this.employees.values();
        Set<Employee> set = new HashSet<>();
        set.addAll(employees);
        return set;
    }



    @Override
    public Employee create(Employee employee) {
        this.employees.put(employee.getEmpid(),employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        this.employees.replace(employee.getEmpid(), employee);
        return this.employees.get(employee.getEmpid());
    }

    @Override
    public void delete(String s) {

        this.employees.remove(s);

    }

    @Override
    public Employee read(String s) {
        return this.employees.get(s);

    }

//    public Employee findID(String s)
//    {
//        return employees.stream().filter(o -> o.getEmpid().equals(s))
//                .findFirst().orElse(null);
//    }



}
