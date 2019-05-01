package ac.za.cput.domains.employee;

public class Cheff extends Employee {


    private Cheff(Builder builder)
    {
       super(builder);

    }




    public static class Builder extends Employee.Builder
    {



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
