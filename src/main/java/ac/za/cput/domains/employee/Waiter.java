package ac.za.cput.domains.employee;

public class Waiter extends Employee{


    private Waiter(){}

    private Waiter(Builder builder)
    {
       super(builder);

    }



    public static class Builder extends Employee.Builder
    {


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
