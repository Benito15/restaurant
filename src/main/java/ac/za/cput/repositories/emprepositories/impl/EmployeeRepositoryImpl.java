package ac.za.cput.repositories.emprepositories.impl;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.repositories.emprepositories.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositoryImpl implements EmployeeRepository
{

    private static EmployeeRepositoryImpl repository = null;
    private Set<Employee> employees;

    private EmployeeRepositoryImpl()
    {
        this.employees = new HashSet<>();
    }


    public static EmployeeRepository getRepository()
    {
        if(repository ==null) repository = new EmployeeRepositoryImpl();
        return repository;
    }





    @Override
    public Set<Employee> getAll() {
        return this.employees;
    }



    @Override
    public Employee create(Employee employee) {
        this.employees.add(employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }

    @Override
    public void delete(String s) {
        Employee employee = findID(s);
        this.employees.remove(s);

    }

    @Override
    public Employee read(String s) {
        Employee employee = findID(s);
        if(employees.equals(s))
            return employee;
        return null;
    }

    public Employee findID(String s)
    {
        return employees.stream().filter(o -> o.getEmpid().equals(s))
                .findFirst().orElse(null);
    }



}
