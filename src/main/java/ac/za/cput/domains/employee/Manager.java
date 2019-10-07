package ac.za.cput.domains.employee;

import javax.persistence.Entity;

@Entity
public class Manager extends Employee{

    public Manager(){}

    protected Manager(Builder builder)
    {
      super(builder);

    }



    public static class Builder extends Employee.Builder
    {


        public Manager build()
        {
            return new Manager(this);
        }
    }

    @Override
    public String toString() {
        return "Manager{" +
                "empid='" + empid + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
