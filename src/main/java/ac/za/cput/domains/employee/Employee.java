package ac.za.cput.domains.employee;

import java.util.Objects;

public abstract class Employee {

    protected String empid, name, surname;
    protected double salary;

    public Employee(){}

    protected Employee(Builder builder)
    {
        this.empid = builder.empid;
        this.name= builder.name;
        this.surname = builder.surname ;
        this.salary = builder.salary;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmpid() {
        return empid;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getSalary() {
        return salary;
    }

    public static abstract class Builder{
        private String empid, name, surname;
        private double salary;

        public Builder empid(String empid){
            this.empid = empid;
            return this;
        }

        public Builder name(String name){
            this.name= name;
            return this;

        }

        public Builder surname(String surname){
            this.surname= surname;
            return this;
        }

        public Builder salary(double salary){
            this.salary=salary;
            return this;
        }

        public abstract Employee build();
    }


    @Override
    public String toString() {
        return "employee{" +
                "empid='" + empid + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getEmpid(), employee.getEmpid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmpid());
    }
}
