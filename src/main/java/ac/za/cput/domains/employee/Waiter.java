package ac.za.cput.domains.employee;

import javax.persistence.Entity;

@Entity
public class Waiter extends Employee{


    public Waiter(){}

    protected Waiter(Builder builder){
       super(builder);

    }
    public static class Builder extends Employee.Builder {
        public Waiter build()
        {
            return new Waiter(this);
        }
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "empid='" + empid + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}


