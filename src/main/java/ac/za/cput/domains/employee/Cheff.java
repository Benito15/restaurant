package ac.za.cput.domains.employee;

public class Cheff {
    private String empid, name, surname;
    private double salary;

    private Cheff(){}

    private Cheff(Builder builder)
    {
        this.empid = builder.empid;
        this.name= builder.name;
        this.surname = builder.surname ;
        this.salary = builder.salary;

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

    public static class Builder
    {
        private String empid, name, surname;
        private double salary;

        public Builder empid(String empid)
        {
            this.empid = empid;
            return this;

        }

        public Builder name(String name)
        {
            this.name= name;
            return this;

        }

        public Builder surname(String surname)
        {
            this.surname= surname;
            return this;

        }

        public Builder salary(double salary)
        {
            this.salary=salary;
            return this;

        }

        public Cheff build()
        {
            return new Cheff(this);
        }
    }

    @Override
    public String toString() {
        return "Cheff{" +
                "empid='" + empid + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
